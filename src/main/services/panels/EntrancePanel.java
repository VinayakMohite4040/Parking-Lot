package src.main.services.panels;

import src.main.services.Parking.ParkingLot;
import src.main.services.Parking.ParkingTicket;
import src.main.services.vehicle.Vehicle;

public class EntrancePanel {
    private String id;

    public EntrancePanel(String id)
    {
        this.id = id;
    }
    public String getId()
    {
        return this.id;
    }
    public Boolean printTicket(Vehicle vehicle) {
        ParkingLot obj = ParkingLot.getInstance();
        ParkingTicket ticket = obj.getNewParkingTicket(vehicle);
        return true;
    }
}