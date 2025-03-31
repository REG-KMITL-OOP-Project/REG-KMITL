package dev.it22.kmitl.reg.ui.Class_Management.Data_management;

import dev.it22.kmitl.reg.model.auth.Account;
import dev.it22.kmitl.reg.utils.Database;
import java.util.ArrayList;
import dev.it22.kmitl.reg.controller.auth.User;
import dev.it22.kmitl.reg.model.auth.Admin;

public class AddSubject_Data {
    private Account user;
    private Database db;

    public AddSubject_Data() {
        user = new User().getUserAccount();
        db = new Database();
    }
}
