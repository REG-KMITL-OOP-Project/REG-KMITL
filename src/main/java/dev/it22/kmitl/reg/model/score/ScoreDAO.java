package dev.it22.kmitl.reg.model.score;

import dev.it22.kmitl.reg.model.score.ScoreModel;
import dev.it22.kmitl.reg.utils.Database;

import java.sql.ResultSet;

public class ScoreDAO {
    public void createScore(String enrollmentId) {
        Database db = new Database();
        try {
            String query = "INSERT INTO score (enrollment_id, score1, score2, score3, score4) VALUES ( " + enrollmentId + ", 0, 0, 0, 0);";
            int res = db.postQuery(query);
            System.out.println("Create table success : " + res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean getScoreByEnrollmentId(String enrollmentId) {
        Database db = new Database();
        boolean isNull = true;
        try {
            String query = "SELECT score1, score2, score3, score4 FROM score WHERE enrollment_id = '" + enrollmentId + "';";
            ResultSet rs = db.getQuery(query);
            if (rs.next()) {
                isNull = rs.getObject("score1") == null && rs.getObject("score2") == null && rs.getObject("score3") == null && rs.getObject("score4") == null;
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isNull;
    }

    public void addScore(ScoreModel score) {
        Database db = new Database();
        try {
            if (score.getScore1() != -1) {
                String query = "UPDATE score SET score1 = " + score.getScore1() + " WHERE enrollment_id = '" + score.getEnrollmentId() + "' AND score1 IS NULL;";
                int res = db.postQuery(query);
                System.out.println("Update score1 success : " + res);
            } else if (score.getScore2() != -1) {
                String query = "UPDATE score SET score2 = " + score.getScore2() + " WHERE enrollment_id = '" + score.getEnrollmentId() + "' AND score2 IS NULL;";
                int res = db.postQuery(query);
                System.out.println("Update score2 success : " + res);
            } else if (score.getScore3() != -1) {
                String query = "UPDATE score SET score3 = " + score.getScore3() + " WHERE enrollment_id = '" + score.getEnrollmentId() + "' AND score3 IS NULL;";
                int res = db.postQuery(query);
                System.out.println("Update score3 success : " + res);
            } else if (score.getScore4() != -1) {
                String query = "UPDATE score SET score4 = " + score.getScore4() + " WHERE enrollment_id = '" + score.getEnrollmentId() + "' AND score4 IS NULL;";
                int res = db.postQuery(query);
                System.out.println("Update score4 success : " + res);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

