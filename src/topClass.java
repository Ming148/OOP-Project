// สร้างหน้าต่างและเธรดใหม่
import java.awt.Dimension;
// import java.awt.Toolkit;
// import java.awt.Image;
import javax.swing.*;

public class topClass {

    // ตัวแปรคงที่
    private static final int SCREEN_WIDTH = 400;
    private static final int SCREEN_HEIGHT = 800;



    // ตัวแปร
    private JFrame f = new JFrame("OOP Project");
    private static topClass tc = new topClass();



    public topClass(){
    }

    public static void main(String[] args) {
        
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                tc.buildFrame();

                // สร้างเธรดใหม่เพื่อให้ GUI ทำงานได้
                Thread t = new Thread(){
                    public void run(){
                        // อะไรก็ได้ที่อยากให้ทำงานแบบ thread
                    }
                };
                t.start();
            }
        });
    }

    private void buildFrame(){
        f.setContentPane(createContextPane());
        f.setResizable(false); // ปรับขนาดหน้าต่างได้
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        f.setAlwaysOnTop(false);
        f.setVisible(true);
        f.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        f.pack();
    }

    private JPanel createContextPane(){
        JPanel topPanel = new JPanel(); // สร้างพาเนลเพื่อใส่ในหน้าต่าง
        return topPanel; // ส่งพาเนลกลับไป
    }
}
