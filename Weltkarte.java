/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 22.11.2017
  * @author 
  */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.imageio.ImageIO;

public class Weltkarte extends JFrame{
  
  // Anfang Attribute***************************************************************
  private Gebiet[] Gebiete = new Gebiet[3];
  // Ende Attribute
  
  
  
  
  //Konstruktor*********************************************************************
  public Weltkarte() {
    
    //Einstellungen f�r das Fenster
    setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setContentPane(new BackGroundPane("Weltkarte.JPG"));
    
    //Panel, um Labels anzeigen zu k�nnen
    JPanel panel = (JPanel) getContentPane();
    panel.setLayout(null);
    
    //Anlegen aller Gebiete in einem Array
    Gebiete[0]= new Gebiet("Russland","Polen",580,250);
    Gebiete[1]= new Gebiet("Deutschland","Frankreich",730,200);
    Gebiete[2]= new Gebiet("Amerika","Brasilien",180,230);
    
    //Gebiete auf der Karte anzeigen
    for ( int i = 0; i < Gebiete.length; i++ ){
      panel.add (Gebiete[i]);
    }
    
    //Farbeinstellungen f�r die Gebiete
    Gebiete[0].setForeground(Color.green);
    Gebiete[1].setForeground(Color.red);
    Gebiete[2].setForeground(Color.red);
    
    
    Gebiete[0].setText("15");
    Gebiete[1].setText("8");
    Gebiete[2].setText("12");
    
    
    setVisible(true);
    this.Gebiete = null;
  }
  
  
  
  
  
  
  // Anfang Methoden*******************************************************************
  public Gebiet[] getGebiete() {
    return Gebiete;
  }
  
  
  // Ende Methoden
} // end of Weltkarte
