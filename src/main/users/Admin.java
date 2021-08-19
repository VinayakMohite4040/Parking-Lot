package src.main.users;

import src.main.services.Parking.ParkingFloor;
import src.main.services.Parking.ParkingLot;
import src.main.services.Parking.SpotTypes.ParkingSpot;
import src.main.services.models.Account;

public class Admin extends Account {
    public Boolean addParkingFloor(ParkingFloor floor){
        ParkingLot obj = ParkingLot.getInstance();
        return obj.addParkingFloor(floor);
    }
    public void addParkingSpot(String floorName, ParkingSpot spot){
        ParkingLot obj = ParkingLot.getInstance();
        ParkingFloor floor = obj.getParkingFloor(floorName);
        floor.addParkingSpot(spot);
    }
}