package dev.it22.kmitl.reg.ui.Class_Management.Data_management;

import dev.it22.kmitl.reg.controller.auth.User;
import dev.it22.kmitl.reg.model.auth.Account;
import dev.it22.kmitl.reg.utils.Database;

public class SubjectTableData {
    private Account user;
    private Database db;

    public SubjectTableData(){
        user = new User().getUserAccount();
        db = new Database();
    }

}
