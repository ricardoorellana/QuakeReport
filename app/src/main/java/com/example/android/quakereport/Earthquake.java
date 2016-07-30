package com.example.android.quakereport;

/**
 * Created by Rorellanam on 7/26/16.
 */
public class Earthquake {

    private double magnitude;
    private String location;
    private Long timeInMilliSeconds;
    private String url;

    public Earthquake() {
    }

    /**
     * Constructs a new {@link Earthquake} object.
     *
     * @param magnitude is the magnitude (size) of the earthquake
     * @param location is the city location of the earthquake
     * @param timeInMilliSeconds is the time in milliseconds (from the Epoch) when the
     *                           earthquake happened
     */
    public Earthquake(double magnitude, String location, Long timeInMilliSeconds, String url) {
        this.magnitude = magnitude;
        this.location = location;
        this.timeInMilliSeconds = timeInMilliSeconds;
        this.url = url;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getTimeInMilliSeconds() {
        return timeInMilliSeconds;
    }

    public void setTimeInMilliSeconds(Long date) {
        this.timeInMilliSeconds = date;
    }

    public String getUrl() {
        return url;
    }

}
