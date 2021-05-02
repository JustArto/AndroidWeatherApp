package com.example.weathersoft;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

class Example {

    @SerializedName("main")
    private Main main;

    @SerializedName("wind")
    private Main wind;

  /*  @SerializedName("weather")
    private List<Main> weatherForecastList;

    public Example() {
        weatherForecastList = new ArrayList<Main>();
    }
    public void addWeatherForecast(Main forecast) {
        weatherForecastList.add(forecast);
    }*/



/*    @SerializedName("weather")
    private Main weather;

    public Main getWeather() {
        return weather;
    }*/

/*    public List<Main> getWeatherForecastList() {
        return weatherForecastList;
    }

    public void setWeatherForecastList(List<Main> weatherForecastList) {
        this.weatherForecastList = weatherForecastList;
    }*/

    public Main getWind() {
        return wind;
    }

    public void setWind(Main wind) {
        this.wind = wind;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }
}
