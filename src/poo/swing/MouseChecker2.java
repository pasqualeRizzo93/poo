//*********************************************************
//
//  file MouseChecker.java
//
//  Applicazione dimostrativa di gestione degli
//  eventi del mouse. Tali eventi sono definiti nelle
//  interfacce MouseListener e MouseMotionListener
//  ed associate classi adapter.
//  L'evento di un mouse click da' luogo al disegno di
//  un quadratino di dimensione 10 pixel x 10 pixel.
//  L'evento di un doppio click sull'area di un
//  quadratino esistente ne richiede la cancellazione.
//  Il click su un quadratino seguito da dragging
//  (pulsante sinistro premuto mentre si sposta il
//  mouse) sposta il quadrato.
//  Muovendo semplicemente il mouse nell'area di
//  disegno, esso assume la forma di croce su un
//  quadratino e quella di freccia fuori da quadratini.
//  Adattamento da: C. Horstmann, G. Cornel, Core Java, 8 Ed, Vol.1
//*********************************************************

package poo.swing;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;


class MouseFrame extends JFrame{
   private class Punto{
	   int x, y;
	   public Punto( int x, int y ){ this.x=x; this.y=y; }
   }//Punto
	
   private static final int SIZE=10; //dimensione di una cella
   private java.util.List<Punto> celle=
	   new java.util.ArrayList<Punto>();
   private int current;
   private Pannello panel; //ricopre la finestra per la visualizzazione
   private MouseHandle m=null;
   
   public MouseFrame(){
      setTitle("Finestra Mouse Checker");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      add( panel=new Pannello(), "Center" );
      panel.addMouseListener( m=new MouseHandle() );
      panel.addMouseMotionListener( m );
      setSize(300,300);
   }//MouseFrame

   private class Pannello extends JPanel{//inner class
       public void paintComponent(Graphics g){
    	 super.paintComponent(g);
    	 Graphics2D g2=(Graphics2D)g;
    	 for( Punto p: celle ){
            Rectangle2D rect=
            	new Rectangle2D.Double( p.x-SIZE/2, p.y-SIZE/2, SIZE, SIZE );
            g2.draw( rect );
         }
       }
   }//Pannello

   private class MouseHandle extends MouseAdapter 
   implements MouseMotionListener{//inner class
      public void mousePressed(MouseEvent e){
         int x=e.getX();
         int y=e.getY();
         current=find(x,y);
         if( current<0 ) //fuori qualsiasi cella
            add(x,y);
      }
      public void mouseClicked(MouseEvent e){
         if( e.getClickCount()>=2 ) delete( current );
      }//moudeClicked
      public void mouseMoved(MouseEvent e){  	  
         int x=e.getX();
         int y=e.getY();
         if( find(x,y)>=0 )
            setCursor( Cursor.getPredefinedCursor
                     ( Cursor.CROSSHAIR_CURSOR ) );
         else
            setCursor( Cursor.getDefaultCursor() );
      }//mouseMoved
      public void mouseDragged(MouseEvent e){   	  
         int x=e.getX();
         int y=e.getY(); 
         current=find(x,y);
         if( current>=0 ){
            Graphics2D g2=(Graphics2D)panel.getGraphics();
            celle.remove(current);
            celle.add( new Punto(x,y) );
            Rectangle2D rect=
            	new Rectangle2D.Double(x-SIZE/2, y-SIZE/2, SIZE, SIZE);
            g2.draw( rect );
            e.getComponent().repaint();
         }
      }//mouseDragged
   }//MouseHandle
   
   private int find( int x, int y ){
      for( int i=0; i<celle.size(); i++ ){
         Punto p=celle.get(i);
         if( x>=p.x-SIZE/2 && x<=p.x+SIZE/2 &&
             y>=p.y-SIZE/2 && y<=p.y+SIZE/2 ) return i;
      }
      return -1;
   }//find
   private void add( int x, int y ){
      celle.add( new Punto(x,y) );
      panel.repaint();
   }//add
   private void delete( int n ){
      if( n>=0 && n<celle.size() ){
         celle.remove(n);
         panel.repaint();
      }
   }//delete
   
}//FinestraMouse

public class MouseChecker2{
	public static void main( String[] args ){
		EventQueue.invokeLater( new Runnable(){
			public void run(){
				MouseFrame f=new MouseFrame();
				f.setVisible(true);	
			}//run
		});
	}//main
}//MouseChecker

