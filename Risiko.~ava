/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 21.12.2017
  * @author 
  */

  import java.util.*;
  
  
public class Risiko {
  
  // Anfang Attribute
  Kriegserklaerung Kriegserkl;
  // Ende Attribute
  
  // Anfang Methoden
  public static void main(String[] args) {
    
    //********************************Initialisierungsphase*********************************************************
    //Alle Objekte anlegen
    ArrayList<Spieler> spieler = new ArrayList<>();
    spieler.add (new Spieler("Stefan"));
    spieler.add (new Spieler("Alex"));
    
    Spieler AktuellerSpieler;
    Verwaltung VW = new Verwaltung(spieler);
    Weltkarte Erde = new Weltkarte();    
    
    //Verwaltung verteilt die Gebietskarten an Spieler
    VW.GebieteEinsammeln(Erde.getGebiete());
    VW.GebieteMischen();
    VW.GebieteAnSpielerVerteilen();
    
    //Jeder darf eine feste Anzahl an Soldaten verteilen
    for (ListIterator<Spieler> li = spieler.listIterator(0); li.hasNext();){
      li.next().TruppenSetzen(10);
    }
    
    
    
    
    
    
    
    
    
    //****************************Das Spiel beginnt***************************************************************
    AktuellerSpieler=VW.NaechstenSpielerBestimmen();
    
    AktuellerSpieler.TruppenSetzen(3);
    while(AktuellerSpieler.MoechtenSieAngreifen()) {
      //Kriegserkl=AktuellerSpieler.angreifen();
    }
    
    
    
  }
  
  // Ende Methoden
} // end of Risiko
