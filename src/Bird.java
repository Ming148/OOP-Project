import java.awt.*;
import java.awt.image.BufferedImage;


public class Bird {

    private Image flappyBird;
    private int xLoc = 0, yLoc = 0;

    public Bird(int initialWidth, int initialHeight) {
        flappyBird = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("pic/flappyBird.png"));
        scaleBird(initialWidth, initialHeight);
    }

    // สร้างฟังก์ชันสำหรับการเปลี่ยนขนาดของรูปภาพ
    public void scaleBird(int width, int height) {
        flappyBird = flappyBird.getScaledInstance(width, height, Image.SCALE_SMOOTH);
    }

    public Image getBird() {
        return flappyBird;
    }

    // สร้างฟังก์ชันสำหรับการเปลี่ยนขนาดของรูปภาพ
    public int getWidth() {
        // ใช้ try-catch เพื่อให้โปรแกรมไม่เกิด error ถ้าไม่มีรูปภาพ
        try {
            // คืนค่าความกว้างของรูปภาพ
            return flappyBird.getWidth(null);
        } catch (Exception e) {
            // ถ้าไม่มีรูปภาพให้คืนค่า -1 แทน เพราะความกว้างไม่สามารถเป็นค่าติดลบได้
            return -1;
        }
    }


    public int getHeight() {
        // ใช้ try-catch เพื่อให้โปรแกรมไม่เกิด error ถ้าไม่มีรูปภาพ
        try {
            // คืนค่าความสูงของรูปภาพ
            return flappyBird.getHeight(null);
        } catch (Exception e) {
            // ถ้าไม่มีรูปภาพให้คืนค่า -1 แทน เพราะความสูงไม่สามารถเป็นค่าติดลบได้
            return -1;
        }
    }

    public int getXLoc() {
        return xLoc;
    }

    public void setXLoc(int xLoc) {
        this.xLoc = xLoc;
    }

    public int getYLoc() {
        return yLoc;
    }

    public void setYLoc(int yLoc) {
        this.yLoc = yLoc;
    }

 
    public Rectangle getRectangle() {
        // สร้าง Rectangle ขึ้นมาใหม่ โดยใช้ค่า xLoc, yLoc, ความกว้าง, ความสูงของรูปภาพ
        return new Rectangle(xLoc, yLoc, flappyBird.getWidth(null), flappyBird.getHeight(null));
    }

    // รับ ฺBufferedImage ที่แสดงรูปภาพของนกแล้วคืนค่ากลับ
    public BufferedImage getBI() {
        // สร้าง BufferedImage ขึ้นมาใหม่ โดยใช้ค่าความกว้าง, ความสูง, และประเภทของรูปภาพของนก
        BufferedImage bi = new BufferedImage(flappyBird.getWidth(null), flappyBird.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        // สร้าง Graphics ขึ้นมาใหม่ โดยใช้ BufferedImage ที่สร้างขึ้นมา
        Graphics g = bi.createGraphics();
        // วาดรูปภาพของนกลงใน BufferedImage
        g.drawImage(flappyBird, 0, 0, null);
        // ปิด Graphics
        g.dispose();
        return bi;
    }
}
