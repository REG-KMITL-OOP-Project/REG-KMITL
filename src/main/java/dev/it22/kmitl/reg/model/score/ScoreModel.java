package dev.it22.kmitl.reg.model.score;

public class ScoreModel {
    private int scoreId;
    private String enrollmentId;
    private float score1;
    private float score2;
    private float score3;
    private float score4;

    public ScoreModel(String enrollmentId, float score) {
        this.enrollmentId = enrollmentId;
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
        this.score4 = score4;
    }

    public String getEnrollmentId() {
        return enrollmentId;
    }

    public float getScore1() {
        return score1;
    }

    public void setScore1(float score1) {
        this.score1 = score1;
    }

    public float getScore2() {
        return score2;
    }

    public void setScore2(float score2) {
        this.score2 = score2;
    }

    public float getScore3() {
        return score3;
    }

    public void setScore3(float score3) {
        this.score3 = score3;
    }

    public float getScore4() {
        return score4;
    }

    public void setScore4(float score4) {
        this.score4 = score4;
    }

    public float getScore() {
        return score1 + score2 + score3 + score4;
    }
}
