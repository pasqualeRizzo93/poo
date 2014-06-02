//*********************************************************
//
//  file FinestraChiudibile2.java
//
//  Altro esempio di finestra creabile con Java swing
//  e che risponde all'evento di chiusura (si clicca
//  sul pulsante X o si digita ALT-F4 etc.).
//  L'esempio illustra il ruolo di "ascoltatore"
//  (listener) che e' un oggetto deputato (delegato)
//  a ricevere  e trattare gli eventi evocati
//  sulla finestra.
//  In FinestraChiudibile2 la classe Ascoltatore
//  e' programmata all'interno della classe finestra.
//*********************************************************
package poo.swing;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FinestraChiudibile2 extends JFrame{

   private class Ascoltatore implements WindowListener{
      public void windowActivated(WindowEvent e){}
      public void windowClosed(WindowEvent e){}
      public void windowClosing(WindowEvent e){ System.exit(0); }
      public void windowDeactivated(WindowEvent e){}
      public void windowIconified(WindowEvent e){}
      public void windowDeiconified(WindowEvent e){}
      public void windowOpened(WindowEvent e){}
   }

   public FinestraChiudibile2(){
      setTitle("Finestra Chiudibile");
      setSize(300,200);
      setLocation(50,200);//opzionale
      setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
      addWindowListener( new Ascoltatore() );
   }
   public static void main( String []args ){
      Frame f=new FinestraChiudibile2();
      f.setVisible(true);
   }
}//FinestraChiudibile2
