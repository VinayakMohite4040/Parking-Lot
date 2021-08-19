package src.main.users;
//import account, ParkingAttendantPrtal

import src.main.services.models.Account;

public class ParkingAttendant extends Account {
    public Boolean processTicket(String ticketNumber){
        return ParkingAttendantPortal.scanTicket(ticketNumber);
    }
}
