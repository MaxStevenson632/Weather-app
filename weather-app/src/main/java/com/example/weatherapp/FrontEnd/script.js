let weatherData = null; // Global storage for the fetched data

async function getWeather() {
    const location = document.getElementById("location").value;
    const getLocationUI = document.getElementById("getLocationScreen");
    const resultUI = document.getElementById("result");

    try {
        const response = await fetch(`http://localhost:8080/weather?location=${location}`);
        if (!response.ok) throw new Error("Location not found");

        weatherData = await response.json();

        getLocationUI.classList.add("hidden");
        resultUI.classList.remove("hidden");

        // Set initial view
        showCurrent();
        document.getElementById('nameDisplay').innerText = `City: ${weatherData.current.name}`;

    } catch (error) {
        alert(error.message);
    }
}

async function getTopFiveCities() {
    console.log("hello world");
    try {
        const response = await fetch("http://localhost:8080/cities");
        if(!response.ok) throw new Error("URL not found");

        const cities = await response.json();

        const cityElement = document.getElementById("topCitiesList");

        cityElement.innerHTML = "";

        cities.forEach(entry => {
            const li = document.createElement("li");
            const cityName = entry.split(",");
            li.textContent = cityName[0];
            cityElement.appendChild(li);
        })

    } catch (error) {

    console.error('Error fetching cities:', error);
    document.getElementById('topCitiesList').innerHTML = '<li>Error loading data</li>';
    }
}

function showCurrent() {
    if (!weatherData) return;

    // UI Toggles
    document.getElementById("currentWeatherContainer").classList.remove("hidden");
    document.getElementById("forecastContainer").classList.add("hidden");

    // Button Shadow Toggles
    document.getElementById("buttonCurrent").classList.add("active");
    document.getElementById("buttonForecast").classList.remove("active");

    displayCurrentWeather(weatherData);
}

function showForecast() {
    if (!weatherData) return;

    // UI Toggles
    document.getElementById("currentWeatherContainer").classList.add("hidden");
    document.getElementById("forecastContainer").classList.remove("hidden");

    // Button Shadow Toggles
    document.getElementById("buttonForecast").classList.add("active");
    document.getElementById("buttonCurrent").classList.remove("active");

    displayForecast(weatherData.forecast);
}

function displayCurrentWeather(jsonData) {
    const { temp, humidity, feels_like } = jsonData.current.main;
    const { main, description } = jsonData.current.weather[0];
    const { speed } = jsonData.current.wind;

    updateText(`tempDisplay`, `Temperature: ${temp}\u00B0C`);
    updateText(`humidityDisplay`, `Humidity: ${humidity}%`);
    updateText(`feelsLikeDisplay`, `Feels like: ${feels_like}\u00B0C`);
    updateText(`mainWeatherDisplay`, `Weather: ${main}`);
    updateText(`weatherDescriptionDisplay`, `Description: ${description}`);
    updateText(`windSpeedDisplay`, `Wind speed: ${speed} m/s`);
}

function displayForecast(forecastListArray) {
    const listElement = document.getElementById("forecastList");
    listElement.innerHTML = "";

    forecastListArray.list.forEach(entry => {
        const card = document.createElement("div");
        card.className = "forecast-card";
        const time = entry.dt_txt.split(" ")[1].substring(0, 5);

        card.innerHTML = `
            <strong>${time}</strong> 
            <p>${entry.main.temp}\u00B0C</p>
            <small>${entry.weather[0].main}</small>
        `;
        listElement.appendChild(card);
    });
}

function updateText(idOfElement, textToDisplay) {
    const container = document.getElementById("result");
    var element = container.querySelector("#" + idOfElement);
    element.innerText = textToDisplay;
}

getTopFiveCities();