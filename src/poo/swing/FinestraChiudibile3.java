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
//  In FinestraChiudibile3 la classe Ascoltatore
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

public class FinestraChiudibile3 extends JFrame{

   private class Ascoltatore extends WindowAdapter{
      public void windowClosing(WindowEvent e){
         System.exit(0);
      }
   }

   public FinestraChiudibile3(){
      setTitle("Finestra Chiudibile");
      setSize(300,200);
      setLocation(50,200);//opzionale
      addWindowListener( new Ascoltatore() );
   }
   public static void main( String []args ){
      Frame f=new FinestraChiudibile3();
      f.setVisible(true);
   }
}//FinestraChiudibile3
