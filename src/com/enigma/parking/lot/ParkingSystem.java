package com.enigma.parking.lot;

import com.enigma.parking.lot.models.Vehicle;

import java.util.Scanner;

public class ParkingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ParkingLot parkingLot = null;

        while (true) {
            String input = scanner.nextLine();
            String[] command = input.split(" ");

            switch (command[0]) {
                case "create_parking_lot":
                    int capacity = Integer.parseInt(command[1]);
                    parkingLot = new ParkingLot(capacity);
                    System.out.println("Created a parking lot with " + capacity + " slots");
                    break;
                case "park":
                    if (parkingLot == null) {
                        System.out.println("Parking lot is not created yet.");
                        break;
                    }
                    String licensePlate = command[1];
                    String color = command[2];
                    String type = command[3];
                    Vehicle vehicle = new Vehicle(licensePlate, color, type);
                    System.out.println(parkingLot.park(vehicle));
                    break;
                case "leave":
                    if (parkingLot == null) {
                        System.out.println("Parking lot is not created yet.");
                        break;
                    }
                    int slotNumber = Integer.parseInt(command[1]);
                    System.out.println(parkingLot.leave(slotNumber));
                    break;
                case "status":
                    if (parkingLot != null) {
                        parkingLot.status();
                    } else {
                        System.out.println("Parking lot is not created yet.");
                    }
                    break;
                case "type_of_vehicles":
                    if (parkingLot == null) {
                        System.out.println("Parking lot is not created yet.");
                        break;
                    }
                    String vehicleType = command[1];
                    System.out.println(parkingLot.countByType(vehicleType));
                    break;
                case "registration_numbers_for_vehicles_with_ood_plate":
                    if (parkingLot == null) {
                        System.out.println("Parking lot is not created yet.");
                        break;
                    }
                    System.out.println(String.join(", ", parkingLot.getRegistrationNumbersByOddOrEven(true)));
                    break;
                case "registration_numbers_for_vehicles_with_event_plate":
                    if (parkingLot == null) {
                        System.out.println("Parking lot is not created yet.");
                        break;
                    }
                    System.out.println(String.join(", ", parkingLot.getRegistrationNumbersByOddOrEven(false)));
                    break;
                case "registration_numbers_for_vehicles_with_colour":
                    if (parkingLot == null) {
                        System.out.println("Parking lot is not created yet.");
                        break;
                    }
                    String colorQuery = command[1];
                    System.out.println(String.join(", ", parkingLot.getRegistrationNumbersByColor(colorQuery)));
                    break;
                case "slot_numbers_for_vehicles_with_colour":
                    if (parkingLot == null) {
                        System.out.println("Parking lot is not created yet.");
                        break;
                    }
                    String colorForSlots = command[1];
                    System.out.println(parkingLot.getSlotNumbersByColor(colorForSlots).toString());
                    break;
                case "slot_number_for_registration_number":
                    if (parkingLot == null) {
                        System.out.println("Parking lot is not created yet.");
                        break;
                    }
                    String regNumber = command[1];
                    System.out.println(parkingLot.getSlotNumberByRegistration(regNumber));
                    break;
                case "exit":
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid command");
            }
        }
    }
}
