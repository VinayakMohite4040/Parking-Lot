package src.main.services.panels;

import src.main.services.Parking.ParkingLot;
import src.main.services.Parking.ParkingTicket;
import src.main.services.models.Payment;

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
        ParkingLot obj = ParkingLot.getInstance();
        double amount = obj.payAndCheckout(ticket);
        Payment pay = new Payment();
        pay.initiateTransaction(amount);
        ticket.changeStatusToPaid();
    }
    public String getId()
    {
        return this.id;
    }
}