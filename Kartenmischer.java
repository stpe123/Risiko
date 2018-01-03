/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 03.01.2018
  * @author 
  */

import java.util.Random;


public class Kartenmischer {
  
  // Anfang Attribute
  // Ende Attribute
  
  public Kartenmischer() {
  }
  
  // Anfang Methoden
  public Gebiet[] mischen(Gebiet[] Gebiete) {
    Gebiet tmp;
    int rand;
    
    Random r = new Random();
    for (int i = 0; i < Gebiete.length; i++) {
      rand = r.nextInt(Gebiete.length);
      tmp = Gebiete[i];
      Gebiete[i] = Gebiete[rand];
      Gebiete[rand] = tmp;
    }
    return Gebiete;
    
  }
  
  // Ende Methoden
} // end of Kartenmischer
