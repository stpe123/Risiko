/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 22.11.2017
  * @author 
  */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.imageio.ImageIO;
import java.util.*;

public class Weltkarte extends JFrame{
  
  // Anfang Attribute***************************************************************
  private ArrayList<Gebiet> Gebiete = new ArrayList<>();
  private ArrayList<JLabel> Namensliste = new ArrayList<>();
  private Color[] Spielerfarben = {new Color(0,255,0),new Color(0,0,255),new Color(255,0,0),new Color(255,0,255),new Color(0,255,255)};
  public JPanel panel;
  
  // Ende Attribute
  
  
  
  
  //Konstruktor*********************************************************************
  public Weltkarte() {
    
    
    this.FensterEinstellen();
    
    //Panel, um Labels anzeigen zu können
    panel = (JPanel) getContentPane();
    panel.setLayout(null);
    
    //Anlegen aller Gebiete in einer Arraylist
    this.GebieteDefinieren();
    
    
    
    //Gebiete auf der Karte anzeigen
    for (ListIterator<Gebiet> li = Gebiete.listIterator(0); li.hasNext();){
      panel.add (li.next());
    }
    setVisible(true);
  }
  
  
  
  
  
  
  // Anfang Methoden*******************************************************************
  public ArrayList<Gebiet> getGebiete() {
    return this.Gebiete;
  }
  
  
  
  private void FensterEinstellen() {
    setBounds(100,100,900,600);
    //setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setContentPane(new BackGroundPane("Weltkarte.JPG"));
  }
  
  private void GebieteDefinieren() {
    //Position 0-10
    this.Gebiete.add (new Gebiet("Alaska",20,90));                //0    
    this.Gebiete.add (new Gebiet("Nordwest-Territorium",65,75));  //1
    this.Gebiete.add (new Gebiet("Alberta",90,120));              //2
    this.Gebiete.add (new Gebiet("Ontario",150,140));             //3
    this.Gebiete.add (new Gebiet("Ostkanada",220,130));           //4
    this.Gebiete.add (new Gebiet("Weststaaten",70,180));          //5
    this.Gebiete.add (new Gebiet("Oststaaten",160,200));          //6
    this.Gebiete.add (new Gebiet("Mittelamerika",90,250));        //7
    this.Gebiete.add (new Gebiet("Venezuela",170,295));           //8
    this.Gebiete.add (new Gebiet("Brasilien",240,350));           //9
    this.Gebiete.add (new Gebiet("Peru",170,360));                //10
    
    //Position 11-20
    this.Gebiete.add (new Gebiet("Argentinien",180,440));         //11
    this.Gebiete.add (new Gebiet("Nordafrika",380,340));          //12
    this.Gebiete.add (new Gebiet("Ägypten",450,300));             //13
    this.Gebiete.add (new Gebiet("Ostafrika",490,350));           //14
    this.Gebiete.add (new Gebiet("Zentralafrika",410,400));       //15
    this.Gebiete.add (new Gebiet("Südafrika",450,455));           //16
    this.Gebiete.add (new Gebiet("Madagaskar",540,470));          //17
    this.Gebiete.add (new Gebiet("Indonesien",700,400));          //18
    this.Gebiete.add (new Gebiet("Westaustr.",750,470));          //19
    this.Gebiete.add (new Gebiet("Ostaustr.",790,440));           //20
    
    //Position 21-30    
    this.Gebiete.add (new Gebiet("Neuguinea",780,360));           //21
    this.Gebiete.add (new Gebiet("Grönland",260,40));             //22
    this.Gebiete.add (new Gebiet("Island",350,110));              //23
    this.Gebiete.add (new Gebiet("Grossbrit.",320,170));          //24
    this.Gebiete.add (new Gebiet("Westeuropa",320,240));          //25
    this.Gebiete.add (new Gebiet("Südeuropa",410,220));           //26
    this.Gebiete.add (new Gebiet("Nordeuropa",400,190));          //27
    this.Gebiete.add (new Gebiet("Skandinavien",400,90));         //28
    this.Gebiete.add (new Gebiet("Russland",500,140));            //29
    this.Gebiete.add (new Gebiet("Mittlerer Osten",500,270));     //30
    
    //Position 31-41
    this.Gebiete.add (new Gebiet("Indien",640,280));              //31
    this.Gebiete.add (new Gebiet("Südostasien",700,320));         //32
    this.Gebiete.add (new Gebiet("China",700,240));               //33
    this.Gebiete.add (new Gebiet("Afghanistan",570,200));         //34
    this.Gebiete.add (new Gebiet("Ural",610,130));                //35
    this.Gebiete.add (new Gebiet("Sibirien",650,95));             //36
    this.Gebiete.add (new Gebiet("Jakutien",720,60));             //37
    this.Gebiete.add (new Gebiet("Irkutsk",710,130));             //38
    this.Gebiete.add (new Gebiet("Mongolei",710,170));            //39
    this.Gebiete.add (new Gebiet("Japan",815,190));               //40
    this.Gebiete.add (new Gebiet("Kamtschatka",760,110));         //41
    
    //Nachbargebiete definieren
    this.Gebiete.get(0).NachbargebietHinzufuegen(this.Gebiete.get(1).getName());
    this.Gebiete.get(0).NachbargebietHinzufuegen(this.Gebiete.get(2).getName());
    this.Gebiete.get(0).NachbargebietHinzufuegen(this.Gebiete.get(41).getName());
    
    //Nordwest-Territorium
    this.Gebiete.get(1).NachbargebietHinzufuegen(this.Gebiete.get(0).getName());
    this.Gebiete.get(1).NachbargebietHinzufuegen(this.Gebiete.get(2).getName());
    this.Gebiete.get(1).NachbargebietHinzufuegen(this.Gebiete.get(3).getName());
    this.Gebiete.get(1).NachbargebietHinzufuegen(this.Gebiete.get(22).getName());
    
    //Alberta
    this.Gebiete.get(2).NachbargebietHinzufuegen(this.Gebiete.get(0).getName());
    this.Gebiete.get(2).NachbargebietHinzufuegen(this.Gebiete.get(1).getName());
    this.Gebiete.get(2).NachbargebietHinzufuegen(this.Gebiete.get(3).getName());
    this.Gebiete.get(2).NachbargebietHinzufuegen(this.Gebiete.get(5).getName());
    
    //Ontario
    this.Gebiete.get(3).NachbargebietHinzufuegen(this.Gebiete.get(1).getName());
    this.Gebiete.get(3).NachbargebietHinzufuegen(this.Gebiete.get(2).getName());
    this.Gebiete.get(3).NachbargebietHinzufuegen(this.Gebiete.get(5).getName());
    this.Gebiete.get(3).NachbargebietHinzufuegen(this.Gebiete.get(6).getName());
    this.Gebiete.get(3).NachbargebietHinzufuegen(this.Gebiete.get(4).getName());
    this.Gebiete.get(3).NachbargebietHinzufuegen(this.Gebiete.get(22).getName());
    
    //Ostkanada
    this.Gebiete.get(4).NachbargebietHinzufuegen(this.Gebiete.get(3).getName());
    this.Gebiete.get(4).NachbargebietHinzufuegen(this.Gebiete.get(6).getName());
    this.Gebiete.get(4).NachbargebietHinzufuegen(this.Gebiete.get(22).getName());
    
    //Weststaaten
    this.Gebiete.get(5).NachbargebietHinzufuegen(this.Gebiete.get(2).getName());
    this.Gebiete.get(5).NachbargebietHinzufuegen(this.Gebiete.get(3).getName());
    this.Gebiete.get(5).NachbargebietHinzufuegen(this.Gebiete.get(6).getName());
    this.Gebiete.get(5).NachbargebietHinzufuegen(this.Gebiete.get(7).getName());
    
    //Oststaaten
    this.Gebiete.get(6).NachbargebietHinzufuegen(this.Gebiete.get(4).getName());
    this.Gebiete.get(6).NachbargebietHinzufuegen(this.Gebiete.get(3).getName());
    this.Gebiete.get(6).NachbargebietHinzufuegen(this.Gebiete.get(5).getName());
    this.Gebiete.get(6).NachbargebietHinzufuegen(this.Gebiete.get(7).getName());
    
    //Mittelamerika
    this.Gebiete.get(7).NachbargebietHinzufuegen(this.Gebiete.get(6).getName());
    this.Gebiete.get(7).NachbargebietHinzufuegen(this.Gebiete.get(5).getName());
    this.Gebiete.get(7).NachbargebietHinzufuegen(this.Gebiete.get(8).getName());
    
    //Venezuela
    this.Gebiete.get(8).NachbargebietHinzufuegen(this.Gebiete.get(7).getName());
    this.Gebiete.get(8).NachbargebietHinzufuegen(this.Gebiete.get(9).getName());
    this.Gebiete.get(8).NachbargebietHinzufuegen(this.Gebiete.get(10).getName());
    
    //Brasilien
    this.Gebiete.get(9).NachbargebietHinzufuegen(this.Gebiete.get(8).getName());
    this.Gebiete.get(9).NachbargebietHinzufuegen(this.Gebiete.get(10).getName());
    this.Gebiete.get(9).NachbargebietHinzufuegen(this.Gebiete.get(11).getName());
    this.Gebiete.get(9).NachbargebietHinzufuegen(this.Gebiete.get(12).getName());
    
    //Peru
    this.Gebiete.get(10).NachbargebietHinzufuegen(this.Gebiete.get(8).getName());
    this.Gebiete.get(10).NachbargebietHinzufuegen(this.Gebiete.get(9).getName());
    this.Gebiete.get(10).NachbargebietHinzufuegen(this.Gebiete.get(11).getName());
    
    //Argentinien
    this.Gebiete.get(11).NachbargebietHinzufuegen(this.Gebiete.get(10).getName());
    this.Gebiete.get(11).NachbargebietHinzufuegen(this.Gebiete.get(9).getName());
    
    //Nordafrika
    this.Gebiete.get(12).NachbargebietHinzufuegen(this.Gebiete.get(9).getName());
    this.Gebiete.get(12).NachbargebietHinzufuegen(this.Gebiete.get(13).getName());
    this.Gebiete.get(12).NachbargebietHinzufuegen(this.Gebiete.get(25).getName());
    this.Gebiete.get(12).NachbargebietHinzufuegen(this.Gebiete.get(26).getName());
    this.Gebiete.get(12).NachbargebietHinzufuegen(this.Gebiete.get(14).getName());
    this.Gebiete.get(12).NachbargebietHinzufuegen(this.Gebiete.get(15).getName());
    
    //Ägypten
    this.Gebiete.get(13).NachbargebietHinzufuegen(this.Gebiete.get(12).getName());
    this.Gebiete.get(13).NachbargebietHinzufuegen(this.Gebiete.get(26).getName());
    this.Gebiete.get(13).NachbargebietHinzufuegen(this.Gebiete.get(30).getName());
    this.Gebiete.get(13).NachbargebietHinzufuegen(this.Gebiete.get(14).getName());
    
    //Ostafrika
    this.Gebiete.get(14).NachbargebietHinzufuegen(this.Gebiete.get(13).getName());
    this.Gebiete.get(14).NachbargebietHinzufuegen(this.Gebiete.get(12).getName());
    this.Gebiete.get(14).NachbargebietHinzufuegen(this.Gebiete.get(15).getName());
    this.Gebiete.get(14).NachbargebietHinzufuegen(this.Gebiete.get(16).getName());
    this.Gebiete.get(14).NachbargebietHinzufuegen(this.Gebiete.get(17).getName());
    this.Gebiete.get(14).NachbargebietHinzufuegen(this.Gebiete.get(30).getName());
    
    //Zentralafrika
    this.Gebiete.get(15).NachbargebietHinzufuegen(this.Gebiete.get(12).getName());
    this.Gebiete.get(15).NachbargebietHinzufuegen(this.Gebiete.get(14).getName());
    this.Gebiete.get(15).NachbargebietHinzufuegen(this.Gebiete.get(16).getName());
    
    //Südafrika
    this.Gebiete.get(16).NachbargebietHinzufuegen(this.Gebiete.get(15).getName());
    this.Gebiete.get(16).NachbargebietHinzufuegen(this.Gebiete.get(14).getName());
    this.Gebiete.get(16).NachbargebietHinzufuegen(this.Gebiete.get(17).getName());
    
    //Madagaskar
    
    
    
  }
  
  
  public void SpielerAnzeigen(ArrayList<Spieler> Spielernamen) {
    //Spieler auf der Karte anzeigen
    for (int i = 0;i<Spielernamen.size();i++){
      Namensliste.add (new JLabel(Spielernamen.get(i).getName()));               //Name einfügen
      panel.add (Namensliste.get(i));
      Namensliste.get(i).setForeground(Spielerfarben[i]);                        //Farbe vergeben
      Namensliste.get(i).setFont(this.getFont().deriveFont(25f));                //Schriftgröße festlegen
      Namensliste.get(i).setBounds(10, i*20, 100, 50);                           //Position und Größe festlegen
      Namensliste.get(i).setText(Spielernamen.get(i).getName());                 //Text festlegen
      Spielernamen.get(i).setFarbe(Spielerfarben[i]);                            //Dem Spieler seine Farbe bekanntgeben
      Namensliste.get(i).setFont(Namensliste.get(i).getFont().deriveFont(Font.BOLD));
    }
    
  }
  
  
  // Ende Methoden
} // end of Weltkarte
