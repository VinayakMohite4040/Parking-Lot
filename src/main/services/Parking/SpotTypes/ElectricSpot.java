package src.main.services.Parking.SpotTypes;

import src.main.enums.ParkingSpotTypes;
import src.main.services.Parking.ParkingSpot;

public class ElectricSpot extends ParkingSpot {
    public ElectricSpot(String number) {
        super(ParkingSpotTypes.ELECTRIC, number);
    }
}
