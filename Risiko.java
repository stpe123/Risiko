/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 21.12.2017
  * @author 
  */

public class Risiko {
  
  // Anfang Attribute
  //private Weltkarte Erde;
  //private Spieler AktuellerSpieler;
  // Ende Attribute
  
  // Anfang Methoden
  public static void main(String[] args) {
    
    //********************************Initialisierungsphase*********************************************************
    Spieler Spieler1 = new Spieler("Alex");
    Spieler Spieler2 = new Spieler("Stefan");
    Spieler AktuellerSpieler= new Spieler("AktuellerSpieler");
    Verwaltung VW = new Verwaltung(Spieler1,Spieler2);
    Weltkarte Erde = new Weltkarte();
    
    
    VW.GebieteEinsammeln(Erde.getGebiete());
    VW.GebieteMischen();
    
    Spieler1.GebieteAnnehmen(VW.GebieteUebergeben(2));
    Spieler2.GebieteAnnehmen(VW.GebieteUebergeben(1));
    
    Spieler1.TruppenSetzen(10);
    Spieler2.TruppenSetzen(10);
    
    
    
    
    //****************************Das Spiel beginnt***************************************************************
    AktuellerSpieler=VW.NaechstenSpielerBestimmen();
    AktuellerSpieler.TruppenSetzen(3);
    
    
  }
  
  // Ende Methoden
} // end of Risiko
