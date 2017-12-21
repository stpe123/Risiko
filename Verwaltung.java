/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 17.11.2017
  * @author 
  */


public class Verwaltung {
  
  // Anfang Attribute
  private Spieler Angreifer;
  private Spieler Verteidiger;
  private Spieler HilfseigenschftZumSpielertausch;
  // Ende Attribute
  
  
  // Anfang Methoden
  /**
  *Keine Übergabe- oder Rückgabeparameter*/
  public void GebieteMischen() {
    
  }
  /**Dies ist ein Test
  */
  public Gebiet GebietAnSpielerUebergeben() {
    
    return null;
  }
  
  
  public void WuerfelAugenzahlVergleichen() {
    
  }
  
  /**Erwartet ein Array mit Gebietsobjekten*/
  public void GebieteEinsammeln(Gebiet[] Gebiete) {
    
  }

  
  //>>>>>>> ee344df410929aa7a0f159a1aada02aaabd3dbe8
  public void GebieteVerteilen() {
    
  }
  
  /**Bestimmt, wer als nächstes dran ist*/
  public void NaechstenSpielerBestimmen() {
    this.HilfseigenschftZumSpielertausch=this.Angreifer;
    this.Angreifer=this.Verteidiger;
    this.Verteidiger=this.HilfseigenschftZumSpielertausch;  
  }

  // Ende Methoden
} // end of Verwaltung
