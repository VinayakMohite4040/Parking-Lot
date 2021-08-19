package src.main.services.Parking;

import src.main.enums.ParkingTicketStatus;
import src.main.services.Parking.SpotTypes.ParkingSpot;
import src.main.services.vehicle.Vehicle;

public class ParkingTicket{
    private String ticketNumber;
    private long issuedAt;
    private long payedAt;
    private double payedAmount;
    private ParkingTicketStatus status;
    private Vehicle vehicle;
    private ParkingSpot spot;

    public ParkingTicket(Vehicle vehicle, ParkingSpot spot )
    {
        this.ticketNumber = "TicketNumber"+vehicle.getLicenseNumber();
        this.issuedAt = System.currentTimeMillis();
        this.status = ParkingTicketStatus.ACTIVE;
        this.vehicle = vehicle;
        this.spot = spot;
    }
    public long getExitTime()
    {
        return this.payedAt;
    }
    public void setExitTime(long time)
    {
        this.payedAt = time;
    }

    public String getTicketNumber(){
        return this.ticketNumber;
    }

    public ParkingSpot getParkingSpot(){
        return this.spot;
    }

    public long getEntryTime() {
        return this.issuedAt;
    }
    public void setTicketPrice(double cost){
        this.payedAmount = cost;
    }
}