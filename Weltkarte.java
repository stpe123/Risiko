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
  private ArrayList<JLabel> Namensliste = new ArrayList<>();
  private Color[] Spielerfarben = {new Color(0,255,0),new Color(0,0,255),new Color(255,0,0),new Color(255,0,255),new Color(0,255,255)};
  public JPanel panel;
  
  // Ende Attribute
  
  
  
  
  //Konstruktor*********************************************************************
  public Weltkarte() {
    
    
    this.FensterEinstellen();
    
    //Panel, um Labels anzeigen zu können
    panel = (JPanel) getContentPane();
    panel.setLayout(null);
    
    //Anlegen aller Gebiete in einer Arraylist
    this.GebieteDefinieren();
    
    
    
    //Gebiete auf der Karte anzeigen
    for (ListIterator<Gebiet> li = Gebiete.listIterator(0); li.hasNext();){
      panel.add (li.next());
    }
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
    this.Gebiete.add (new Gebiet("Russland",670,100));
    this.Gebiete.add (new Gebiet("Nordeuropa",440,180));
    this.Gebiete.add (new Gebiet("Amerika",120,180));
    this.Gebiete.add (new Gebiet("Polen",520,150));
    this.Gebiete.add (new Gebiet("Afrika",50,200));
    this.Gebiete.add (new Gebiet("Alaska",570,200));
    this.Gebiete.add (new Gebiet("Australien",570,300));
  }
  
  
  public void SpielerAnzeigen(ArrayList<Spieler> Spielernamen) {
    //Spieler auf der Karte anzeigen
    for (int i = 0;i<Spielernamen.size();i++){
      Namensliste.add (new JLabel(Spielernamen.get(i).getName()));               //Name einfügen
      panel.add (Namensliste.get(i));
      Namensliste.get(i).setForeground(Spielerfarben[i]);                        //Farbe vergeben
      Namensliste.get(i).setFont(this.getFont().deriveFont(25f));                //Schriftgröße festlegen
      Namensliste.get(i).setBounds(10, i*30, 100, 50);                           //Position und Größe festlegen
      Namensliste.get(i).setText(Spielernamen.get(i).getName());                 //Text festlegen
      Spielernamen.get(i).setFarbe(Spielerfarben[i]);                            //Dem Spieler seine Farbe bekanntgeben
    }
    
  }
  
  
  // Ende Methoden
} // end of Weltkarte
