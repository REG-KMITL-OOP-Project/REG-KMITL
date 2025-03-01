package dev.it22.kmitl.reg.model.auth;
import dev.it22.kmitl.reg.constant.UserPrefix;
import dev.it22.kmitl.reg.constant.UserRole;

import java.util.*;

public class Prof extends Account{
    private String phone;
    private ArrayList<String> subject;

    public Prof(String id, UserRole role, String email, String username, UserPrefix prefix, String firstName, String lastName, Date dateOfBirth) {
        super(id, role, email, username, prefix, firstName, lastName, dateOfBirth);
    }
}
