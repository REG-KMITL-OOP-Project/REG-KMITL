package dev.it22.kmitl.reg.model.score;

import dev.it22.kmitl.reg.model.score.ScoreModel;
import dev.it22.kmitl.reg.utils.Database;

public class ScoreDAO {
    public void addScore(ScoreModel score) {
        Database db = new Database();
        try {
            if (score.getScore1() != -1) {
                String query = "INSERT INTO score (enrollment_id, score1) VALUES ('" + score.getEnrollmentId() + "', " + score.getScore1() + ");";
                int res = db.postQuery(query);
                System.out.println("Add score1 success : " + res);
            }
            if (score.getScore2() != -1) {
                String query = "INSERT INTO score (enrollment_id, score2) VALUES ('" + score.getEnrollmentId() + "', " + score.getScore2() + ");";
                int res = db.postQuery(query);
                System.out.println("Add score2 success : " + res);
            }
            if (score.getScore3() != -1) {
                String query = "INSERT INTO score (enrollment_id, score3) VALUES ('" + score.getEnrollmentId() + "', " + score.getScore3() + ");";
                int res = db.postQuery(query);
                System.out.println("Add score3 success : " + res);
            }
            if (score.getScore4() != -1) {
                String query = "INSERT INTO score (enrollment_id, score4) VALUES ('" + score.getEnrollmentId() + "', " + score.getScore4() + ");";
                int res = db.postQuery(query);
                System.out.println("Add score4 success : " + res);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
