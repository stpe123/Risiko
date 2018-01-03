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
    //Alle Objekte anlegen
    Spieler[] spieler = new Spieler[2];
    spieler[0] = new Spieler("Stefan");
    spieler[1] = new Spieler("Alex");
    Spieler AktuellerSpieler;
    Verwaltung VW = new Verwaltung(spieler);
    Weltkarte Erde = new Weltkarte();    
    
    //Verwaltung verteilt die Gebietskarten an Spieler
    VW.GebieteEinsammeln(Erde.getGebiete());
    VW.GebieteMischen();
    VW.GebieteGleichmaessigAnSpielerVerteilen();
    
    //Verteilen der Gebiete an alle Spieler
    spieler[0].GebieteAnnehmen(VW.GebieteUebergeben(2));
    spieler[1].GebieteAnnehmen(VW.GebieteUebergeben(1));
    
    
    
    
    
    //Jeder Spieler darf am Anfang eine Feste Zahl an Truppen verteilen
    for ( int i = 0; i < spieler.length; i++ ){
      spieler[i].TruppenSetzen(VW.getErlaubteTruppenzahlInInitialisierungsphase());
    }
    
    
    
    //****************************Das Spiel beginnt***************************************************************
    AktuellerSpieler=VW.NaechstenSpielerBestimmen();
    AktuellerSpieler.TruppenSetzen(3);
    
    
  }
  
  // Ende Methoden
} // end of Risiko
