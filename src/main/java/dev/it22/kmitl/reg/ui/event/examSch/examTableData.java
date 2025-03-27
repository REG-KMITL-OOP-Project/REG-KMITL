package dev.it22.kmitl.reg.ui.event.examSch;

import dev.it22.kmitl.reg.model.auth.Account;
import dev.it22.kmitl.reg.utils.Database;
import java.sql.SQLException;
import dev.it22.kmitl.reg.controller.auth.Login;
import dev.it22.kmitl.reg.controller.auth.User;
import dev.it22.kmitl.reg.controller.auth.User;
import dev.it22.kmitl.reg.model.auth.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class examTableData {
    private Account user;
    private Database db;
    private String[][] data;
    private ResultSet rs,countRs;

    public examTableData() throws SQLException {

        //ทดลองเอามาใช้เฉยๆTT

        user = new User().getUserAccount();
        db = new Database();

        rs = db.getQuery("SELECT * FROM section WHERE section = " + ((Student) user).getSection());
        countRs = db.getQuery("SELECT COUNT(*) as row_count FROM section WHERE section = " + ((Student) user).getSection());

        int rowCount = 0;
        if (countRs.next()) {
            rowCount = countRs.getInt("row_count");
        }

        data = new String[rowCount][6];

        int p = 0;
        while (rs.next()) {
            for (int j = 0; j < 6; j++) {
                data[p][j] = rs.getString(j + 1);
            }
            p++;
        }
    }
    
    public String[][] getData() {
        return data;
    }
}
