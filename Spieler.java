/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 21.12.2017
  * Stefan
  */
  
  //to do: siehe Konstruktor

import javax.swing.JOptionPane;     //Dialogbox    
import java.util.*;                 //ArrayList benutzen

public class Spieler {
  
  // Anfang Attribute
  private String Name;
  private ArrayList<Gebiet> MeineGebiete;
  private Wuerfel Wuerfel;
  private Kriegserklaerung Kriegserklaerung;                        
  // Ende Attribute
  
  
  //Konstruktor um Anfrage an Spieler erweitern: Wie heißt du?
  // -> neuer Konstruktor ohne Übergabeparameter erstellen
  public Spieler(String Name) {
    this.Name = Name;
    this.MeineGebiete = new ArrayList<>();
    this.Wuerfel = new Wuerfel();
    this.Kriegserklaerung = new Kriegserklaerung();
  }
  
  
  // Anfang Methoden
  public String getName() {
    return Name;
  }
  
  /**
  *Keine Eingabewerte
  Ein Objekt wird zurückgegeben: Kriegserklaerung und Augenzahl des Würfels als Attribute
  */
  public Kriegserklaerung angreifen() {
    //    Würfeln
    this.Kriegserklaerung.setAugenzahl(this.Wuerfel.getAugenzahl());
    //Namen der Gebiete des Spielers in einer Liste speichern
    ArrayList<String> NamenDerAktuellBessenenGebiete = new ArrayList <String>();
    for (int i = 0;i<this.MeineGebiete.size();i++){
      NamenDerAktuellBessenenGebiete.add(this.MeineGebiete.get(i).getName());
    } 
    //    Dialogbox: MeineGebiete Auwählen, von dem aus angegriffen wird
    Object[] EigeneGebiete = NamenDerAktuellBessenenGebiete.toArray();
    String Angriffsgebiet = (String)JOptionPane.showInputDialog(
    null,
    "Von welchem Gebiet möchten Sie angreifen?",
    "Angriff Starten",
    JOptionPane.PLAIN_MESSAGE,
    null,
    EigeneGebiete,
    "1");
    if (Angriffsgebiet == null) {
      //      Angriff abgebrochen  
      return null;
    } // end of if
    
    //    Dialogbox: Kriegserklaerung Auswählen (Muss ein Nachbarland des Ausgewählten eigenen Gebiets sein) 
    Object[] MoeglicheKriegsgebiete = {"4", "5", "6"};
    String KriegsgebietName = (String)JOptionPane.showInputDialog(
    null,
    "Welches Gebiet möchten Sie angreifen?",
    "Kriegserklaerung auswählen",
    JOptionPane.PLAIN_MESSAGE,
    null,
    MoeglicheKriegsgebiete,
    "4");
    if (KriegsgebietName == null) {
      //      Angriff abgebrochen  
      return null;
    } // end of if
    this.Kriegserklaerung.setName(KriegsgebietName);
    return this.Kriegserklaerung;   
  }
  
  /**
  *Gibt einen Ineteger von 1 bis 6 zurück (Augenzahl des Würfels)
  */                                        
  public int verteidigen() {
    return this.Wuerfel.getAugenzahl();
  }
  
  /**
  *Erwartet eine Anzahl an Soldaten als Eingabewert,
  Kein Rueckgabewert.
  */
  public void TruppenSetzen(int Anzahl) {
    //Namen der Gebiete des Spielers in einer Liste speichern
    ArrayList<String> NamenDerAktuellBessenenGebiete = new ArrayList <String>();
    for (int i = 0;i<this.MeineGebiete.size();i++){
      NamenDerAktuellBessenenGebiete.add(this.MeineGebiete.get(i).getName());
    }  
    //  Dialogbox: auf welchem Gebiet möchten Sie Truppen setzen?
    Object[] EigeneGebiete = NamenDerAktuellBessenenGebiete.toArray();
    String GebietTruppenSetzen = (String)JOptionPane.showInputDialog(
    null,
    "Auf welches Gebiet möchten Sie Soldaten setzen?",
    "Soldaten setzen",
    JOptionPane.PLAIN_MESSAGE,
    null,
    EigeneGebiete,
    "1");
    
    if (GebietTruppenSetzen == null) {
      //      TruppenSetzen abgebrochen  
    } // end of if 
    //    Anzahl der Soldaten, die auf dem Gebiete gesetzt werden sollen
    Object [] AnzahlSoldatenSetzen = new Object[Anzahl]; 
    for (int j = 0; j<AnzahlSoldatenSetzen.length ;j++ ) {
      AnzahlSoldatenSetzen[j] = j+1;                   //Java beginnt bei "0" an zu Zählen        
    } // end of for
    Integer AuswahlAnzahlSoldatenSetzen = (Integer)JOptionPane.showInputDialog(
    null,
    "Wieviele Soldaten möchten Sie setzen?",
    "Soldaten setzen",
    JOptionPane.PLAIN_MESSAGE,
    null,
    AnzahlSoldatenSetzen,
    "1"); 
    
    if (AuswahlAnzahlSoldatenSetzen == null) {
      //    Soldatensetzen abgebrochen      
    } // end of if
    //Gebiet, auf dem die Soldaten gesetzt werden sollen aus "MeineGebiete" herraussuchen
    for (int i = 0;i<this.MeineGebiete.size();i++){
      //Wenn Gebiet gefunden, dann Soldatenanzahl im Gebiet erhöhen
      if (GebietTruppenSetzen == this.MeineGebiete.get(i).getName()) {
        this.MeineGebiete.get(i).setSoldat(AuswahlAnzahlSoldatenSetzen);  
        Anzahl = Anzahl - AuswahlAnzahlSoldatenSetzen;
      } // end of if
    }
    //Wenn keine Soldaten mehr
    if (Anzahl == 0) {
      //nothing (Methode wird beendet)
    } 
    else {
      //System.out.println(Anzahl);
      this.TruppenSetzen(Anzahl);
    } // end of if-else   
  }

  /**
  *Gibt dem Spieler die Möglichkeit, Truppen von einem Gebiet zu einem Nachbargebiet zu
  bewegen, wenn dieses nicht feindlich besetzt ist.
  Ohne Eingabe-/Rückgabewerte.
  */
  public void TruppenBewegen() {
    
  }
  /**
  *Löscht einen Soldaten auf der aktuellen "Kriegserklaerung".
  Anzahl ist positiv, damit die Soldaten entfernt werden.
  */
  public void SoldatLoeschen(int Anzahl, String Gebiet) {
    //Abfrage, ob noch Soldaten auf dem Gebiet sind muss noch implementiert werden!!
    for (int i = 0;i<this.MeineGebiete.size();i++){
      //      Wenn das Gebiet, von dem Soldaten entfernt werden muss, gefunden wurde
      if (Gebiet == this.MeineGebiete.get(i).getName()) {
        Anzahl = - Anzahl;                              //Soldaten werden gelöscht
        this.MeineGebiete.get(i).setSoldat(Anzahl);     
      } // end of if
    }
    
  }

  
  /**
  *Erwartet den Name des zurückzugebenden Gebiets als Eingabewert.
  Gibt ein Gebiet zurück und entfernt das übergebene Gebiet aus "MeineGebiete".
  Wird ein Gebiet angefordert, das der Spieler nicht hat, wird null zurückgegeben
  */
  public Gebiet GebietAbgeben(String GebietName) {
    for (int i = 0;i<this.MeineGebiete.size();i++){
      //      Wenn das Gebiet, das abgegeben werden muss gefunden wurde
      if (GebietName == this.MeineGebiete.get(i).getName()) {
        Gebiet GebietZwischenspeichern = this.MeineGebiete.get(i);
        this.MeineGebiete.remove(i); 
        return GebietZwischenspeichern;        
      } // end of if
    } 
    //    Wenn Methode hier angekommen ist, besitzt Spieler das angeforderte Gebiet nicht
    return null;                  
  }
  
  
  /**
  *Erwartet eine ArrayList von Gebieten als Übergabewert, speichert 
  diese in "MeineGebiete". 
  */
  public void GebieteAnnehmen(ArrayList<Gebiet> GebieteAnSpieler) {  //Name als Besitzer reinschreiben
    this.MeineGebiete.addAll(GebieteAnSpieler);   
  }
  /**
  *Gibt die Gebiete des Spielers in einer ArrayList zurück.
  */
  public ArrayList getMeineGebiete() {
    return MeineGebiete;
  }
  /**
  *Liefert true, wenn der Spieler angreifen möchte, sonst false.
  */ 
  public boolean MoechtenSieAngreifen() {
    //Dialog Box: "Möchten Sie angreifen"   
    Object[] options = {"Nein","Ja"};
    int angriff = JOptionPane.showOptionDialog(null,
    "Möchten Sie angreifen",
    "Anfrage: Angriff",
    JOptionPane.YES_NO_OPTION,
    JOptionPane.QUESTION_MESSAGE,
    null,
    options,
    options[1]);
    // Ja: angriff == 1, Nein:angriff == 0;
    if (angriff == 1) {
      return true;
    } // end of if
    else {
      return false;
    } // end of if-else
  }
  
  // Ende Methoden
} // end of Spieler
