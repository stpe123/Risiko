import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.imageio.ImageIO;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 02.01.2018
  * @author 
  */

public class Testframe extends JFrame {
  // Anfang Attribute
  // Ende Attribute
  
  public Testframe(String title) { 
    // Frame-Initialisierung
    super(title);
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 300; 
    int frameHeight = 300;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    setContentPane(new BackGroundPane("Weltkarte.JPG"));
    
    
    //Image image = ImageIO.read(new File("Weltkarte.JPG"));
    // Anfang Komponenten
    
    // Ende Komponenten
    
    setVisible(true);
  } // end of public Testframe
  
  // Anfang Methoden
  

  
  // Ende Methoden
} // end of class Testframe
