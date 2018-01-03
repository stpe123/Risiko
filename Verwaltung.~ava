/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 17.11.2017
  * @author 
  */
import java.util.*;

public class Verwaltung {
  
  // Anfang Attribute*****************************************************************
  private ArrayList<Spieler> spieler = new ArrayList<>();
  private ArrayList<Gebiet> Gebiete = new ArrayList<>();
  private Spieler AktuellerSpieler;
  private int ErlaubteTruppenzahlInInitialisierungsphase = 10;
  // Ende Attribute
  
  
  
  
  
  //Konstruktor***********************************************************************
  public Verwaltung(ArrayList<Spieler> spieler) {
    this.spieler.addAll (spieler);
    this.AktuellerSpieler = null;
  }
  
  
  
  
  
  
  // Anfang Methoden******************************************************************
  /**
  *Keine Übergabe- oder Rückgabeparameter*/
  public void GebieteMischen() {
    Collections.shuffle(this.Gebiete);
  }
  
  
  /**Übergibt ein Array vom Typ Gebiet
  Der Teilungsfaktor besagt, wie viele aller Gebiete abgegeben werden sollen.
  1=alle, 2=Hälfte, 3= 1/3 usw. aller Gebiete die sich in ihrem Speicher befinden.
  */
  public Gebiet[] GebieteUebergeben(int Teilungsfaktor) {
    
    return null;
  }
  
  
  
  public void WuerfelAugenzahlVergleichen() {
    
  }
  
  /**Erwartet ein Array mit Gebietsobjekten*/
  public void GebieteEinsammeln(ArrayList<Gebiet> Gebiete) {
    this.Gebiete.addAll(Gebiete);
  }
  
  
  //>>>>>>> ee344df410929aa7a0f159a1aada02aaabd3dbe8
  public void GebieteVerteilen() {
    
  }
  
  /**Bestimmt, wer als nächstes dran ist*/
  public Spieler NaechstenSpielerBestimmen() {
    return null;
  }
  
  
  public int getErlaubteTruppenzahlInInitialisierungsphase() {
    return ErlaubteTruppenzahlInInitialisierungsphase;
  }
  
  public void GebieteAnSpielerVerteilen() {
    ArrayList<Gebiet> tmpGebiet = new ArrayList<>();
    ListIterator<Spieler> SpielerIterator = spieler.listIterator(0);
    
    for (ListIterator<Gebiet> li = Gebiete.listIterator(0); li.hasNext();){
      if (SpielerIterator.hasNext()) {
        tmpGebiet.add(li.next());
        SpielerIterator.next().GebieteAnnehmen(tmpGebiet); 
      }
      else{
        spieler.listIterator(0);
      }
    }
  }
  
  // Ende Methoden
} // end of Verwaltung
