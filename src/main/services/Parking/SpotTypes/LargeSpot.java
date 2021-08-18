package src.main.services.Parking.SpotTypes;

import src.main.enums.ParkingSpotTypes;
import src.main.services.Parking.ParkingSpot;

public class LargeSpot extends ParkingSpot {
    public LargeSpot(String number) {
        super(ParkingSpotTypes.LARGE, number);
    }
}
