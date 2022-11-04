/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author m.i.n.g_lee
 */
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Image;
import javax.swing.*;

public class topClass {

    // ตัวแปรคงที่
    private static final int SCREEN_WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private static final int SCREEN_HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();



    // ตัวแปร
    private JFrame f = new JFrame("OOP Project");
    private static topClass tc = new topClass();



    public topClass(){
    }

    public static void main(String[] args) {
        
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                tc.buildFrame();
                Thread t = new Thread(){
                    public void run(){
                    }
                };
                t.start();
            }
        });
    }

    private void buildFrame(){
        f.setContentPane(createContextPane());
        f.setResizable(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setAlwaysOnTop(false);
        f.setVisible(true);
        f.setMinimumSize(new Dimension(SCREEN_WIDTH*(1/4), SCREEN_HEIGHT*(1/4)));
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    private JPanel createContextPane(){
        JPanel topPanel = new JPanel();
        return topPanel;
    }
}
