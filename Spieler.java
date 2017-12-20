/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 17.11.2017
  * @author 
  */

public class Spieler {
  
  // Anfang Attribute
  private String Name;
  private Gebiet Gebiet;
  private Wuerfel Wuerfel;
  private Soldat Soldat;
  // Ende Attribute
  
  public Spieler(String Name) {
    this.Name = Name;
    this.Gebiet = null;
    this.Wuerfel = null;
    this.Spieler = null;
  }

  // Anfang Methoden
  public String getName() {
    return Name;
  }

  public void angreifen() {
    
  }

  public void verteidigen() {
    
  }

  public void TruppenSetzen(Soldat Soldat) {
    
  }

  public void TruppenBewegen() {
    
  }

  public Gebiet getGebiet() {
    return Gebiet;
  }

  public void setGebiet(Gebiet Gebiet) {
    this.Gebiet = Gebiet;
  }

  public void SoldatLoeschen(int Anzahl) {
    
  }

  public void GebietAnwaehlen() {
    
  }

  public void FeindgebietAnwaehlen() {
    
  }

  public void GebietAbgeben() {
    
  }

  public void GebietAnnehmen() {
    
  }

  public int AnzahlGebiete() {
    return 0;
  }

  // Ende Methoden
} // end of Spiiler
