package src.main;

import src.main.enums.ParkingSpotTypes;
import src.main.services.Parking.ParkingFloor;
import src.main.services.Parking.ParkingLot;
import src.main.services.Parking.ParkingTicket;
import src.main.services.Parking.SpotTypes.ParkingSpot;
import src.main.services.panels.EntrancePanel;
import src.main.services.panels.ExitPanel;
import src.main.services.vehicle.Electric;
import src.main.services.vehicle.Vehicle;
import src.main.users.Admin;

public class JioParking {
    public static void main(String[] args) {
        Admin admin = new Admin();
        ParkingLot parkingLot = ParkingLot.getInstance();
        ParkingFloor parkingFloor = new ParkingFloor("Vinayak");
        ParkingFloor parkingFloor2 = new ParkingFloor("Ankur");
        admin.addParkingFloor(parkingFloor);
        admin.addParkingFloor(parkingFloor2);

        admin.addParkingSpot("Vinayak",new ParkingSpot(ParkingSpotTypes.COMPACT,"1"));
        admin.addParkingSpot("Vinayak",new ParkingSpot(ParkingSpotTypes.COMPACT,"2"));
        admin.addParkingSpot("Vinayak",new ParkingSpot(ParkingSpotTypes.COMPACT,"3"));
        admin.addParkingSpot("Ankur",new ParkingSpot(ParkingSpotTypes.LARGE,"1"));
        admin.addParkingSpot("Ankur",new ParkingSpot(ParkingSpotTypes.LARGE,"2"));
        admin.addParkingSpot("Ankur",new ParkingSpot(ParkingSpotTypes.LARGE,"3"));

        //parkingFloor2.displayFloor();
        Vehicle vehicle = new Electric("UP93-BG-5667");
        EntrancePanel entrancePanel = new EntrancePanel("Entry1");
        ParkingTicket ticket = entrancePanel.printTicket(vehicle);
        parkingLot.display.displayFull();
        //parkingFloor2.displayFloor();
        ExitPanel exitPanel = new ExitPanel("Exit1");

        exitPanel.processPayment(ticket);
        parkingLot.display.displayFull();
    }
}
