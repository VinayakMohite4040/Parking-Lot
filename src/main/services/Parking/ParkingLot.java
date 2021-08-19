package src.main.services.Parking;

import src.main.enums.ParkingSpotTypes;
import src.main.enums.VehicleType;
import src.main.services.Parking.SpotTypes.ParkingSpot;
import src.main.services.vehicle.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private String name;
    private String address;
    private ParkingRate parkingRate;

    private int compactSpotCount;
    private int largeSpotCount;
    private int motorcycleSpotCount;
    private int electricSpotCount;
    private int maxCompactCount;
    private int maxLargeCount;
    private int maxMotorcycleCount;
    private int maxElectricCount;

    private HashMap<String, EntrancePanel> entrancePanels;
    private HashMap<String, ExitPanel> exitPanels;
    private HashMap<String, ParkingFloor> parkingFloors;

    private HashMap<String, ParkingTicket> activeTickets;

    private static ParkingLot parkingLot = null;

    private ParkingLot(String name, String address) {
        this.name = name;
        this.address = address;
        this.parkingRate = new ParkingRate();
        this.compactSpotCount = 0;
        this.largeSpotCount = 0;
        this.motorcycleSpotCount = 0;
        this.electricSpotCount = 0;
        this.maxCompactCount = 0;
        this.maxLargeCount = 0;
        this.maxMotorcycleCount = 0;
        this.maxElectricCount = 0;
    }

    public static ParkingLot getInstance() {
        if (parkingLot == null) {
            parkingLot = new ParkingLot("New","abcd");
        }
        return parkingLot;
    }

    public ParkingFloor getParkingFloor(String name){
        ParkingFloor floor = parkingFloors.get(name);
        return floor;
    }

    public synchronized ParkingTicket getNewParkingTicket(Vehicle vehicle) throws ParkingFullException {
        if (this.isFull(vehicle.getType())) {
            throw new ParkingFullException();
        }

        ParkingSpot ParkingSpot = getParkingSpotForVehicle(vehicle.getType());
        if (ParkingSpot == null)
            return null;

        ParkingTicket ticket = new ParkingTicket(vehicle,ParkingSpot);
        vehicle.assignTicket(ticket);
        ParkingSpot.assignVehicle(vehicle);
        this.incrementSpotCount(vehicle.getType());
        this.activeTickets.put(ticket.getTicketNumber(), ticket);
        return ticket;
    }

    public Boolean isFull(VehicleType type) {
        if (type == VehicleType.TRUCK || type == VehicleType.VAN) {
            return largeSpotCount >= maxLargeCount;
        }
        if (type == VehicleType.MOTORCYCLE) {
            return motorcycleSpotCount >= maxMotorcycleCount;
        }
        if (type == VehicleType.CAR) {
            return (compactSpotCount + largeSpotCount) >= (maxCompactCount + maxLargeCount);
        }
        return (compactSpotCount + largeSpotCount + electricSpotCount) >= (maxCompactCount + maxLargeCount
                + maxElectricCount);
    }

    private boolean incrementSpotCount(VehicleType type) {
        if (type == VehicleType.TRUCK || type == VehicleType.VAN) {
            largeSpotCount++;
        } else if (type == VehicleType.MOTORCYCLE) {
            motorcycleSpotCount++;
        } else if (type == VehicleType.CAR) {
            if (compactSpotCount < maxCompactCount) {
                compactSpotCount++;
            } else {
                largeSpotCount++;
            }
        } else {
            if (electricSpotCount < maxElectricCount) {
                electricSpotCount++;
            } else if (compactSpotCount < maxCompactCount) {
                compactSpotCount++;
            } else {
                largeSpotCount++;
            }
        }
    }

    private boolean decrementSpotCount(ParkingSpotTypes type) {
        if (type == ParkingSpotTypes.LARGE) {
            largeSpotCount--;
        }
        else if (type == ParkingSpotTypes.COMPACT) {
            compactSpotCount--;
        }
        else if (type == ParkingSpotTypes.MOTORCYCLE) {
            motorcycleSpotCount--;
        }
        else if (type == ParkingSpotTypes.ELECTRIC) {
            electricSpotCount--;
        }
    }


    public Boolean addParkingFloor(ParkingFloor floor) {
        parkingFloors.put(floor.ParkingFloorName(), floor);
        this.maxCompactCount += floor.getCompactSpotsCount();
        this.maxLargeCount += floor.getLargeSpotsCount();
        this.maxMotorcycleCount += floor.getMotorcycleSpotsCount();
        this.maxElectricCount += floor.getElectricSpotsCount();
        return true;
    }

    public void addEntrancePanel(EntrancePanel entrancePanel) {
        entrancePanels.put(entrancePanel.name,entrancePanel);
    }

    public void addExitPanel(ExitPanel exitPanel) {
        exitPanels.put(exitPanel.name, exitPanel);
    }

    private ParkingSpot getParkingSpotForVehicle(VehicleType vehicleType) {
        ParkingSpot ParkingSpot = null;
        for (Map.Entry<String, ParkingFloor> floor : parkingFloors.entrySet()) {
            ParkingSpot = floor.getValue().getSpot(vehicleType);
            if (ParkingSpot != null)
                break;
        }
        return ParkingSpot;
    }

    public double payAndCheckout(ParkingTicket ticket) {
        ticket.setExitTime(System.currentTimeMillis());
        ticket.getParkingSpot().removeVehicle();
        double price = parkingRate.calculatePrice(ticket);
        this.activeTickets.remove(ticket.getTicketNumber());
        decrementSpotCount(ticket.getParkingSpot().getType());
        return price;
    }
}
