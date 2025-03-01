package dev.it22.kmitl.reg.model.auth;

import dev.it22.kmitl.reg.constant.UserPrefix;
import dev.it22.kmitl.reg.constant.UserRole;

import java.util.Date;

public class Admin extends Account {

    public Admin(String id, UserRole role, String email, String username, UserPrefix prefix, String firstName, String lastName, Date dateOfBirth) {
        super(id, role, email, username, prefix, firstName, lastName, dateOfBirth);
    }
}
