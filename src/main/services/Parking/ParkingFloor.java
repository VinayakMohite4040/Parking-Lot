package src.main.services.Parking;

import src.main.enums.ParkingSpotTypes;
import src.main.enums.VehicleType;
import src.main.services.Parking.SpotTypes.*;

import java.util.HashMap;
import java.util.Map;

public class ParkingFloor {
    private String name;
    private HashMap<String,ParkingSpot> handicappedSpots;
    private HashMap<String, ParkingSpot> compactSpots;
    private HashMap<String, ParkingSpot> largeSpots;
    private HashMap<String, ParkingSpot> motorcycleSpots;
    private HashMap<String, ParkingSpot> electricSpots;
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
            case HANDICAPPED:
                handicappedSpots.put(spot.getNumber(), spot);
                break;
            case COMPACT:
                compactSpots.put(spot.getNumber(), spot);
                break;
            case LARGE:
                largeSpots.put(spot.getNumber(), spot);
                break;
            case MOTORCYCLE:
                motorcycleSpots.put(spot.getNumber(), spot);
                break;
            case ELECTRIC:
                electricSpots.put(spot.getNumber(), spot);
                break;
            default:
                System.out.println("Wrong parking spot type!");
        }
    }

    public ParkingSpot getSpot(VehicleType vehicleType) {
        ParkingSpotTypes parkingSpotType = pickCorrectSpot(vehicleType);
        HashMap<String, ParkingSpot> relevantParkingSpot = null;
        ParkingSpot Spot = null;
        switch (parkingSpotType) {
            case HANDICAPPED:
                relevantParkingSpot = handicappedSpots;
                break;
            case COMPACT:
                relevantParkingSpot = compactSpots;
                break;
            case LARGE:
                relevantParkingSpot = largeSpots;
                break;
            case MOTORCYCLE:
                relevantParkingSpot = motorcycleSpots;
                break;
            case ELECTRIC:
                relevantParkingSpot = electricSpots;
                break;

        }
        for (Map.Entry<String, ParkingSpot>parkingSpot : relevantParkingSpot.entrySet()) {
            if (parkingSpot.getValue().isAvailable()) {
                return parkingSpot.getValue();
            }
        }

        return null;
    }

    private void updateDisplayBoardForHandicapped(ParkingSpot spot) {
        if (this.displayBoard.getHandicappedFreeSpot().getNumber() == spot.getNumber()) {
            for (String key : handicappedSpots.keySet()) {
                if (handicappedSpots.get(key).isAvailable()) {
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
                if (compactSpots.get(key).isAvailable()) {
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

    public int getCompactSpotsCount() {
        return compactSpots.size();
    }

    public int getLargeSpotsCount() {
        return largeSpots.size();
    }

    public int getMotorcycleSpotsCount() {
        return motorcycleSpots.size();
    }

    public int getElectricSpotsCount() {
        return electricSpots.size();
    }
}