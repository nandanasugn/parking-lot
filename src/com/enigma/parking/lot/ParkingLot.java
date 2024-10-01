package com.enigma.parking.lot;

import com.enigma.parking.lot.models.Vehicle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParkingLot {
    private final Map<Integer, Vehicle> parkingSlots = new HashMap<>();
    private final int capacity;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public String park(Vehicle vehicle) {
        for (int i = 1; i <= capacity; i++) {
            if (!parkingSlots.containsKey(i)) {
                parkingSlots.put(i, vehicle);
                return "Allocated slot number: " + i;
            }
        }
        return "Sorry, parking lot is full";
    }

    public String leave(int slotNumber) {
        if (parkingSlots.containsKey(slotNumber)) {
            parkingSlots.remove(slotNumber);
            return "Slot number " + slotNumber + " is free";
        }
        return "Slot number " + slotNumber + " is already empty";
    }

    public void status() {
        System.out.println("Slot\tNo.\t\tType\tRegistration No\tColour");
        for (var entry : parkingSlots.entrySet()) {
            Vehicle vehicle = entry.getValue();
            System.out.printf("%d\t%s\t%s\t%s\t%s%n",
                    entry.getKey(),
                    vehicle.getLicensePlate(),
                    vehicle.getType(),
                    vehicle.getLicensePlate(),
                    vehicle.getColor());
        }
    }

    public long countByType(String type) {
        return parkingSlots.values().stream()
                .filter(v -> v.getType().equalsIgnoreCase(type))
                .count();
    }

    public List<String> getRegistrationNumbersByOddOrEven(boolean odd) {
        return parkingSlots.values().stream()
                .filter(v -> v.isOddPlate() == odd)
                .map(Vehicle::getLicensePlate)
                .collect(Collectors.toList());
    }

    public List<String> getRegistrationNumbersByColor(String color) {
        return parkingSlots.values().stream()
                .filter(v -> v.getColor().equalsIgnoreCase(color))
                .map(Vehicle::getLicensePlate)
                .collect(Collectors.toList());
    }

    public List<Integer> getSlotNumbersByColor(String color) {
        return parkingSlots.entrySet().stream()
                .filter(e -> e.getValue().getColor().equalsIgnoreCase(color))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public String getSlotNumberByRegistration(String licensePlate) {
        return parkingSlots.entrySet().stream()
                .filter(e -> e.getValue().getLicensePlate().equalsIgnoreCase(licensePlate))
                .map(Map.Entry::getKey)
                .map(Object::toString)
                .findFirst()
                .orElse("Not found");
    }
}
