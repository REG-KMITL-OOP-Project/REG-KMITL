package dev.it22.kmitl.reg.controller.auth;

import dev.it22.kmitl.reg.model.auth.Account;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

public class User {

    private Account userAccount;

    public User(ResultSet account){
        try {
            ResultSetMetaData metadata = account.getMetaData();
            int columnCount = metadata.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                System.out.println("Column " + i + ": " + metadata.getColumnName(i));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
