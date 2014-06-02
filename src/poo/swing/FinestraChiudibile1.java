//*********************************************************
//
//  file FinestraChiudibile1.java
//
//  Altro esempio di finestra creabile con Java swing
//  e che risponde all'evento di chiusura (si clicca
//  sul pulsante X o si digita ALT-F4 etc.).
//  L'esempio illustrare il ruolo di "ascoltatore"
//  (listener) che e' un oggetto deputato (delegato)
//  a ricevere  e trattare gli eventi evocati
//  sulla finestra.
//  In FinestraChiudibile1 la classe Ascoltatore
//  e' programmata a parte dalla classe finestra.
//*********************************************************
package poo.swing;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class Ascoltatore implements WindowListener{
   public void windowActivated(WindowEvent e){}
   public void windowClosed(WindowEvent e){}
   public void windowClosing(WindowEvent e){ System.exit(0); }
   public void windowDeactivated(WindowEvent e){}
   public void windowIconified(WindowEvent e){}
   public void windowDeiconified(WindowEvent e){}
   public void windowOpened(WindowEvent e){}
}//Ascoltatore

public class FinestraChiudibile1 extends JFrame{
	
   public FinestraChiudibile1(){
      setTitle("Finestra Chiudibile");
      setSize(300,200);
      setLocation(50,200);//opzionale
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      addWindowListener( new Ascoltatore() );
   }
   public static void main( String []args ){
      Frame f=new FinestraChiudibile1();
      f.setVisible(true);
   }
}//FinestraChiudibile1
