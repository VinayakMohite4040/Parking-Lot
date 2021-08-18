package src.main.services.Parking.SpotTypes;

import src.main.enums.ParkingSpotTypes;
import src.main.services.Parking.ParkingSpot;

public class MotorCycleSpot extends ParkingSpot {
    public MotorCycleSpot(String number) {
        super(ParkingSpotTypes.MOTORCYCLE, number);
    }
}
