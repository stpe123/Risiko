/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 21.12.2017
  * @author 
  */

public class Risiko {
  
  // Anfang Attribute
  private Weltkarte Erde;
  private Spieler AktuellerSpieler;
  // Ende Attribute
  
  // Anfang Methoden
  public static void main(String[] args) {
    
    //********************************Initialisierungsphase*********************************************************
    Spieler Spieler1 = new Spieler("Alex");
    Spieler Spieler2 = new Spieler("Stefan");
    Verwaltung VW = new Verwaltung(Spieler1,Spieler2);
    
    VW.GebieteEinsammeln(Erde.getGebiete());
    VW.GebieteMischen();
    
    Spieler1.GebieteAnnehmen(VW.GebieteUebergeben(2));
    Spieler2.GebieteAnnehmen(VW.GebieteUebergeben(1));
    
    Spieler1.TruppenSetzen(VW.TruppenUebergeben(10));
    Spieler2.TruppenSetzen(VW.TruppenUebergeben(10));
    
    
    
    
    //****************************Das Spiel beginnt***************************************************************
    AktuellerSpieler=VW.NaechstenSpielerBestimmen();
    AktuellerSpieler.TruppenSetzen(VW.TruppenUebergeben(3));
    
    
  }
  
  // Ende Methoden
} // end of Risiko
