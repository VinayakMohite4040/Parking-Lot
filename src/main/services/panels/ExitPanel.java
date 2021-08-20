package src.main.services.panels;

import src.main.services.Parking.ParkingLot;
import src.main.services.Parking.ParkingTicket;
import src.main.util;

public class ExitPanel {
    private String id;
    public ExitPanel(String id)
    {
        this.id = id;
    }
    public ParkingTicket scanTicket(String ticketNumber)
    {
        ParkingLot obj = ParkingLot.getInstance();
        ParkingTicket ticket = obj.getTicketByTicketNumber(ticketNumber);
        return ticket;
    }
    public void processPayment(ParkingTicket ticket)
    {
        util.processPayment(ticket);
    }
    public String getId()
    {
        return this.id;
    }
}