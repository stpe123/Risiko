/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 17.11.2017
  * @author 
  */


public class Verwaltung {
  
  // Anfang Attribute
  private Spieler AktuellerSpieler;
  private Spieler Spieler1;
  private Spieler Spieler2;
  // Ende Attribute
  
  
  public Verwaltung(Spieler Spieler1, Spieler Spieler2) {
    this.Spieler1 = Spieler1;
    this.Spieler2 = Spieler2;
  }

  // Anfang Methoden
  /**
  *Keine �bergabe- oder R�ckgabeparameter*/
  public void GebieteMischen() {
    
  }
  /**�bergibt ein Array vom Typ Gebiet
  Der Teilungsfaktor besagt, wie viele aller Gebiete abgegeben werden sollen.
  1=alle, 2=H�lfte, 3= 1/3 usw. aller Gebiete die sich in ihrem Speicher befinden.
  */
  public Gebiet[] GebieteUebergeben(int Teilungsfaktor) {
    
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
  
  /**Bestimmt, wer als n�chstes dran ist*/
  public Spieler NaechstenSpielerBestimmen() {
    return null;
  }

  
  // Ende Methoden
} // end of Verwaltung
