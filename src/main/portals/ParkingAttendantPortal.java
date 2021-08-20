package src.main.portals;

import src.main.services.Parking.ParkingLot;
import src.main.services.Parking.ParkingTicket;
import src.main.util;

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
    public static void processPayment(ParkingTicket ticket)
    {
        util.processPayment(ticket);
    }

}