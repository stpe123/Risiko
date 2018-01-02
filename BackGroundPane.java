/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 02.01.2018
  * @author 
  */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.imageio.ImageIO;

class BackGroundPane extends JPanel {
  Image img = null;
  
  BackGroundPane(String imagefile) {
    if (imagefile != null) {
      MediaTracker mt = new MediaTracker(this);
      img = Toolkit.getDefaultToolkit().getImage(imagefile);
      mt.addImage(img, 0);
      try {
        mt.waitForAll();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
  
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(img,0,0,this.getWidth(),this.getHeight(),this);
  }
}
