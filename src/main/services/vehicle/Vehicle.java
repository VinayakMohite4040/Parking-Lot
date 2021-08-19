package src.main.services.vehicle;

import src.main.enums.VehicleType;
import src.main.services.Parking.ParkingTicket;

public abstract class Vehicle {
    private String licenseNumber;
    private final VehicleType type;
    private ParkingTicket ticket;

    public Vehicle(VehicleType type, String licenseNumber) {
        this.type = type;
        this.licenseNumber = licenseNumber;
    }

    public void assignTicket(ParkingTicket ticket) {
        this.ticket = ticket;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public VehicleType getType() {
        return type;
    }

    public ParkingTicket getTicket() {
        return ticket;
    }
}