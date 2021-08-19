package src.main.portals;

import src.main.services.Parking.ParkingLot;
import src.main.services.Parking.ParkingTicket;

public class ParkingAttendantPortal {
    private String id;
    public ParkingAttendantPortal(String id)
    {
        this.id = id;
    }
    public static ParkingTicket scanTicket(String ticketNumber)
    {
        ParkingLot obj = ParkingLot.getInstance();
        ParkingTicket ticket = obj.getTicketByTicketNumber(ticketNumber);
        return ticket;
    }
    public void processPayment(ParkingTicket ticket)
    {
        ParkingLot obj = ParkingLot.getInstance();
        obj.payAndCheckout(ticket);
    }

}