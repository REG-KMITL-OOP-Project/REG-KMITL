package dev.it22.kmitl.reg.model.auth;

import dev.it22.kmitl.reg.constant.UserPrefix;
import dev.it22.kmitl.reg.constant.UserRole;

import java.util.Date;

public abstract class Account {
    protected String id;
    protected UserRole role;
    protected String email;
    protected String username;
    protected UserPrefix prefix;
    protected String firstName;
    protected String lastName;
    protected Date dateOfBirth;

    public Account(String id, UserRole role, String email, String username, UserPrefix prefix, String firstName, String lastName, Date dateOfBirth) {
        this.id = id;
        this.role = role;
        this.email = email;
        this.username = username;
        this.prefix = prefix;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
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

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFullName() {
        return prefix + " " + firstName + " " + lastName;
    }

}
