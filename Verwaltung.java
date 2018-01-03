/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 17.11.2017
  * @author 
  */


public class Verwaltung {
  
  // Anfang Attribute*****************************************************************
  private Spieler[] spieler;
  private Gebiet[] Gebiete;
  private Kartenmischer Mischer = new Kartenmischer();
  private Spieler AktuellerSpieler;
  private int ErlaubteTruppenzahlInInitialisierungsphase = 10;
  // Ende Attribute
  
  
  
  
  
  //Konstruktor***********************************************************************
  public Verwaltung(Spieler[] spieler) {
    this.spieler = spieler;
    this.AktuellerSpieler = null;
  }
  
  
  
  
  
  
  // Anfang Methoden******************************************************************
  /**
  *Keine Übergabe- oder Rückgabeparameter*/
  public void GebieteMischen() {
    this.Gebiete = Mischer.mischen(this.Gebiete);
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
  public void GebieteEinsammeln(Gebiet[] Gebiete) {
    this.Gebiete = Gebiete;
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
  
  public void GebieteGleichmaessigAnSpielerVerteilen() {
    //    for ( int i = 0; i < spieler.length; i++ ){
//      if ( i == spieler.length-1 ) {
//        spieler[i].GebieteAnnehmen(this.GebieteUebergeben(Gebiete.length/spieler.length));        
//      } // end of if      
//      spieler[i].GebieteAnnehmen(this.GebieteUebergeben(Gebiete.length/spieler.length));
//    }
  }
  
  // Ende Methoden
} // end of Verwaltung
