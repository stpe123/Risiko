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
  
  
  
  // Ende Attribute
  
  // Anfang Methoden
  public static void main(String[] args) {
    
    //********************************Initialisierungsphase*********************************************************
    //Alle Objekte anlegen
    ArrayList<Spieler> spieler = new ArrayList<>();
    spieler.add (new Spieler("Stefan"));
    spieler.add (new Spieler("Alex"));
    
    Spieler AktuellerSpieler;
    Spieler Verteidiger;
    Kriegserklaerung Kriegserkl;
    Gebiet AngreiferGebiet;
    Gebiet VerteidigungsGebiet;
    int AugenzahlAngreifer;
    int AugenzahlVerteidiger;
    
    Verwaltung VW = new Verwaltung(spieler);
    Weltkarte Erde = new Weltkarte();    
    Erde.SpielerAnzeigen(spieler);
    
    //Verwaltung verteilt die Gebietskarten an Spieler
    VW.GebieteEinsammeln(Erde.getGebiete());
    VW.GebieteMischen();
    VW.GebieteAnSpielerVerteilen();
    
    //Jeder darf eine feste Anzahl an Soldaten verteilen
    for (ListIterator<Spieler> li = spieler.listIterator(0); li.hasNext();){
      li.next().TruppenSetzen(10);
    }
    
    
    
    
    
    
    
    
    
    //****************************Das Spiel beginnt***************************************************************
    while (VW.GewinnerErmitteln() == false) { 
      
      
      AktuellerSpieler=VW.NaechstenSpielerBestimmen();
      
      AktuellerSpieler.TruppenSetzen(3);
      
      //Der aktuelle Spieler darf nun angreifen
      while(AktuellerSpieler.MoechtenSieAngreifen()) {
        Kriegserkl=AktuellerSpieler.angreifen();
        
        //Verteidiger und sein Gebiet ermitteln
        VerteidigungsGebiet=VW.getGebiet(Kriegserkl.getKriegsgebiet());
        Verteidiger=VW.getBesitzer(VerteidigungsGebiet.getBesitzer());
        
        
        //Angreifergebiet ermitteln
        AngreiferGebiet=VW.getGebiet(Kriegserkl.getAngreifendesGebiet());
        
        
        //Gefechtssituation/////////////////////////////////////////////////////////
        //Beide würfeln
        AugenzahlAngreifer = AktuellerSpieler.wuerfeln();
        AugenzahlVerteidiger = Verteidiger.wuerfeln();
        
        //Verteidiger hat verloren
        if (AugenzahlAngreifer >= AugenzahlVerteidiger) {
          if (VerteidigungsGebiet.getAnzahlSoldaten() > 1) {
            //Der Verteidiger ist noch Besitzer des Gebietes, muss aber einen Soldat wegnehmen
            Verteidiger.SoldatLoeschen(1,VerteidigungsGebiet.getName());
          }
          else {
            //Der Verteidiger hat keine Soldaten mehr auf dem Gebiet und muss es nun abgeben
            //AktuellerSpieler.GebieteAnnehmen(Verteidiger.GebietAbgeben(VerteidigungsGebiet.getName()));
            if (Verteidiger.getMeineGebiete().size() == 0) {
              //Spieler hat verloren und wird gelöscht
              VW.SpielerEntfernen(Verteidiger);
            }
          }
        }
        
        //Angreifer hat verloren
        else {
          if (AngreiferGebiet.getAnzahlSoldaten() > 1) {
            AktuellerSpieler.SoldatLoeschen(1,AngreiferGebiet.getName());
          } // end of if
        } // end of if
      }
      
      
      
    }
  } // end of while  
  // Ende Methoden
} // end of Risiko
