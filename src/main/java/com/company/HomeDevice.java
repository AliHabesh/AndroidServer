package com.company;

public class HomeDevice {
    private String light;
    private String door;
    private String window;

    public HomeDevice(String light, String door, String window) {
        this.light = light;
        this.door = door;
        this.window = window;
    }

    public String getLight() {
        return light;
    }

    public void setLight(String light) {
        this.light = light;
    }

    public String getDoor() {
        return door;
    }

    public void setDoor(String door) {
        this.door = door;
    }

    public String getWindow() {
        return window;
    }

    public void setWindow(String window) {
        this.window = window;
    }

    @Override
    public String toString() {
        return "HomeDevice{" +
                "light='" + light + '\'' +
                ", door='" + door + '\'' +
                ", window='" + window + '\'' +
                '}';
    }
}
