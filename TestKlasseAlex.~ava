/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 21.12.2017
  * @author 
  */
  import java.util.*;
  
  
public class TestKlasseAlex {
  
  // Anfang Attribute
      //private ArrayList<Gebiet> Gebiete = new ArrayList<>();
      //private ArrayList<Spieler> spieler = new ArrayList<>();
  // Ende Attribute
  
  
  
  // Anfang Methoden**********************************************************
  public static void main(String[] args) {
    
    //Testszenario////////////////////////////////////////////////////////
    ArrayList<Spieler> spieler = new ArrayList<>();
    spieler.add (new Spieler("Stefan"));
    spieler.add (new Spieler("Alex"));
    spieler.add (new Spieler("Marcus"));
    
    Spieler AktuellerSpieler;
    Weltkarte Erde = new Weltkarte();
    Verwaltung VW = new Verwaltung(spieler);
    VW.GebieteEinsammeln(Erde.getGebiete());
    VW.GebieteMischen();
    VW.GebieteAnSpielerVerteilen();
    VW.SpielerEntfernen(spieler.get(1));
    
    //System.out.println(VW.getBesitzer("Stefan").getName()+" wurde erfolgreich gefunden");
    
    
    
    
    //Prüfung des Ergebnisses/////////////////////////////////////////////
    //    ArrayList<Gebiet> GebieteTest = new ArrayList<>();
    //    Spieler TestSpieler =  spieler.get(0);
    //    
    //    GebieteTest.addAll(TestSpieler.getMeineGebiete());
    //    
    //    System.out.println("Ich heisse "+TestSpieler.getName());
    //    for (int i = 0;i<GebieteTest.size();i++){
    //      
    //      System.out.println(GebieteTest.get(i).getName());
    //    }
    
    
    System.out.println("Das ist ein Test");
  } 
  
  
  
  
  public void Testmethode() {
    
  }
  
  // Ende Methoden
} // end of TestKlasseAlex
