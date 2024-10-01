package com.enigma.parking.lot.models;

public class Vehicle {
    String licensePlate;
    String color;
    String type; // "Car" or "Motorbike"

    public Vehicle(String licensePlate, String color, String type) {
        this.licensePlate = licensePlate;
        this.color = color;
        this.type = type;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }

    public boolean isOddPlate() {
        String[] parts = licensePlate.split("-");
        int number = Integer.parseInt(parts[1]);
        return number % 2 != 0;
    }
}
