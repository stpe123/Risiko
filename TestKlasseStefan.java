/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 21.12.2017
  * @author 
  */

public class TestKlasseStefan {
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
  
  // Anfang Attribute
  // Ende Attribute
  
  // Anfang Methoden
  public void KlassenTesten() {
    
  }

  // Ende Methoden
} // end of TestKlasseStefan
