import java.awt.*;
import java.awt.image.BufferedImage;

public class TopPipe {
    private Image topPipe;
    private int xLoc = 0, yLoc = 0;
    
    public TopPipe(int initialWidth, int initialHeight){
        topPipe = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("pic/topPipe.png"));
        scaleTopPipe(initialWidth, initialHeight);
    }
    
    public void scaleTopPipe(int width, int height) {
        topPipe = topPipe.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }
    
    public Image getTopPipe() {
        return topPipe;
    }
    
    public int getWidth() {
        return topPipe.getWidth(null);
    }
    
    public int getHeight() {
        return topPipe.getHeight(null);
    }
    
    public void setXLoc(int xLoc) {
        this.xLoc = xLoc;
    }
    
    public int getXLoc() {
        return xLoc;
    }
    
    public void setYLoc(int yLoc) {
        this.yLoc = yLoc;
    }
    
    public int getYLoc() {
        return yLoc;
    }
    
    public Rectangle getRectangle() {
        return (new Rectangle(xLoc, yLoc, topPipe.getWidth(null), topPipe.getHeight(null)));
    }
    
    public BufferedImage getBI() {
        BufferedImage bi = new BufferedImage(topPipe.getWidth(null), topPipe.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics g = bi.getGraphics();
        g.drawImage(topPipe, 0, 0, null);
        g.dispose();
        return bi;
    }
}
