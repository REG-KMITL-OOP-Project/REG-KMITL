package dev.it22.kmitl.reg.ui.transcript;

import dev.it22.kmitl.reg.ui.HomePage;
import dev.it22.kmitl.reg.utils.Config;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TranscriptController implements ActionListener {
    private TranscriptView view;
    private TranscriptModel model;
    public TranscriptController(JFrame frame) {
        view = new TranscriptView(frame);
        model = new TranscriptModel();
        init();
    }
    public void init(){
        view.setData(model.getName(), model.getDateOB(), model.getDateOA(), model.getDegree(), model.getMajor(), model.getStudentID(), model.getSemester(), model.getSubject(), model.getSubjectNumberList(), model.getCreditsList(), model.getGradeList());
        view.generateView();
        view.getDownloadButton().addActionListener(this);
        view.getHomeButton().addActionListener(this);
        System.out.println("ss");
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getDownloadButton()) {
            model.getTranscript();
        }
        else if (e.getSource() == view.getHomeButton()) {
            view.getFrame().getContentPane().removeAll();
            view.getFrame().revalidate();
            view.getFrame().repaint();
            new HomePage(view.getFrame());
        }
    }

    public static void main(String[] args) {
        new TranscriptController(Config.createAndShowGUI());
    }
}
