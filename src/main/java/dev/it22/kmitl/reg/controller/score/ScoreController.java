package dev.it22.kmitl.reg.controller.score;

import dev.it22.kmitl.reg.model.score.ScoreModel;
import dev.it22.kmitl.reg.model.score.ScoreDAO;

import javax.swing.*;

public class ScoreController {
    private ScoreDAO scoreDAO;

    public ScoreController() {
        this.scoreDAO = new ScoreDAO();
    }

    public void addScore(ScoreModel score) {
        if (score.getScore1() != -1) {
            scoreDAO.addScore(score);
        }
        if (score.getScore2() != -1) {
            scoreDAO.addScore(score);
        }
        if (score.getScore3() != -1) {
            scoreDAO.addScore(score);
        }
        if (score.getScore4() != -1) {
            scoreDAO.addScore(score);
        }
    }
}
