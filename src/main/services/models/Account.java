package src.main.services.models;

import src.main.data.Person;
import src.main.enums.AccountStatus;

public class Account{
    private String userName;
    private String password;
    private AccountStatus status;
    private Person person;

    public Account() {
    }
}