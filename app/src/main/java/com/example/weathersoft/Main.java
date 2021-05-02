package com.example.weathersoft;

import com.google.gson.annotations.SerializedName;

public class Main {


    @SerializedName("temp")
    String temp;

    @SerializedName("humidity")
    String humidity;

    @SerializedName("feels_like")
    String feels_like;

    @SerializedName("pressure")
    String pressure;

    @SerializedName("speed")
    String speed;

    @SerializedName("description")
    String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getFeels_like() {
        return feels_like;
    }

    public void setFeels_like(String feels_like) {
        this.feels_like = feels_like;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }


}
