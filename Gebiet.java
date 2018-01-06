/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 17.11.2017
  * @author 
  */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.imageio.ImageIO; 
import java.util.*;                 //ArrayList benutzen

public class Gebiet extends JLabel{
  
  // Attribute*************************************************************************
  // Anfang Attribute
  private Color Farbe;
  private String Name;
  private ArrayList<String> Nachbargebiete = new ArrayList<>();
  private int AnzahlSoldaten = 0;
  private String Besitzer;
  // Ende Attribute
  
  
  
  
  
  //Konstruktor************************************************************************
  public Gebiet(String Name, int xKoordinate, int yKoordinate) {
    this.Name = Name;
    this.setSoldat(1);
    this.setFont(this.getFont().deriveFont(15f));
    this.setBounds(xKoordinate, yKoordinate, 800, 30);
  }
  
  
  
  
  
  // Anfang Methoden*******************************************************************
  /**
  *Addiert die übergebene Anzahl an Soldaten zu "AnzahlSoldaten"
  */
  public void setSoldat(int Anzahl) {
    this.AnzahlSoldaten = this.AnzahlSoldaten + Anzahl;
    this.setText(this.Name+": "+Integer.valueOf(this.AnzahlSoldaten).toString());                     //Soldatenzahl anzeigen
    //this.setForeground();                        //Farbe vergeben   
  }
  
  
  public ArrayList<String> getNachbargebiete() {
    return Nachbargebiete;
  }
  
  
  public int getAnzahlSoldaten() {
    return AnzahlSoldaten;
  }
  
  public String getName() {
    return this.Name;
  }
  
  public String getBesitzer() {
    return Besitzer;
  }
  
  
  public void setBesitzer(String Besitzer) {
    this.Besitzer = Besitzer;
  }
  
  public void NachbargebietHinzufuegen(String Nachbargebiet) {
    this.Nachbargebiete.add (Nachbargebiet);
  }
  
  public Color getFarbe() {
    return Farbe;
  }
  
  public void setFarbe(Color Farbe) {
    this.Farbe = Farbe;
    this.setForeground(Farbe);
  }
  // Ende Methoden
} // end of Gebiet
