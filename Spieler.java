/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 21.12.2017
  * Stefan
  */

import javax.swing.JOptionPane;     //Dialogbox

public class Spieler {
  
  // Anfang Attribute
  private String Name;
  private Gebiet Gebiet;
  private Wuerfel Wuerfel;
  private Soldat Soldat;
                         
  private int Augenzahl1;
  private int Augenzahl2;
  private int Augenzahl3;
  private Kriegsgebiet Kriegsgebiet;
  // Ende Attribute
  
  public Spieler(String Name) {
    this.Name = Name;
    this.Soldat = null;
    this.Augenzahl1 = 0;
    this.Augenzahl2 = 0;
    this.Augenzahl3 = 0;
    this.Gebiet = null;
    this.Wuerfel = new Wuerfel();
  }
  
  
  // Anfang Methoden
  public String getName() {
    return Name;
  }
  
  /**
  *Keine Eingabewerte
  Ein Objekt wird zurückgegeben: Kriegsgebiet und Augenzahl des Würfels als Atribute
  Falls nicht angegriffen wird: Augenzahl == 0
  Kriegsgebiet == noone
  */
  public int angreifen() {
    //Dialog Box: "Möchten Sie angreifen"   
    Object[] options = {"Nein","Ja"};
    int angriff = JOptionPane.showOptionDialog(null,
    "Möchten Sie angreifen",
    "Anfrage: Angriff",
    JOptionPane.YES_NO_OPTION,
    JOptionPane.QUESTION_MESSAGE,
    null,
    options,
    options[1]);
    System.out.print(angriff);
    // Ja: angriff == 1, Nein:angriff == 0;
    if (angriff) {
      //    Angreifen  
      
    } // end of if
    else {
      //    Abbruch
      this.Kriegsgebiet.setAugenzahl(0);
      this.Kriegsgebiet.getName("noone");  
    } // end of if-else

    //Falls ja
    //Eigenes Gebiet auswählen
    //Feindgebiet auswählen
    //Würfeln
    return this.Kriegsgebiet;
  }
  
  /**
  *Gibt einen Ineteger von 1 bis 6 zurück
  */
  public int verteidigen() {
    Augenzahl1 = Wuerfel.getAugenzahl();
    return 6;
    
  }
  
  /**
  *Erwartet Soldaten als Eingabewert
  Kein Rueckgabewert
  */
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
  
  /**
  *Loescht einen Soldaten auf dem aktuellen Kriegsgebiet
  (Angreifer und Verteidiger)
  */
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
  
  
  
  public int getAugenzahl1() {
    return Augenzahl1;
  }
  
  public int getAugenzahl2() {
    return Augenzahl2;
  }
  
  public int getAugenzahl3() {
    return Augenzahl3;
  }
  
  // Ende Methoden
} // end of Spieler
