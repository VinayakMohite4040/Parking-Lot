package src.main.services.Parking;

import src.main.enums.ParkingSpotTypes;
import src.main.enums.VehicleType;
import src.main.services.Parking.SpotTypes.*;

import java.util.HashMap;
import java.util.Map;

public class ParkingFloor {
    private String name;
    private HashMap<String, HandicappedSpot> handicappedSpots;
    private HashMap<String, CompactSpot> compactSpots;
    private HashMap<String, LargeSpot> largeSpots;
    private HashMap<String, MotorCycleSpot> motorcycleSpots;
    private HashMap<String, ElectricSpot> electricSpots;
    private HashMap<String, CustomerInfoPortal> infoPortals;
    private ParkingDisplayBoard displayBoard;

    public ParkingFloor(String name) {
        this.name = name;
    }

    public String ParkingFloorName(){
        return this.name;
    }

    public void addParkingSpot(ParkingSpot spot) {
        switch (spot.getType()) {
            case ParkingSpotTypes.HANDICAPPED:
                handicappedSpots.put(spot.getNumber(), spot);
                break;
            case ParkingSpotTypes.COMPACT:
                compactSpots.put(spot.getNumber(), spot);
                break;
            case ParkingSpotTypes.LARGE:
                largeSpots.put(spot.getNumber(), spot);
                break;
            case ParkingSpotTypes.MOTORCYCLE:
                motorcycleSpots.put(spot.getNumber(), spot);
                break;
            case ParkingSpotTypes.ELECTRIC:
                electricSpots.put(spot.getNumber(), spot);
                break;
            default:
                System.out.println("Wrong parking spot type!");
        }
    }

    public ParkingSpot getSpot(VehicleType vehicleType) {
        ParkingSpotTypes parkingSpotType = pickCorrectSpot(vehicleType);
        HashMap<String, ParkingSpot> relevantParkingSpot;
        ParkingSpot Spot = null;
        switch (parkingSpotType) {
            case ParkingSpotTypes.HANDICAPPED:
                relevantParkingSpot = handicappedSpots;
                break;
            case ParkingSpotTypes.COMPACT:
                relevantParkingSpot = compactSpots;
                break;
            case ParkingSpotTypes.LARGE:
                relevantParkingSpot = largeSpots;
                break;
            case ParkingSpotTypes.MOTORCYCLE:
                relevantParkingSpot = motorcycleSpots;
                break;
            case ParkingSpotTypes.ELECTRIC:
                relevantParkingSpot = electricSpots;
                break;

        }
        for (Map.Entry parkingspot : relevantParkingSpot.entrySet()) {
            if (parkingspot.isAvailable()) {
                return parkingspot;
            }
        }

        return null;
    }

    private void updateDisplayBoardForHandicapped(ParkingSpot spot) {
        if (this.displayBoard.getHandicappedFreeSpot().getNumber() == spot.getNumber()) {
            for (String key : handicappedSpots.keySet()) {
                if (handicappedSpots.get(key).isFree()) {
                    this.displayBoard.setHandicappedFreeSpot(handicappedSpots.get(key));
                }
            }
            this.displayBoard.showEmptySpotNumber();
        }
    }

    private void updateDisplayBoardForCompact(ParkingSpot spot) {
        if (this.displayBoard.getCompactFreeSpot().getNumber() == spot.getNumber()) {
            // find another free compact parking and assign to displayBoard
            for (String key : compactSpots.keySet()) {
                if (compactSpots.get(key).isFree()) {
                    this.displayBoard.setCompactFreeSpot(compactSpots.get(key));
                }
            }
            this.displayBoard.showEmptySpotNumber();
        }
    }

    private ParkingSpotTypes pickCorrectSpot(VehicleType vehicleType) {
        if (vehicleType.equals(VehicleType.MOTORCYCLE))
            return ParkingSpotTypes.MOTORCYCLE;
        else if (vehicleType.equals(VehicleType.ELECTRIC))
            return ParkingSpotTypes.ELECTRIC;
        else if (vehicleType.equals(VehicleType.TRUCK))
            return ParkingSpotTypes.LARGE;
        else if (vehicleType.equals(VehicleType.CAR))
            return ParkingSpotTypes.COMPACT;

        return null;
    }
}