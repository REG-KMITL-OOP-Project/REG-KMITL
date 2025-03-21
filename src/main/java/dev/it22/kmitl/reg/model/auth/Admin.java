package dev.it22.kmitl.reg.model.auth;

import dev.it22.kmitl.reg.constant.UserPrefix;
import dev.it22.kmitl.reg.constant.UserRole;

import java.sql.ResultSet;
import java.util.Date;

public class Admin extends Account {
    public Admin(String id, String email, String username, UserPrefix prefix, String firstName, String lastName) {
        super(id, UserRole.ADMIN, email, username, prefix, firstName, lastName);
    }

    public Admin(String id,
                 UserRole role,
                    String email,
                    String username,
                    UserPrefix prefix,
                    String firstName,
                    String lastName
                 ) throws Exception {

        super(id, role, email, username, prefix, firstName, lastName);
    }
}
