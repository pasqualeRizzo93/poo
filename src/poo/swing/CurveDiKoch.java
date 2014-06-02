package poo.swing;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * Frattale "Fiocco di Neve" o curve di Koch.
 * Usa la ricorsione.
 * Da un segmento s=(a,b), la trasformazione di Koch consiste
 * nel suddividere s in tre parti uguali: ------......------
 * Da questa suddivisione si individuano quattro nuovi segmenti s1, s2, s3 e s4.
 * I tratti s1 ed s4 coincidono con la prima e l'ultima suddivisione. I tratti
 * s2 ed s3 sono i segmenti costruiti sul tratto centrale, a formare
 * un triangolo equilatero:
 * 
 *          /\
 *       s2/  \s3
 *  --s1--/....\--s4--
 *
 * Il processo di costruzione continua ripetendo su i quattro segmenti
 * la stessa trasformazione, sino a che la dimensione (in pixel) dei segmenti
 * non scende sotto una soglia prefissata.
 * Si usa un pannello grafico e la costruzione ricorsiva delle curve di Kock
 * e' affidata ad un metodo invocato da dentro paintComponent.
 */
public class CurveDiKoch {
	public static void main( String[] args ){
		EventQueue.invokeLater( new Runnable(){
			public void run(){
				MainWindow mw=new MainWindow();
				mw.setVisible(true);
			}
		});
	}//main
}//CurveDiKoch

class MainWindow extends JFrame{
	public MainWindow(){
		setTitle("Fiocco di Neve - Curve di Koch");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Pannello p=new Pannello();
		add(p);	
		pack();
		setSize(600,500);
	}
	
	private class Pannello extends JPanel{
		private int soglia=3;
		private double d;
		private Graphics g;
		public void paintComponent( Graphics g ){
			super.paintComponent(g);
			this.g=g;
			System.out.println("paintComponent chiamata...");
	        setBackground( Color.white );
	        koch(100,200,500,200,1);
	        koch(100,200,500,200,-1);
		}//paintComponent
		public void koch( int x1, int y1, int x2, int y2, int up ){
			int x3, x4, x5, y3, y4, y5;
			d=Math.sqrt(Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1)));
			if( d<soglia ) g.drawLine(x1, y1, x2, y2);
			else{
				x3=x1+Math.round((x2-x1)/3); //calcola i quattro segmenti
				y3=y1+Math.round((y2-y1)/3);
				x4=x1+Math.round(2*((x2-x1)/3));
				y4=y1+Math.round(2*((y2-y1)/3));
				x5=Math.round( (x1+x2)/2-(int)((up*(y2-y1))/3.4641) );
				y5=Math.round( (y1+y2)/2+(int)((up*(x2-x1))/3.4641) );
				//chiamate ricorsive sui nuovi quattro segmenti
				koch(x1,y1,x3,y3,up);
				koch(x3,y3,x5,y5,up);
				koch(x5,y5,x4,y4,up);
				koch(x4,y4,x2,y2,up);
			}
		}//koch
	}//Pannello
	
}//MainWindow


