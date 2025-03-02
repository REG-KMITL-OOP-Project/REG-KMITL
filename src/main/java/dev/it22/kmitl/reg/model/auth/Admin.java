package dev.it22.kmitl.reg.model.auth;

import dev.it22.kmitl.reg.constant.UserPrefix;
import dev.it22.kmitl.reg.constant.UserRole;

import java.sql.ResultSet;
import java.util.Date;

public class Admin extends Account {

    public Admin(ResultSet userData) throws Exception {
        String id = userData.getString("id");
        UserRole role = UserRole.ADMIN;
        String email = userData.getString("email");
        String username = userData.getString("username");
        UserPrefix prefix = UserPrefix.valueOf(userData.getString("prefix"));
        String firstName = userData.getString("first_name");
        String lastName = userData.getString("last_name");
        Date dateOfBirth = userData.getDate("date_of_birth");

        super(id, role, email, username, prefix, firstName, lastName, dateOfBirth);
    }
}
