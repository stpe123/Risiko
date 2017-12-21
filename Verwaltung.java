/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 17.11.2017
  * @author 
  */


public class Verwaltung {
  
  // Anfang Attribute
  // Ende Attribute
  
  
  // Anfang Methoden
  public static void main(String[] args) {
    //Würfel testen
    int WAugenzahl;
    Wuerfel Wuerfel1 = new Wuerfel();
    WAugenzahl = Wuerfel1.getAugenzahl();
    System.out.println(WAugenzahl);
    
    //Spieler testen
    int m;
    Spieler Stefan = new Spieler("Stefan");
    m = Stefan.angreifen(); 
    System.out.println(m);
    
    
  }
  
  private void GebieteMischen() {
    
  }
  
  private void GebieteAnSpielerVerteilen() {
    
  }
  
  private void WuerfelAugenzahlVergleichen() {
    
  }
  
  //<  <<<<<< HEAD
  //=======
  private void GebieteEinsammeln() {
    
  }

  //>>>>>>> ee344df410929aa7a0f159a1aada02aaabd3dbe8
  // Ende Methoden
} // end of Verwaltung
