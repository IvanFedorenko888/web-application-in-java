package ru.fedorenko.Domain;

public class AircraftEntity {
    private String aircraft_code; // Код самолета
    private String model; // Модель самолета
    private Integer range;

    public AircraftEntity(){
    }

    public AircraftEntity(String aircraft_code, String model, Integer range)
    {
        this.aircraft_code = aircraft_code;
        this.model = model;
        this.range = range;
    }
    public String getAircraft_code() {
        return aircraft_code;
    }

    public void setAircraft_code(String aircraft_code) {
        this.aircraft_code = aircraft_code;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getRange() {
        return range;
    }

    public void setRange(Integer range) {
        this.range = range;
    }

}
