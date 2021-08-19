package src.main.users;
//import account, ParkingAttendantPrtal

import src.main.portals.ParkingAttendantPortal;
import src.main.services.Parking.ParkingTicket;
import src.main.services.models.Account;

public class ParkingAttendant extends Account {
    public Boolean processTicket(String ticketNumber){
        ParkingTicket ticket = ParkingAttendantPortal.scanTicket(ticketNumber);
        ParkingAttendantPortal.processPayment(ticket);
        return true;
    }
}
