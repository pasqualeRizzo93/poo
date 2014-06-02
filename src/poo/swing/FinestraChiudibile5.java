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
//  In FinestraChiudibile5 illustra il settagglio di default 
//  dell'operazione da eseguire alla chiusura della finestra.
//*********************************************************
package poo.swing;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FinestraChiudibile5 extends JFrame{

   public FinestraChiudibile5(){
      setTitle("Finestra Chiudibile");
      setSize(300,200);
      setLocation(50,200);//opzionale
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Default
   }
      
   public static void main( String []args ){
      JFrame f=new FinestraChiudibile5();
      f.setVisible(true);
   }
}//FinestraChiudibile3
