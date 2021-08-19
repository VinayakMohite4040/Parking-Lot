package src.main.users;
//import account, ParkingAttendantPrtal

import src.main.portals.ParkingAttendantPortal;
import src.main.services.Parking.ParkingTicket;
import src.main.services.models.Account;

public class ParkingAttendant extends Account {
    public ParkingTicket processTicket(String ticketNumber){
        return ParkingAttendantPortal.scanTicket(ticketNumber);
    }
}
