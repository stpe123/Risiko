/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 21.12.2017
  * @author 
  */

  import java.util.*;
  import javax.swing.JOptionPane;     //Dialogbox 
  
  
public class Risiko {
  
  // Anfang Attribute
  
  
  
  // Ende Attribute
  
  // Anfang Methoden
  public static void main(String[] args) {
    
    //********************************Initialisierungsphase*********************************************************
    
    
    Weltkarte Erde = new Weltkarte();
    Verwaltung VW = new Verwaltung();
    
    //Spieler anlegen
    ArrayList<Spieler> spieler = new ArrayList<>();
    spieler.addAll(VW.SpielerErmitteln());
    
    
    
    
    
    
    Spieler Rundengewinner;
    Spieler Angreifer;
    Spieler Verteidiger;
    Kriegserklaerung Kriegserkl;
    Gebiet AngreiferGebiet;
    Gebiet VerteidigungsGebiet;
    int AugenzahlAngreifer;
    int AugenzahlVerteidiger;
    
    
    
    Erde.SpielerAnzeigen(spieler);
    
    //Verwaltung verteilt die Gebietskarten an Spieler
    VW.GebieteEinsammeln(Erde.getGebiete());
    VW.GebieteMischen();
    VW.GebieteAnSpielerVerteilen();
    
    //Jeder darf eine feste Anzahl an Soldaten verteilen
    JOptionPane.showMessageDialog(null,"Bevor wir beginnen darf jeder 10 Soldaten auf seinen Feldern verteilen");
    for (ListIterator<Spieler> li = spieler.listIterator(0); li.hasNext();){
      li.next().TruppenSetzen(10);
    }
    
    
    
    
    
    
    
    JOptionPane.showMessageDialog(null,"Das Spiel kann nun beginnen!");
    
    //****************************Das Spiel beginnt***************************************************************
    while (VW.GewinnerErmitteln() == false) { 
      
      
      Angreifer=VW.NaechstenSpielerBestimmen();
      
      Angreifer.TruppenSetzen(3);
      
      //Der aktuelle Spieler darf nun angreifen
      while(Angreifer.MoechtenSieAngreifen()) {
        
        //Angreifer gibt Kriegserklarung mit Angreifergebiet und Angegriffenes zurück
        Kriegserkl=Angreifer.angreifen();
        
        //Verteidiger und sein Gebiet ermitteln
        VerteidigungsGebiet=VW.getGebiet(Kriegserkl.getKriegsgebiet());
        Verteidiger=VW.getBesitzer(VerteidigungsGebiet.getBesitzer());
        
        
        //Angreifergebiet ermitteln
        AngreiferGebiet=VW.getGebiet(Kriegserkl.getAngreifendesGebiet());
        
        
        //Gefechtssituation/////////////////////////////////////////////////////////
        //Beide würfeln
        AugenzahlAngreifer = Angreifer.wuerfeln();
        AugenzahlVerteidiger = Verteidiger.wuerfeln();
        
        //Gewinner ermitteln
        if (AugenzahlAngreifer > AugenzahlVerteidiger) {
          Rundengewinner=Angreifer;
        }
        else {
          Rundengewinner=Verteidiger;
        }
        
        //Gewinner bekanntgeben 
        JOptionPane.showMessageDialog(null,Angreifer.getName()+", Sie haben eine "+AugenzahlAngreifer+" gewürfelt.\n"+Verteidiger.getName()+", Sie eine "+AugenzahlVerteidiger+".\n"+Rundengewinner.getName()+", Sie haben diese Runde gewonnen!");
        
        //Verteidiger hat verloren
        if (Rundengewinner.getName() == Angreifer.getName()) {
          if (VerteidigungsGebiet.getAnzahlSoldaten() > 1) {
            //Der Verteidiger ist noch Besitzer des Gebietes, muss aber einen Soldat wegnehmen
            Verteidiger.SoldatLoeschen(1,VerteidigungsGebiet.getName());
          }
          else {
            //Der Verteidiger hat keine Soldaten mehr auf dem Gebiet und muss es nun abgeben
            Angreifer.GebietErobern(Verteidiger.GebietAbgeben(VerteidigungsGebiet.getName()));
            if (Verteidiger.getMeineGebiete().size() == 0) {
              //Spieler hat verloren und wird gelöscht
              VW.SpielerEntfernen(Verteidiger);
              if (VW.getSpieler().size() == 1) {//Wenn es nur noch einen Spieler gibt
                JOptionPane.showMessageDialog(null,Angreifer.getName()+", Sie haben gewonnen!");
                break;
              } // end of if
            }
          }
        }
        
        //Angreifer hat verloren
        else {
          if (AngreiferGebiet.getAnzahlSoldaten() > 1) {
            Angreifer.SoldatLoeschen(1,AngreiferGebiet.getName());
          } // end of if
        } // end of if
      }
      
      Angreifer.TruppenBewegen();
      
    }
  } // end of while  
  // Ende Methoden
} // end of Risiko
