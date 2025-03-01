package dev.it22.kmitl.reg.model.auth;

import dev.it22.kmitl.reg.constant.UserPrefix;
import dev.it22.kmitl.reg.constant.UserRole;

import java.util.Date;

public class Admin extends Account {
    public Admin(String id, String email, String username, UserPrefix prefix, String firstName, String lastName, Date dateOfBirth) {
        super(id, UserRole.ADMIN, email, username, prefix, firstName, lastName, dateOfBirth);
    }

    public void approveRequest() {
        System.out.println("Request approved");
        System.out.println("I will back to this and implement the logic later jup jup");
    }
}
