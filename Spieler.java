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
import java.awt.Color;

public class Spieler {
  
  // Anfang Attribute
  private String Name;
  private ArrayList<Gebiet> MeineGebiete;
  private Wuerfel Wuerfel;
  private Kriegserklaerung Kriegserklaerung;                        
  private Color Farbe;
  // Ende Attribute
  
  
  //Konstruktor um Anfrage an Spieler erweitern: Wie heißt du?
  // -> neuer Konstruktor ohne Übergabeparameter erstellen
  public Spieler(String Name) {
    this.Name = Name;
    this.MeineGebiete = new ArrayList<Gebiet>();
    this.Wuerfel = new Wuerfel();
    this.Kriegserklaerung = new Kriegserklaerung();
  }
  
  
  // Anfang Methoden
  public String getName() {
    return Name;
  }
  
  /**
  *Keine Eingabewerte
  Ein Objekt wird zurückgegeben: Kriegsgebiet, Angriffsgebiet und Augenzahl des Würfels als Attribute
  */
  public Kriegserklaerung angreifen() {
    //Namen der Gebiete des Spielers in einer Liste speichern
    ArrayList<String> NamenDerAktuellBessenenGebiete = new ArrayList <String>();
    for (int i = 0;i<this.MeineGebiete.size();i++){
      NamenDerAktuellBessenenGebiete.add(this.MeineGebiete.get(i).getName());
    } 
    //    Dialogbox: MeineGebiete Auwählen, von dem aus angegriffen wird
    Object[] EigeneGebiete = NamenDerAktuellBessenenGebiete.toArray();
    String Angriffsgebiet = (String)JOptionPane.showInputDialog(
    null,
    this.getName() + ": Von welchem Gebiet möchten Sie angreifen?",
    "Angriff Starten",
    JOptionPane.PLAIN_MESSAGE,
    null,
    EigeneGebiete,
    "1");
    if (Angriffsgebiet == null) {
      //      Angriff abgebrochen  
      return null;
    } // end of if
    else {
      this.Kriegserklaerung.setAngreifendesGebiet(Angriffsgebiet);
    } // end of if-else
    int AngriffsgebietIndex = 0; 
    for (int i = 0;i<this.MeineGebiete.size();i++){
      if (this.MeineGebiete.get(i).getName().equals(Angriffsgebiet)) {
        AngriffsgebietIndex = i;
      } // end of if
      else {
        //nothing
      } // end of if-else
    }
    //    Dialogbox: Kriegserklaerung Auswählen (Muss ein Nachbarland des Ausgewählten eigenen Gebiets sein)  
    ArrayList<String> MoeglicheKriegsgebieteArrayList = new ArrayList<String>();
    boolean NachbargebietGehoertAngreiferFlag = false;
    for (int i = 0; i< this.MeineGebiete.get(AngriffsgebietIndex).getNachbargebiete().size(); i++) {
      //Nur feindlich besetzte Nachbargebiete sind mögliche Kriegsgebiete 
      String NachbargebietPruefen = this.MeineGebiete.get(AngriffsgebietIndex).getNachbargebiete().get(i);
      for (int j = 0; j<this.MeineGebiete.size(); j++ ) {
        String EigenesGebietPruefen = this.MeineGebiete.get(j).getName();
        if (EigenesGebietPruefen.equals(NachbargebietPruefen)) {
          //Nachbargebiet ist nicht feindlich besetzt
          NachbargebietGehoertAngreiferFlag = true;
        } // end of if
      } // end of for
      if (!NachbargebietGehoertAngreiferFlag) {
        MoeglicheKriegsgebieteArrayList.add(NachbargebietPruefen);
      } // end of if
      else {
        //Wenn Nachbargebiet dem Angreifer gehört, wird es nicht übernommen und Flag wieder auf false gesetzt
        NachbargebietGehoertAngreiferFlag = false;
      } // end of if-else
    } // end of for
    
    Object[] MoeglicheKriegsgebiete = MoeglicheKriegsgebieteArrayList.toArray();
    String KriegsgebietName = (String)JOptionPane.showInputDialog(
    null,
    this.getName() + ": Welches Gebiet möchten Sie angreifen?",
    "Kriegserklaerung auswählen",
    JOptionPane.PLAIN_MESSAGE,
    null,
    MoeglicheKriegsgebiete,
    "4");
    if (KriegsgebietName == null) {
      //      Angriff abgebrochen  
      return null;
    } // end of if
    else {
      this.Kriegserklaerung.setKriegsgebiet(KriegsgebietName);
      return this.Kriegserklaerung;
    } // end of if-else 
  }
  
  
  
  /**
  *Gibt einen Ineteger von 1 bis 6 zurück (Augenzahl des Würfels)
  */                                        
  public int wuerfeln() {
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
    String TruppenSetzenGebiet = (String)JOptionPane.showInputDialog(
    null,
    this.getName() + ": Auf welches Gebiet möchten Sie Soldaten setzen?",
    "Soldaten setzen",
    JOptionPane.PLAIN_MESSAGE,
    null,
    EigeneGebiete,
    "1");
    
    if (TruppenSetzenGebiet == null) {
      //      TruppenSetzen abgebrochen  
    } // end of if 
    //    Anzahl der Soldaten, die auf dem Gebiete gesetzt werden sollen
    Object [] AnzahlSoldatenSetzen = new Object[Anzahl]; 
    for (int j = 0; j<AnzahlSoldatenSetzen.length ;j++ ) {
      AnzahlSoldatenSetzen[j] = j+1;                   //Java beginnt bei "0" an zu Zählen        
    } // end of for
    Integer AuswahlAnzahlSoldatenSetzen = (Integer)JOptionPane.showInputDialog(
    null,
    this.getName() + ": Wieviele Soldaten möchten Sie setzen?",
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
      if (TruppenSetzenGebiet == this.MeineGebiete.get(i).getName()) {
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
    //      Namen der Gebiete des Spielers in einer Liste speichern
    ArrayList<String> NamenDerAktuellBessenenGebiete = new ArrayList <String>();
    for (int i = 0;i<this.MeineGebiete.size();i++){
      NamenDerAktuellBessenenGebiete.add(this.MeineGebiete.get(i).getName());
    }
    //  Dialogbox: Gebiet Anwählen, von dem aus Truppen bewegt werden sollen
    Object[] EigeneGebiete = NamenDerAktuellBessenenGebiete.toArray();
    String TruppenBewegenGebiet = (String)JOptionPane.showInputDialog(
    null,
    this.getName() + ": Von welchem Gebiet möchten Sie Truppen bewegen?",
    "Truppen bewegen",
    JOptionPane.PLAIN_MESSAGE,
    null,
    EigeneGebiete,
    "1");
    int TruppenBewegenGebietIndex = 0; 
    for (int i = 0;i<this.MeineGebiete.size();i++){
      if (this.MeineGebiete.get(i).getName().equals(TruppenBewegenGebiet)) {
        TruppenBewegenGebietIndex = i;
      } // end of if
    }
    
    if (TruppenBewegenGebiet == null) {
      // Truppen bewegen abgebrochen  
    } // end of if
    else {
      // Anzahl der Soldaten, die von dem Gebiet bewegt werden sollen
      Object [] AnzahlSoldatenBewegen = new Object[this.MeineGebiete.get(TruppenBewegenGebietIndex).getAnzahlSoldaten()]; 
      for (int j = 0; j<this.MeineGebiete.get(TruppenBewegenGebietIndex).getAnzahlSoldaten() ;j++ ) {
        AnzahlSoldatenBewegen[j] = j+1;                   //Java beginnt bei "0" an zu Zählen        
      } // end of for
      Integer AuswahlAnzahlSoldatenBewegen = (Integer)JOptionPane.showInputDialog(
      null,
      this.getName() + ": Wieviele Soldaten möchten Sie bewegen?",
      "Soldaten setzen",
      JOptionPane.PLAIN_MESSAGE,
      null,
      AnzahlSoldatenBewegen,
        "1");
      //    Dialogbox: Nachbarland Auswählen, auf, dem die truppen gesetzt werden sollen (Muss ein Nachbarland des Ausgewählten eigenen Gebiets sein)  
      ArrayList<String> MoeglichTruppenSetzenGebieteArrayList = new ArrayList<String>();
      boolean NachbargebietGehoertSpielerFlag = false;
      for (int i = 0; i< this.MeineGebiete.get(TruppenBewegenGebietIndex).getNachbargebiete().size(); i++) {
        //Nur auf eigene Nachbargebiete dürfen Truppen gesetzt werden
        String NachbargebietPruefen = this.MeineGebiete.get(TruppenBewegenGebietIndex).getNachbargebiete().get(i);
        for (int j = 0; j<this.MeineGebiete.size(); j++ ) {
          String EigenesGebietPruefen = this.MeineGebiete.get(j).getName();
          if (EigenesGebietPruefen.equals(NachbargebietPruefen)) {
            //Nachbargebiet ist nicht feindlich besetzt
            NachbargebietGehoertSpielerFlag = true;
          } // end of if
        } // end of for
        if (NachbargebietGehoertSpielerFlag) {
          MoeglichTruppenSetzenGebieteArrayList.add(NachbargebietPruefen);
          NachbargebietGehoertSpielerFlag = false;
        } // end of if
      } // end of for
      Object[] MoeglichTruppenSetzenGebiete = MoeglichTruppenSetzenGebieteArrayList.toArray();
      String TruppenSetzenGebietName = (String)JOptionPane.showInputDialog(
      null,
      this.getName() + ": Auf welches Gebiet möchten Sie Truppen setzen?",
      "Truppen setzen auswählen",
      JOptionPane.PLAIN_MESSAGE,
      null,
      MoeglichTruppenSetzenGebiete,
      "4");
      int TruppenSetzenGebietIndex = 0; 
      for (int i = 0;i<this.MeineGebiete.size();i++){
        if (this.MeineGebiete.get(i).getName().equals(TruppenSetzenGebietName)) {
          TruppenSetzenGebietIndex = i;
        } // end of if
      }
      //Truppen von einem Gebiet an das andere übergeben
      this.MeineGebiete.get(TruppenBewegenGebietIndex).setSoldat(-AuswahlAnzahlSoldatenBewegen);
      this.MeineGebiete.get(TruppenSetzenGebietIndex).setSoldat(AuswahlAnzahlSoldatenBewegen);
      //Möchte Spieler nochmal Truppen Bewegen?
      //this.TruppenBewegen();
    } // end of if-else
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
  Gibt ein Gebiet in einer ArrayList zurück und entfernt das übergebene Gebiet aus "MeineGebiete".
  Wird ein Gebiet angefordert, das der Spieler nicht hat, wird null zurückgegeben
  */
  public ArrayList<Gebiet> GebietAbgeben(String GebietName) {
    ArrayList<Gebiet> GebietAbgeben = new ArrayList<Gebiet>();
    for (int i = 0;i<this.MeineGebiete.size();i++){
      //      Wenn das Gebiet, das abgegeben werden muss gefunden wurde
      if (GebietName == this.MeineGebiete.get(i).getName()) {
        GebietAbgeben.add(this.MeineGebiete.get(i));
        this.MeineGebiete.remove(i);
        return GebietAbgeben;
      } // end of if
    } 
    //    Wenn Methode hier angekommen ist, besitzt Spieler das angeforderte Gebiet nicht
    return null;                  
  }

  
  
  
  /**
  *Erwartet eine ArrayList von Gebieten als Übergabewert, speichert 
  diese in "MeineGebiete". 
  */
  public void GebieteAnnehmen(ArrayList<Gebiet> GebieteAnSpieler) {  
    this.MeineGebiete.addAll(GebieteAnSpieler);
    for (int i = 0;i<this.MeineGebiete.size();i++){
      //Name als Besitzer reinschreiben
      this.MeineGebiete.get(i).setBesitzer(this.getName());
      //Farbe zufügen 
      this.MeineGebiete.get(i).setFarbe(this.getFarbe());
    }
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
    this.getName() + ": Möchten Sie angreifen",
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
  
  
  
  public Color getFarbe() {
    return Farbe;
  }
  
  public void setFarbe(Color Farbe) {
    this.Farbe = Farbe;
  }
  
  // Ende Methoden
} // end of Spieler
