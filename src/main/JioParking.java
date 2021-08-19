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
    public static void main(String[] args)  {
        Admin admin = new Admin();
        ParkingLot parkingLot = ParkingLot.getInstance();
        Vehicle vehicle = new Electric("UP93-BG-5667");
        Vehicle vehicle1 = new Electric("MPyt76767676");
        EntrancePanel entrancePanel = admin.addEntrancePanel("Entrance1");
        ExitPanel exitPanel = admin.addExitPanel("Exit1");

        ParkingFloor parkingFloor = new ParkingFloor("Vinayak");
        ParkingFloor parkingFloor2 = new ParkingFloor("Ankur");
        ParkingFloor parkingFloor3 = new ParkingFloor("Shyam");
        admin.addParkingFloor(parkingFloor);
        admin.addParkingFloor(parkingFloor2);
        admin.addParkingFloor(parkingFloor3);


        admin.addParkingSpot("Vinayak",new ParkingSpot(ParkingSpotTypes.COMPACT,"1"));
        admin.addParkingSpot("Vinayak",new ParkingSpot(ParkingSpotTypes.LARGE,"1"));
        admin.addParkingSpot("Vinayak",new ParkingSpot(ParkingSpotTypes.LARGE,"2"));
        admin.addParkingSpot("Ankur",new ParkingSpot(ParkingSpotTypes.LARGE,"1"));
        admin.addParkingSpot("Ankur",new ParkingSpot(ParkingSpotTypes.COMPACT,"1"));
        admin.addParkingSpot("Ankur",new ParkingSpot(ParkingSpotTypes.MOTORCYCLE,"1"));
        admin.addParkingSpot("Shyam",new ParkingSpot(ParkingSpotTypes.ELECTRIC,"1"));
        admin.addParkingSpot("Shyam",new ParkingSpot(ParkingSpotTypes.MOTORCYCLE,"1"));
        admin.addParkingSpot("Shyam",new ParkingSpot(ParkingSpotTypes.COMPACT,"1"));



        ParkingTicket ticket = entrancePanel.printTicket(vehicle);
        ParkingTicket ticket1 = entrancePanel.printTicket(vehicle1);
        parkingLot.display.displayFull();
        //parkingFloor2.displayFloor();

        exitPanel.processPayment(ticket);
        parkingLot.display.displayFull();
        System.out.println(ticket);
    }
}
