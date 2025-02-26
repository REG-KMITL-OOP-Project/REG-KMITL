package dev.it22.kmitl.reg.model.auth;

import dev.it22.kmitl.reg.constant.UserPrefix;
import dev.it22.kmitl.reg.constant.UserRole;

import java.util.Date;

public abstract class Account {
    private String id;
    private UserRole role;
    private String email;
    private String username;
    private UserPrefix prefix;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
}
