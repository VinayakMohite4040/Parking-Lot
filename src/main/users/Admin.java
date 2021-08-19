package src.main.users;

import src.main.services.Parking.ParkingFloor;
import src.main.services.Parking.ParkingLot;
import src.main.services.Parking.SpotTypes.ParkingSpot;
import src.main.services.models.Account;
import src.main.services.panels.EntrancePanel;
import src.main.services.panels.ExitPanel;

public class Admin extends Account {
    public Boolean addParkingFloor(ParkingFloor floor){
        ParkingLot obj = ParkingLot.getInstance();
        return obj.addParkingFloor(floor);
    }
    public void addParkingSpot(String floorName, ParkingSpot spot){
        ParkingLot obj = ParkingLot.getInstance();
        obj.addParkingSpot(floorName,spot);
    }

    public EntrancePanel addEntrancePanel(String name){
        EntrancePanel entrancePanel = new EntrancePanel(name);
        ParkingLot obj = ParkingLot.getInstance();
        obj.addEntrancePanel(entrancePanel);
        return entrancePanel;
    }
    public ExitPanel addExitPanel(String name){
        ExitPanel exitPanel = new ExitPanel(name);
        ParkingLot obj = ParkingLot.getInstance();
        obj.addExitPanel(exitPanel);
        return exitPanel;
    }
}