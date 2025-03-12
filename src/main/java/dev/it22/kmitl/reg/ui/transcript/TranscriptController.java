package dev.it22.kmitl.reg.ui.transcript;

import dev.it22.kmitl.reg.ui.HomePage;
import dev.it22.kmitl.reg.utils.Config;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TranscriptController implements ActionListener {
    private TranscriptView view;
    public TranscriptController(JFrame frame) {
        view = new TranscriptView(frame);
        init();
    }
    public void init(){
        view.getDownloadButton().addActionListener(this);
        view.getHomeButton().addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getDownloadButton()) {}
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
