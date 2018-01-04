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

public class Gebiet extends JLabel{
  
  // Attribute*************************************************************************
  // Anfang Attribute
  private String Name;
  private String Nachbargebiete;
  private int AnzahlSoldaten;
  // Ende Attribute
  
  
  
  
  
  //Konstruktor************************************************************************
  public Gebiet(String Name, String Nachbargebiete, int xKoordinate, int yKoordinate) {
    this.Name = Name;
    this.Nachbargebiete = Nachbargebiete;
    this.setFont(this.getFont().deriveFont(25f));
    this.setBounds(xKoordinate, yKoordinate, 30, 30);
  }
  
  
  
  
  // Anfang Methoden*******************************************************************
  /**
  *Addiert die übergebene Anzahl an Soldaten zu "AnzahlSoldaten"
  */
  public void setSoldat(int Anzahl) {
    this.AnzahlSoldaten = this.AnzahlSoldaten + Anzahl;    
  }

  
  public String getNachbargebiete() {
    return this.Nachbargebiete;
  }

  
  public int getAnzahlSoldaten() {
    return AnzahlSoldaten;
  }
  
  public String getName() {
    return this.Name;
  }

  // Ende Methoden
} // end of Gebiet
