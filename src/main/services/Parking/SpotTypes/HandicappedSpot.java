package src.main.services.Parking.SpotTypes;

import src.main.enums.ParkingSpotTypes;
import src.main.services.Parking.ParkingSpot;

public class HandicappedSpot extends ParkingSpot {
    public HandicappedSpot(String number) {
        super(ParkingSpotTypes.HANDICAPPED, number);
    }
}
