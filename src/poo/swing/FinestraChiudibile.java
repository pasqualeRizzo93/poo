//*********************************************************
//
//  file FinestraChiudibile.java
//
//  Esempio di finestra creabile con Java swing
//  che risponde all'evento di chiusura (si clicca
//  sul pulsante X o si digita ALT-F4 etc.).
//  L'esempio illustra il ruolo di "ascoltatore"
//  (listener) che e' un oggetto deputato (delegato)
//  a ricevere  e trattare gli eventi evocati
//  sulla finestra.
//  In FinestraChiudibile la classe Ascoltatore
//  e' programmata all'interno della classe finestra
//  ed estende la classe WindowAdapter che "implementa"
//  i metodi di WindowListener come metodi vuoti.
//  La particolarita' consiste nell'uso
//  di una inner class anonima che estende WindowAdapter
//  ed e' istanziata tutto in uno.
//*********************************************************
package poo.swing;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Finestra extends JFrame{

   public Finestra(){
      setTitle("Finestra Chiudibile");
      setSize(300,200);
      setLocation(50,200);
      setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

     // setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
/*     
addWindowListener( new WindowAdapter(){
         public void windowClosing(WindowEvent e)//callback
         { System.exit(0); }//od altra gestione come opportuno
      } );
*/
   }

}//Finestra

public class FinestraChiudibile{
   public static void main( String []args ){
      Frame f=new Finestra();
      f.setVisible(true);			   
   }
}//FinestraChiudibile
