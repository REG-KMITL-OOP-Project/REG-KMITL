package dev.it22.kmitl.reg;

import dev.it22.kmitl.reg.controller.auth.User;
import dev.it22.kmitl.reg.ui.HomePage;
import dev.it22.kmitl.reg.ui.profile.LoginFrame;
import dev.it22.kmitl.reg.utils.Config;
import dev.it22.kmitl.reg.utils.ErrorModal;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame a = Config.createAndShowGUI();
        try{
            new LoginFrame(a);
        }
        catch (Exception e){
            new ErrorModal(a , e.getMessage());
        }
    }
}