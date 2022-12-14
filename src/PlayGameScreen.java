
import javax.swing.*;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Color;

public class PlayGameScreen extends JPanel {

    private static final long serialVersionUID = 1L;

    private int screenWidth, screenHeight;
    private boolean isSplash = true;
    private int successfulJumps = 0;
    private String message = "Flappy Bird";
    private Font primaryFont = new Font("Goudy Stout", Font.BOLD, 40), failFont = new Font("Calibri", Font.BOLD, 56);
    private int messageWidth = 0, scoreWidth = 0;
    private BottomPipe bp1, bp2;
    private TopPipe tp1, tp2;
    private Bird bird;


    public PlayGameScreen(int screenWidth, int screenHeight, boolean isSplash) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.isSplash = isSplash;
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(new Color( 201, 255, 229));
        g.fillRect(0, 0, screenWidth, screenHeight * 7 / 8);
        g.setColor(new Color( 176, 191, 26));
        g.fillRect(0, screenHeight * 7 / 8, screenWidth, screenHeight / 8);
        g.setColor(Color.BLACK);
        g.drawLine(0, screenHeight * 7 / 8, screenWidth, screenHeight * 7 / 8);

        if (bp1 != null && bp2 != null && tp1 != null && tp2 != null) {
            g.drawImage(bp1.getPipe(), bp1.getX(), bp1.getY(), null);
            g.drawImage(bp2.getPipe(), bp2.getX(), bp2.getY(), null);
            g.drawImage(tp1.getTopPipe(), tp1.getXLoc(), tp1.getYLoc(), null);
            g.drawImage(tp2.getTopPipe(), tp2.getXLoc(), tp2.getYLoc(), null);
        }

        if (!isSplash && bird != null) {
            g.drawImage(bird.getBird(), bird.getXLoc(), bird.getYLoc(), null);
        }


        try {
            g.setFont(primaryFont);
            FontMetrics metric = g.getFontMetrics(primaryFont);
            messageWidth = metric.stringWidth(message);
            scoreWidth = metric.stringWidth(String.format("%d", successfulJumps));
        } catch (Exception e) {
            g.setFont(failFont);
            FontMetrics metric = g.getFontMetrics(failFont);
            messageWidth = metric.stringWidth(message);
            scoreWidth = metric.stringWidth(String.format("%d", successfulJumps));
        }

        g.drawString(message, screenWidth / 2 - messageWidth / 2, screenHeight / 4);

        if (!isSplash) {
            g.drawString(String.format("%d", successfulJumps), screenWidth / 2 - scoreWidth / 2, 50);
        }
    }


    public void setBottomPipe(BottomPipe bp1, BottomPipe bp2) {
        this.bp1 = bp1;
        this.bp2 = bp2;
    }


    public void setTopPipe(TopPipe tp1, TopPipe tp2) {
        this.tp1 = tp1;
        this.tp2 = tp2;
    }

    public void setBird(Bird bird) {
        this.bird = bird;
    }


    public void incrementJump() {
        successfulJumps++;
    }


    public int getScore() {
        return successfulJumps;
    }


    public void setMessage(String message) {
        this.message = message;
    }

}
