package dev.it22.kmitl.reg.model.auth;
import dev.it22.kmitl.reg.constant.UserPrefix;
import dev.it22.kmitl.reg.constant.UserRole;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Prof extends Account{
    private String phone;
    private ArrayList<String> subject;

    public Prof(
            String id,
            UserRole role,
            String email,
            String username,
            UserPrefix prefix,
            String firstName,
            String lastName,
            String phone,
            ArrayList<String> subject
    ) throws SQLException {


        super(id, role, email, username, prefix, firstName, lastName);
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
