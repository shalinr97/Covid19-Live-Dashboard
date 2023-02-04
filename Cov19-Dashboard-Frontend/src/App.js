import {
  MenuItem,
  Select,
  FormControl,
  Card,
  CardContent,
} from "@mui/material";
import React, { useEffect, useState } from "react";
import "./App.css";
import "leaflet/dist/leaflet.css";

import InfoBox from "./InfoBox";
import Map from "./Map";
import Table from "./Table";
import { sortData, prettyPrintStat, prettyPrintTotStat } from "./util.js";

function App() {
  const [countries, setCountries] = useState([]);
  const [country, setCountry] = useState("worldwide");
  const [countryInfo, setCountryInfo] = useState({});
  const [vaccineTotal, setVaccineTotal] = useState(0);
  const [vaccineInfo, setVaccineInfo] = useState(0);
  const [tableData, setTableData] = useState([]);
  const [mapCenter, setMapCenter] = useState({
    lat: 34.80746,
    lng: -40.4796,
  });
  const [mapZoom, setMapZoom] = useState(3);
  const [mapCountries, setMapCountries] = useState([]);
  const [casesType, setCasesType] = useState("cases");
  const covid_all_url = "http://localhost:9090/v1/dash/cov19/all";
  const covid_countries_url = "http://localhost:9090/v1/dash/cov19/countries";
  const covid_vaccine_url_all = "http://localhost:9090/v1/dash/cov19/vaccine/coverage/countries/all/5";
  const covid_vaccine_url_country = "http://localhost:9090/v1/dash/cov19/vaccine/coverage/countries/{countrycode}/5";

  useEffect(() => {
    fetch(covid_all_url)
      .then((res) => res.json())
      .then((data) => {
        setCountryInfo(data);
      });
  }, []);

  useEffect(() => {
    fetch(covid_vaccine_url_all)
    .then(res => res.json())
    .then((data) => {
      const today = data[Object.keys(data)[4]] - data[Object.keys(data)[0]]
      const total = data[Object.keys(data)[1]]
      setVaccineTotal(total)
      setVaccineInfo(today)
    });
  }, []);

  useEffect(() => {
    const getCountries = async () => {
      await fetch(covid_countries_url)
        .then((res) => res.json())
        .then((data) => {
          const countries = data.map((country) => ({
            name: country.country,
            value: country.countryInfo.iso2,
          }));
          const sortedData = sortData(data);
          setTableData(sortedData); 
          setCountries(countries);
          setMapCountries(data);
        });
    };

    getCountries();
  }, []);

  const onCountryChange = async (event) => {
    const countryCode = event.target.value;

    const url =
      countryCode === "worldwide"
        ? covid_all_url
        : covid_countries_url + "/" + countryCode;
    
    let country_coverage = covid_vaccine_url_country;
    country_coverage = country_coverage.replace("{countrycode}", countryCode)
    const covid_url = 
      countryCode === "worldwide" 
      ? covid_vaccine_url_all 
      : country_coverage; 

    await fetch(url)
      .then((res) => res.json())
      .then((data) => {
        setCountry(countryCode);
        setCountryInfo(data);
        setMapCenter({
          lat: data.countryInfo.lat,
          lng: data.countryInfo.long,
        });
        // setMapCenter([data.countryInfo.lat, data.countryInfo.long]);
        setMapZoom(4);
      });
  

  await fetch(covid_url)
  .then(res => res.json())
  .then(data => {
    const today = data.timeline[Object.keys(data.timeline)[4]] - data.timeline[Object.keys(data.timeline)[0]]
    const total = data.timeline[Object.keys(data.timeline)[1]]
    setVaccineTotal(total)
    setVaccineInfo(today)
    // const total = data.timeline[Object.keys(data.timeline)[0]]
    // setVaccineInfo(total)
  }) 
  };


  return (
    <div className="app">
      <div className="app__left">
        <div className="app__header">
          <h1>COVID-19 DASHBOARD LIVE</h1>
          <FormControl className="app__dropdown">
            <Select
              variant="outlined"
              value={country}
              onChange={onCountryChange}
            >
              <MenuItem value="worldwide">Worldwide</MenuItem>
              {countries.map((country) => (
                <MenuItem value={country.value}>{country.name}</MenuItem>
              ))}
            </Select>
          </FormControl>
        </div>

        <div className="app__stats">
          <InfoBox
            title="Total Cases"
            isRed
            active={casesType === "cases"}
            total={prettyPrintTotStat(countryInfo.cases)}
            cases={prettyPrintStat(countryInfo.todayCases)}
            onClick={(e) => setCasesType("cases")}
          />
          <InfoBox
            title="Total Recovered"
            active={casesType === "recovered"}
            total={prettyPrintTotStat(countryInfo.recovered)}
            cases={prettyPrintStat(countryInfo.todayRecovered)}
            onClick={(e) => setCasesType("recovered")}
          />
          <InfoBox
            title="Total Deaths"
            isRed
            active={casesType === "deaths"}
            total={prettyPrintTotStat(countryInfo.deaths)}
            cases={prettyPrintStat(countryInfo.todayDeaths)}
            onClick={(e) => setCasesType("deaths")}
          />
          <InfoBox
            title="Total Vaccine Coverage"
            active={casesType === "vaccine"}
            total={prettyPrintTotStat(vaccineTotal)}
            cases={prettyPrintTotStat(vaccineInfo)}
            onClick={(e) => setCasesType("vaccine")}
          />
          {/* <InfoBox
            title="Total Tests"
            isRed
            active={casesType === "tests"}
            total={prettyPrintTotStat(countryInfo.deaths)}
            cases={prettyPrintStat(countryInfo.todayDeaths)}
            onClick={(e) => setCasesType("deaths")}
          /> */}
        </div>
        <br></br>
        <div className="app__stats">
        {/* <InfoBox
            title="Alert Level"
            isRed
            active={casesType === "cases"}
            total={prettyPrintTotStat(countryInfo.active)}
            cases={prettyPrintStat(countryInfo.todayCases)}
            onClick={(e) => setCasesType("cases")}
          /> */}
          
        </div>

        <Map
          countries={mapCountries}
          center={mapCenter}
          zoom={mapZoom}
          casesType={casesType}
        />
      </div>
      <Card className="app__right">
        <CardContent>
          <h3>Active Cases by Country</h3>
          <Table countries={tableData} />
        </CardContent>
        {/* <LineChart casesType="cases" /> */}
      </Card>
    </div>
  );
}

export default App;
