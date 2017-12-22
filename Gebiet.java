/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 17.11.2017
  * @author 
  */

public class Gebiet {
  
  // Anfang Attribute
  private String Name;
  private String Nachbargebiete;
  private int AnzahlSoldaten;
  // Ende Attribute
  
  public Gebiet(Soldat Soldat, String Name, String Nachbargebiete) {
    this.Name = Name;
    this.Nachbargebiete = Nachbargebiete;
  }

  // Anfang Methoden
  public void setSoldat() {
    
  }

  public void getNachbargebiete() {
    
  }

  public void getName() {
    
  }

  public void getAnzahlSoldat() {
    
  }

  public int getAnzahlSoldaten() {
    return AnzahlSoldaten;
  }

  // Ende Methoden
} // end of Gebiet
