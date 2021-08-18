package src.main.services.Parking.SpotTypes;

import src.main.enums.ParkingSpotTypes;
import src.main.services.Parking.ParkingSpot;

public class CompactSpot extends ParkingSpot {
    public CompactSpot(String number) {
        super(ParkingSpotTypes.COMPACT, number);
    }
}
