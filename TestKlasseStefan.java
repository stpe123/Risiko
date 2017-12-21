/**
  *
  * Testfälle Stefan
  *
  * @version 1.0 vom 21.12.2017
  * @Stefan
  */

public class TestKlasseStefan {
  
  
  // Anfang Methoden
  public void KlassenTesten() {
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
  
  // Ende Methoden
} // end of TestKlasseStefan
