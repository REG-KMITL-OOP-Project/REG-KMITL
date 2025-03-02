package dev.it22.kmitl.reg.model.auth;
import dev.it22.kmitl.reg.constant.UserPrefix;
import dev.it22.kmitl.reg.constant.UserRole;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Prof extends Account{
    private String phone;
    private ArrayList<String> subject;

    public Prof(ResultSet userData) throws SQLException {
        String id = userData.getString("id");
        UserRole role = UserRole.PROF;
        String email = userData.getString("email");
        String username = userData.getString("username");
        UserPrefix prefix = UserPrefix.valueOf(userData.getString("prefix"));
        String firstName = userData.getString("first_name");
        String lastName = userData.getString("last_name");
        Date dateOfBirth = userData.getDate("date_of_birth");
        this.phone = userData.getString("phone");
        this.subject = new ArrayList<>(Arrays.asList(userData.getString("subject").split(",")));

        super(id, role, email, username, prefix, firstName, lastName, dateOfBirth);
        this.phone = phone;
        this.subject = subject;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<String> getSubject() {
        return subject;
    }

    public void setSubject(ArrayList<String> subject) {
        this.subject = subject;
    }

}
