/**
  *
  * Testfälle Stefan
  *
  * @version 1.0 vom 21.12.2017
  * @Stefan
  */

<<<<<<< HEAD
public class TestklasseStefan {
  
  // Anfang Attribute
  private Spieler Testeigenschaft;
  // Ende Attribute
  
  // Anfang Methoden
  public void Testmethode() {
=======
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
>>>>>>> 84fe1baa9a9b3876e0c4dc33e96394fe2dd57115
    
    
  }
  
  // Ende Methoden
} // end of TestklasseStefan
