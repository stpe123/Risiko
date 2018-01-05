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
import java.util.*;

public class Weltkarte extends JFrame{
  
  // Anfang Attribute***************************************************************
  private ArrayList<Gebiet> Gebiete = new ArrayList<>();
  // Ende Attribute
  
  
  
  
  //Konstruktor*********************************************************************
  public Weltkarte() {
    
    
    this.FensterEinstellen();
    
    //Panel, um Labels anzeigen zu können
    JPanel panel = (JPanel) getContentPane();
    panel.setLayout(null);
    
    //Anlegen aller Gebiete in einer Arraylist
    this.GebieteDefinieren();
    
    //Gebiete auf der Karte anzeigen
    for (ListIterator<Gebiet> li = Gebiete.listIterator(0); li.hasNext();){
      panel.add (li.next());
    }
    
    //Farbeinstellungen für die Gebiete
    Gebiete.get(0).setForeground(Color.green);
    Gebiete.get(1).setForeground(Color.red);
    Gebiete.get(2).setForeground(Color.red);
    Gebiete.get(3).setForeground(Color.green);
    Gebiete.get(4).setForeground(Color.red);
    Gebiete.get(5).setForeground(Color.green);
    Gebiete.get(6).setForeground(Color.red);
    
    
    Gebiete.get(0).setText("15");
    Gebiete.get(1).setText("8");
    Gebiete.get(2).setText("12");
    Gebiete.get(3).setText("10");
    Gebiete.get(4).setText("8");
    Gebiete.get(5).setText("12");
    Gebiete.get(6).setText("10");
    
    
    setVisible(true);
  }
  
  
  
  
  
  
  // Anfang Methoden*******************************************************************
  public ArrayList<Gebiet> getGebiete() {
    return this.Gebiete;
  }
  
  
  
  private void FensterEinstellen() {
    setBounds(100,100,900,600);
    //setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setContentPane(new BackGroundPane("Weltkarte.JPG"));
  }
  
  private void GebieteDefinieren() {
    this.Gebiete.add (new Gebiet("Russland","Polen",670,100));
    this.Gebiete.add (new Gebiet("Deutschland","Frankreich",440,180));
    this.Gebiete.add (new Gebiet("Amerika","Brasilien",120,180));
    this.Gebiete.add (new Gebiet("Polen","Deutschland",520,150));
    this.Gebiete.add (new Gebiet("Afrika","Deutschland",50,200));
    this.Gebiete.add (new Gebiet("Alaska","Deutschland",570,200));
    this.Gebiete.add (new Gebiet("Australien","Deutschland",570,300));
  }
  
  
  public void SpielerAnzeigen(ArrayList<Spieler> Spielernamen) {
    
  }
  
  
    // Ende Methoden
  } // end of Weltkarte
