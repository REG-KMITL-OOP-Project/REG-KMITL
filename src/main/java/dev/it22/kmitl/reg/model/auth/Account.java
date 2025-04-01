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

    public Account(String id,
                   UserRole role,
                   String email,
                   String username,
                   UserPrefix prefix,
                   String firstName,
                   String lastName) {
        this.id = id;
        this.role = role;
        this.email = email;
        this.username = username;
        this.prefix = prefix;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public UserRole getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public UserPrefix getPrefix() {
        return prefix;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPrefix(UserPrefix prefix) {
        this.prefix = prefix;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getFullName() {
        return prefix + " " + firstName + " " + lastName;
    }

}
