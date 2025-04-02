package dev.it22.kmitl.reg.controller.transcript;

import dev.it22.kmitl.reg.controller.auth.Login;
import dev.it22.kmitl.reg.controller.auth.User;
import dev.it22.kmitl.reg.model.transcript.TranscriptModel;
import dev.it22.kmitl.reg.ui.HomePage;
import dev.it22.kmitl.reg.ui.transcript.TranscriptView;
import dev.it22.kmitl.reg.utils.Config;
import dev.it22.kmitl.reg.utils.SuccessModal;

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
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getDownloadButton()) {
            model.getTranscript();
            new SuccessModal(view.getFrame(), "ดาวน์โหลด transcript เสร็จสิ้น สามารถดู transcript ได้ในโฟลเดอร์ download");
        }
        else if (e.getSource() == view.getHomeButton()) {
            view.getFrame().getContentPane().removeAll();
            view.getFrame().revalidate();
            view.getFrame().repaint();
            new HomePage(view.getFrame());
        }
    }
}
