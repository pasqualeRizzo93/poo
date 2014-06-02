//*********************************************************
//
//  file FinestraChiudibile3.java
//
//  Altro esempio di finestra creabile con Java swing
//  e che risponde all'evento di chiusura (si clicca
//  sul pulsante X o si digita ALT-F4 etc.).
//  L'esempio illustra il ruolo di "ascoltatore"
//  (listener) che e' un oggetto deputato (delegato)
//  a ricevere  e trattare gli eventi evocati
//  sulla finestra.
//  In FinestraChiudibile4 la classe Ascoltatore
//  e' programmata all'interno della classe finestra
//  ma estende la classe WindowAdapter che "implementa"
//  i metodi di WindowListener come metodi vuoti.
//  WindowAdapter consente di riprogrammare solo
//  il metodo windowClosing e di disinteressarsi
//  degli altri.
//*********************************************************
package poo.swing;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FinestraChiudibile4 extends JFrame{

   public FinestraChiudibile4(){
      setTitle("Finestra Chiudibile");
      setSize(300,200);
      setLocation(50,200);//opzionale
      setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
      /*
       * Estensione ed istanziazione tutt'uno
       */
      addWindowListener( new WindowAdapter(){
    	  public void windowClosing(WindowEvent e){
    		  System.exit(0);
    	  }
      });
   }
   public static void main( String []args ){
      JFrame f=new FinestraChiudibile4();
      f.setVisible(true);
   }
}//FinestraChiudibile3
