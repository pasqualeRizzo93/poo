package poo.agendina;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
class FinestraGUI extends JFrame{
	 private File fileDiSalvataggio=null;
	 private JMenuItem tipoAL, tipoLL, tipoSet, tipoMap,
	 				   apri, salva, salvaConNome, esci, about,
	 				   aggiungiNominativo, rimuoviNominativo,
	 				   numeroNominativi, svuota,
	 				   telefonoDi, personaDi, elenco;
	 private String titolo="Agendina GUI";
	 private String impl=" Map ";
	 private Agendina agendina=null;
	 private int capacita=50; //default per array list
	 private FrameAggiungiNominativo fAN=null;
	 private String cognome, nome, prefisso, telefono;
	 private boolean cognomeOk, nomeOk, prefissoOk, telefonoOk;
	 private FrameRimuoviNominativo fRN=null;
	 private FrameTelefonoDi fTD=null;
	 private FramePersonaDi fPD=null;
	 
	 public FinestraGUI(){
		 setTitle(titolo+impl);
		 
		 setDefaultCloseOperation( JFrame.DO_NOTHING_ON_CLOSE );
         addWindowListener( new WindowAdapter() {
	        public void windowClosing(WindowEvent e){
	       	 if( consensoUscita() ) System.exit(0);
	        }
	     } );

         AscoltatoreEventiAzione listener=new AscoltatoreEventiAzione();
         
         //creazione barra dei menu'
         JMenuBar menuBar=new JMenuBar();
         this.setJMenuBar( menuBar );
         
         //creazione file menu
         JMenu fileMenu=new JMenu("File");
         menuBar.add(fileMenu);
         //creazione voci del menu File
         JMenu tipoImpl=new JMenu("Nuova");
         fileMenu.add(tipoImpl);        
         tipoAL=new JMenuItem("ArrayList");
         tipoAL.addActionListener(listener);
         tipoImpl.add(tipoAL);
         tipoLL=new JMenuItem("LinkedList");
         tipoLL.addActionListener(listener);
         tipoImpl.add(tipoLL);         
         tipoSet=new JMenuItem("Set");
         tipoSet.addActionListener(listener);
         tipoImpl.add(tipoSet);
         tipoMap=new JMenuItem("Map");
         tipoMap.addActionListener(listener);
         tipoImpl.add(tipoMap);            
         fileMenu.addSeparator();
         
         apri=new JMenuItem("Apri");
         apri.addActionListener(listener);
         fileMenu.add(apri);
         salva=new JMenuItem("Salva");
         salva.addActionListener(listener);
         fileMenu.add(salva);
         salvaConNome=new JMenuItem("Salva con nome");
         salvaConNome.addActionListener(listener);
         fileMenu.add(salvaConNome);
         fileMenu.addSeparator();
         esci=new JMenuItem("Esci");
         esci.addActionListener(listener);
         fileMenu.add(esci);

         //creazione menu Comandi
         JMenu commandMenu=new JMenu("Comandi");
         menuBar.add(commandMenu);
         //creazione voci del menu Gestione
         aggiungiNominativo=new JMenuItem("Aggiungi nominativo");
         aggiungiNominativo.addActionListener(listener);
         commandMenu.add(aggiungiNominativo);
         rimuoviNominativo=new JMenuItem("Rimuovi nominativo");
         rimuoviNominativo.addActionListener(listener);
         commandMenu.add(rimuoviNominativo);
         numeroNominativi=new JMenuItem("Numero nominativi");
         numeroNominativi.addActionListener(listener);
         commandMenu.add(numeroNominativi);
         svuota=new JMenuItem("Svuota agendina");
         svuota.addActionListener(listener);
         commandMenu.add(svuota);         
         commandMenu.addSeparator();
         telefonoDi=new JMenuItem("Telefono di");
         telefonoDi.addActionListener(listener);
         commandMenu.add(telefonoDi);
         personaDi=new JMenuItem("Persona di");
         personaDi.addActionListener(listener);
         commandMenu.add(personaDi);   
         elenco=new JMenuItem("Elenco");
         elenco.addActionListener(listener);
         commandMenu.add(elenco);
         
         //creazione menu Help
         JMenu helpMenu=new JMenu("Help");
         menuBar.add(helpMenu);
         about=new JMenuItem("About");
         about.addActionListener(listener);
         helpMenu.add(about);
         
         menuIniziale();
         
         pack();
         
         setLocation(200,200);
         setSize(500,400);
	 }//costruttore
	 private class FrameAL extends JFrame implements ActionListener{
    	 private JTextField capacita;
    	 private JButton ok;
    	 public FrameAL(){
    		 setTitle("Capacita' Array List");
    		 setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	     JPanel p=new JPanel();
    	     p.setLayout( new FlowLayout() ); //ridondante
    	     p.add( new JLabel("Capacita'", JLabel.RIGHT) );
    	     p.add( capacita=new JTextField("50",12) );
    	     p.add( ok=new JButton("OK") );
    	     add(p);	 
    		 capacita.addActionListener(this);
    		 ok.addActionListener(this);
    		 setLocation(250,340);
    		 setSize(400,100);
    	 }
    	 public void actionPerformed( ActionEvent e ){
    		 if( e.getSource()==capacita ){
    			 FinestraGUI.this.capacita=Integer.parseInt( capacita.getText() );
     		 }
    		 else if( e.getSource()==ok ){    
    			 agendina=new AgendinaAL(FinestraGUI.this.capacita);    	
    			 menuAvviato();
    			 this.dispose();
    		 }
    	 }//actionPerformed
     }//FrameAL
	 private class FrameVector extends JFrame implements ActionListener{
    	 private JTextField capacita;
    	 private JButton ok;
    	 public FrameVector(){
    		 setTitle("Capacita' Vector");
    		 setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	     JPanel p=new JPanel();
    	     p.setLayout( new FlowLayout() ); //ridondante
    	     p.add( new JLabel("Capacita'", JLabel.RIGHT) );
    	     p.add( capacita=new JTextField("50",12) );
    	     p.add( ok=new JButton("OK") );
    	     add(p);	 
    		 capacita.addActionListener(this);
    		 ok.addActionListener(this);
    		 setLocation(250,340);
    		 setSize(400,100);
    	 }
    	 public void actionPerformed( ActionEvent e ){
    		 if( e.getSource()==capacita ){
    			 FinestraGUI.this.capacita=Integer.parseInt( capacita.getText() );
     		 }
    		 else if( e.getSource()==ok ){    
    			 agendina=new AgendinaVector(FinestraGUI.this.capacita);    	
    			 menuAvviato();
    			 this.dispose();
    		 }
    	 }//actionPerformed
     }//FrameVector	 
	 private class FrameAggiungiNominativo extends JFrame implements ActionListener{
    	 private JTextField cognome, nome, prefisso, telefono;
    	 private JButton ok;
    	 public FrameAggiungiNominativo(){
    		 setTitle("Aggiunta Nominativo");
    		 setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    	     addWindowListener( new WindowAdapter() {
    	    	 public void windowClosing(WindowEvent e){
    		       	 if( verificaUscita() ){
        				 agendina.aggiungi( 
        					new Nominativo( 
        						 FinestraGUI.this.cognome.toUpperCase(),
        						 FinestraGUI.this.nome.toUpperCase(),
        						 FinestraGUI.this.prefisso,
        						 FinestraGUI.this.telefono )
        				 );    		       		 
    		       	 }
		       		 cognome.setText("");
    				 nome.setText("");
    				 prefisso.setText("");
    				 telefono.setText("");
    				 cognomeOk=false;
    				 nomeOk=false;
    				 prefissoOk=false;
    				 telefonoOk=false;    		       	 
		       		 FrameAggiungiNominativo.this.setVisible(false);
    		        }
    		     }//windowClosing
    	     );
    	     cognomeOk=false;
    	     nomeOk=false;
    	     prefissoOk=false;
    	     telefonoOk=false;
    	     JPanel p=new JPanel();
    	     p.setLayout( new FlowLayout() ); //ridondante
    	     p.add( new JLabel("Cognome", JLabel.RIGHT) );
    	     p.add( cognome=new JTextField("",12) );
       	     p.add( new JLabel("Nome", JLabel.RIGHT) );
    	     p.add( nome=new JTextField("",12) );  
       	     p.add( new JLabel("Prefisso", JLabel.RIGHT) );
    	     p.add( prefisso=new JTextField("",12) );    	     
       	     p.add( new JLabel("Telefono", JLabel.RIGHT) );
    	     p.add( telefono=new JTextField("",12) );    	     
    	     p.add( ok=new JButton("OK") );
    	     add(p);	 
    		 cognome.addActionListener(this);
    		 nome.addActionListener(this);
    		 prefisso.addActionListener(this);
    		 telefono.addActionListener(this);
    		 ok.addActionListener(this); 		 
    		 
    		 setLocation(250,340);
    		 setSize(400,150);
    	 }
    	 public void actionPerformed( ActionEvent e ){
    		 if( e.getSource()==cognome ){
    			 FinestraGUI.this.cognome=cognome.getText();
    			 FinestraGUI.this.cognomeOk=true;
     		 }
    		 if( e.getSource()==nome ){
    			 FinestraGUI.this.nome=nome.getText();  			 
    			 FinestraGUI.this.nomeOk=true;
     		 }
    		 if( e.getSource()==prefisso ){
    			 FinestraGUI.this.prefisso=prefisso.getText(); 
    			 FinestraGUI.this.prefissoOk=true;
     		 }  
    		 if( e.getSource()==telefono ){
    			 FinestraGUI.this.telefono=telefono.getText();
    			 FinestraGUI.this.telefonoOk=true;
     		 }    		 
    		 else if( e.getSource()==ok ){
    			 if( verificaUscita() ){
    				 agendina.aggiungi( 
    					new Nominativo( 
    						 FinestraGUI.this.cognome.toUpperCase(),
    						 FinestraGUI.this.nome.toUpperCase(),
    						 FinestraGUI.this.prefisso,
    						 FinestraGUI.this.telefono )
    				 );
      				 this.setVisible(false);
    				 cognomeOk=false;
    				 nomeOk=false;
    				 prefissoOk=false;
    				 telefonoOk=false;
    				 cognome.setText("");
    				 nome.setText("");
    				 prefisso.setText("");
    				 telefono.setText("");
     			 }  			 
    		 }
    	 }//actionPerformed
    	 private boolean verificaUscita(){
    		 return cognomeOk && nomeOk && prefissoOk && telefonoOk;
    	 }//verificaUscita
     }//FrameAggiungiNominativo
	 private class FrameRimuoviNominativo extends JFrame implements ActionListener{
    	 private JTextField cognome, nome;
    	 private JButton ok;
    	 public FrameRimuoviNominativo(){
    		 setTitle("Rimozione Nominativo");
    		 setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    	     addWindowListener( new WindowAdapter() {
    	    	 public void windowClosing(WindowEvent e){
    	    		 if( verificaUscita() ){
    		        	agendina.rimuovi( 
    		        		new Nominativo( 
    		        			FinestraGUI.this.cognome.toUpperCase(),
    		        			FinestraGUI.this.nome.toUpperCase(),
    		        			"", "" )
    		        		);  
    		       	 }
    				 cognomeOk=false;
    				 nomeOk=false;
    				 cognome.setText("");
    				 nome.setText("");    		        	
		       		 FrameRimuoviNominativo.this.setVisible(false);
    		     }//windowClosing
    		 } );
    	     cognomeOk=false;
    	     nomeOk=false;
    	     prefissoOk=false;
    	     telefonoOk=false;
    	     JPanel p=new JPanel();
    	     p.setLayout( new FlowLayout() ); //ridondante
    	     p.add( new JLabel("Cognome", JLabel.RIGHT) );
    	     p.add( cognome=new JTextField("",12) );
       	     p.add( new JLabel("Nome", JLabel.RIGHT) );
    	     p.add( nome=new JTextField("",12) );  
     
    	     p.add( ok=new JButton("OK") );
    	     add(p);	 
    		 cognome.addActionListener(this);
    		 nome.addActionListener(this);

    		 ok.addActionListener(this); 		 
    		 
    		 setLocation(250,340);
    		 setSize(400,150);
    	 }
    	 public void actionPerformed( ActionEvent e ){
    		 if( e.getSource()==cognome ){
    			 FinestraGUI.this.cognome=cognome.getText();
    			 FinestraGUI.this.cognomeOk=true;
     		 }
    		 if( e.getSource()==nome ){
    			 FinestraGUI.this.nome=nome.getText();  			 
    			 FinestraGUI.this.nomeOk=true;
     		 }
    		 else if( e.getSource()==ok ){
    			 if( verificaUscita() ){
    				 agendina.rimuovi( new Nominativo( 
    						 FinestraGUI.this.cognome.toUpperCase(),
    						 FinestraGUI.this.nome.toUpperCase(), "","" ));
    				 this.setVisible(false);
    				 cognome.setText("");
    				 nome.setText("");
    			 }
    		 }
    	 }//actionPerformed
    	 private boolean verificaUscita(){
    		 return cognomeOk && nomeOk;
    	 }//verificaUscita
     }//FrameRimuoviNominativo
	 private class FrameTelefonoDi extends JFrame implements ActionListener{
    	 private JTextField cognome, nome;
    	 private JButton ok;
    	 public FrameTelefonoDi(){
    		 setTitle("Ricerca telefono di un nominativo");
    		 setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    	     addWindowListener( new WindowAdapter() {
    		        public void windowClosing(WindowEvent e){
    		       	 if( verificaUscita() ){
        				 Nominativo n=agendina.cerca( 
        					new Nominativo( 
        						 FinestraGUI.this.cognome.toUpperCase(),
        						 FinestraGUI.this.nome.toUpperCase(),
        						 "", "" ));    		       		 
        				 cognome.setText("");
        				 nome.setText("");
           				 if( n!=null )
        					 JOptionPane.showMessageDialog(null, "Telefono della persona cercata: "+
        						 n.getPrefisso()+"-"+n.getTelefono() );
        				 else
        					 JOptionPane.showMessageDialog(null, "Nominativo inesistente!" );    			
    		       	 }
		       		 FrameTelefonoDi.this.setVisible(false);
    		        }
    		     } );
    	     cognomeOk=false;
    	     nomeOk=false;
    	     JPanel p=new JPanel();
    	     p.setLayout( new FlowLayout() ); //ridondante
    	     p.add( new JLabel("Cognome", JLabel.RIGHT) );
    	     p.add( cognome=new JTextField("",12) );
       	     p.add( new JLabel("Nome", JLabel.RIGHT) );
    	     p.add( nome=new JTextField("",12) );  
     
    	     p.add( ok=new JButton("OK") );
    	     add(p);	 
    		 cognome.addActionListener(this);
    		 nome.addActionListener(this);

    		 ok.addActionListener(this); 		 
    		 
    		 setLocation(250,340);
    		 setSize(400,150);
    	 }
    	 public void actionPerformed( ActionEvent e ){
    		 if( e.getSource()==cognome ){
    			 FinestraGUI.this.cognome=cognome.getText();
    			 FinestraGUI.this.cognomeOk=true;
     		 }
    		 if( e.getSource()==nome ){
    			 FinestraGUI.this.nome=nome.getText();  			 
    			 FinestraGUI.this.nomeOk=true;
     		 }
    		 else if( e.getSource()==ok ){
    			 if( verificaUscita() ){
    				 Nominativo n=
    				 agendina.cerca( new Nominativo( 
    						 FinestraGUI.this.cognome.toUpperCase(),
    						 FinestraGUI.this.nome.toUpperCase(), "","" ));
    				 this.setVisible(false);
    				 cognome.setText("");
    				 nome.setText("");
    				 if( n!=null )
    					 JOptionPane.showMessageDialog(null, "Telefono della persona cercata: "+
    						 n.getPrefisso()+"-"+n.getTelefono() );
    				 else
    					 JOptionPane.showMessageDialog(null, "Nominativo inesistente!" );    					 
    			 }
    		 }
    	 }//actionPerformed
    	 private boolean verificaUscita(){
    		 return cognomeOk && nomeOk;
    	 }//verificaUscita
     }//FrameTelefonoDi		 
	 private class FramePersonaDi extends JFrame implements ActionListener{
    	 private JTextField prefisso, telefono;
    	 private JButton ok;
    	 public FramePersonaDi(){
    		 setTitle("Ricerca persona di prefisso e telefono");
    		 setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    	     addWindowListener( new WindowAdapter() {
    		        public void windowClosing(WindowEvent e){
    		       	 if( verificaUscita() ){
        				 Nominativo n=agendina.cerca(  
        						 FinestraGUI.this.prefisso,
        						 FinestraGUI.this.telefono );    		       		 
        				 prefisso.setText("");
        				 telefono.setText("");
           				 if( n!=null )
        					 JOptionPane.showMessageDialog(null, "Persona trovata: "+
        						 n.getCognome().toUpperCase()+" "+n.getNome().toUpperCase() );
        				 else
        					 JOptionPane.showMessageDialog(null, "Nominativo inesistente!" );    			
    		       	 }
		       		 FramePersonaDi.this.setVisible(false);
    		        }
    		     } );
    	     prefissoOk=false;
    	     telefonoOk=false;
    	     JPanel p=new JPanel();
    	     p.setLayout( new FlowLayout() ); //ridondante
    	     p.add( new JLabel("Prefisso", JLabel.RIGHT) );
    	     p.add( prefisso=new JTextField("",12) );
       	     p.add( new JLabel("Telefono", JLabel.RIGHT) );
    	     p.add( telefono=new JTextField("",12) );  
     
    	     p.add( ok=new JButton("OK") );
    	     add(p);	 
    		 prefisso.addActionListener(this);
    		 telefono.addActionListener(this);

    		 ok.addActionListener(this); 		 
    		 
    		 setLocation(250,340);
    		 setSize(400,150);
    	 }
    	 public void actionPerformed( ActionEvent e ){
    		 if( e.getSource()==prefisso ){
    			 FinestraGUI.this.prefisso=prefisso.getText();
    			 FinestraGUI.this.prefissoOk=true;
     		 }
    		 if( e.getSource()==telefono ){
    			 FinestraGUI.this.telefono=telefono.getText();  			 
    			 FinestraGUI.this.telefonoOk=true;
     		 }
    		 else if( e.getSource()==ok ){
    			 if( verificaUscita() ){
    				 Nominativo n=
    				 agendina.cerca(
    						 FinestraGUI.this.prefisso,
    						 FinestraGUI.this.telefono );
    				 this.setVisible(false);
    				 prefisso.setText("");
    				 telefono.setText("");
    				 if( n!=null )
    					 JOptionPane.showMessageDialog(null, "Persona trovata: "+
    						 n.getCognome().toUpperCase()+" "+n.getNome().toUpperCase() );
    				 else
    					 JOptionPane.showMessageDialog(null, "Nominativo inesistente!" );    					 
    			 }
    		 }
    	 }//actionPerformed
    	 private boolean verificaUscita(){
    		 return prefissoOk && telefonoOk;
    	 }//verificaUscita
     }//FramePersonaDi	 
	 private class FrameElenco extends JFrame{
    	 private JTextArea area;
    	 public FrameElenco(){
    		 setTitle("Elenco Nominativi");
    		 setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	     JPanel p=new JPanel();
    	     p.setLayout( new FlowLayout() ); //ridondante
    	     JTextArea area=new JTextArea(10, 25);
    	     area.setEditable(false);
    	 	 JScrollPane sp=new JScrollPane( area );
    	     p.add( sp ); 
    	     add(p);
    	     if( agendina.size()!=0 )
    	    	 area.append( agendina.toString() );
    	     else
    	    	 area.append("Agendina vuota!");
    		 setLocation(250,340);
    		 setSize(400,150);
    	 }
     }//FrameElenco
	 private void menuIniziale(){
		 apri.setEnabled(false);
		 salva.setEnabled(false);
		 salvaConNome.setEnabled(false);
		 aggiungiNominativo.setEnabled(false);
		 rimuoviNominativo.setEnabled(false);
		 numeroNominativi.setEnabled(false);
		 svuota.setEnabled(false);
		 telefonoDi.setEnabled(false);
		 personaDi.setEnabled(false);
		 elenco.setEnabled(false);		 
	 }//menuIniziale
	 private void menuAvviato(){
		 tipoAL.setEnabled(false);
		 tipoLL.setEnabled(false);
		 tipoSet.setEnabled(false);
		 tipoMap.setEnabled(false);
		 apri.setEnabled(true);
		 salva.setEnabled(true);
		 salvaConNome.setEnabled(true);
		 aggiungiNominativo.setEnabled(true);
		 rimuoviNominativo.setEnabled(true);
		 numeroNominativi.setEnabled(true);
		 svuota.setEnabled(true);
		 telefonoDi.setEnabled(true);
		 personaDi.setEnabled(true);
		 elenco.setEnabled(true);			 
	 }//menuAvviato
     private boolean consensoUscita(){
	   int option=JOptionPane.showConfirmDialog(
			   null, "Continuare ?", "Uscendo si perderanno tutti i dati!",
			   JOptionPane.YES_NO_OPTION);
	   return option==JOptionPane.YES_OPTION;
	 }//consensoUscita
     private class AscoltatoreEventiAzione implements ActionListener{
  	   public void actionPerformed(ActionEvent e){
  		   if( e.getSource()==esci ){
  			   if( consensoUscita() ) System.exit(0);
  		   }
  		   else if( e.getSource()==tipoAL ){
  			   impl=" AL ";
  			   FinestraGUI.this.setTitle(titolo+impl); 	
  			   FrameAL frameAL=new FrameAL();
  			   frameAL.setVisible(true);
  		   }	   
  		   else if( e.getSource()==tipoLL ){
  			   impl=" LL ";
  			   FinestraGUI.this.setTitle(titolo+impl); 	
  			   agendina=new AgendinaLL();
  			   menuAvviato();
  		   }  		
  		   else if( e.getSource()==tipoSet ){
  			   impl=" Set ";
  			   FinestraGUI.this.setTitle(titolo+impl); 	
  			   agendina=new AgendinaSet();
  			   menuAvviato();
  		   }  	
  		   else if( e.getSource()==tipoMap ){
  			   impl=" Map ";
  			   FinestraGUI.this.setTitle(titolo+impl); 	
  			   agendina=new AgendinaMap();
  			   menuAvviato();
  		   }  		   
  		   else if( e.getSource()==salva ){
  			   //file chooser
  			   JFileChooser chooser=new JFileChooser();
  			   try{
  				   if( fileDiSalvataggio!=null ){
  					   int ans=JOptionPane.showConfirmDialog(null,"Sovrascrivere "+fileDiSalvataggio.getAbsolutePath()+" ?");
					   if( ans==0 /*SI*/)
						   agendina.salva( fileDiSalvataggio.getAbsolutePath() );
					   else
						   JOptionPane.showMessageDialog(null,"Nessun salvataggio!");
					   return;
				   }
  				   if( chooser.showSaveDialog(null)==JFileChooser.APPROVE_OPTION ){
  					   fileDiSalvataggio=chooser.getSelectedFile();
  					   FinestraGUI.this.setTitle(titolo+impl+" - "+fileDiSalvataggio.getName());
  				   }
  				   if( fileDiSalvataggio!=null ){
  					   agendina.salva( fileDiSalvataggio.getAbsolutePath() );
  				   }
  				   else
  					   JOptionPane.showMessageDialog(null,"Nessun Salvataggio!");
  			   }catch( Exception exc ){
  				   exc.printStackTrace();
  			   }
  		   }
  		   else if( e.getSource()==salvaConNome ){
  			   //file chooser
  			   JFileChooser chooser=new JFileChooser();
  			   try{
  				   if( chooser.showSaveDialog(null)==JFileChooser.APPROVE_OPTION ){
  						   fileDiSalvataggio=chooser.getSelectedFile();
  						   FinestraGUI.this.setTitle(titolo+impl+" - "+fileDiSalvataggio.getName());
  					   }
  				   if( fileDiSalvataggio!=null ){
  					   agendina.salva( fileDiSalvataggio.getAbsolutePath() );
  				   }
  				   else
  					   JOptionPane.showMessageDialog(null,"Nessun Salvataggio!");
  			   }catch( Exception exc ){
  				   exc.printStackTrace();
  			   }  			   
  		   }
  		   else if( e.getSource()==apri ){
  			   //file chooser
  			   JFileChooser chooser=new JFileChooser();
  			   try{
  				   if( chooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION ){
  					   if( !chooser.getSelectedFile().exists() ){
  						   JOptionPane.showMessageDialog(null,"File inesistente!"); 
  					   }
  					   else{	
  						   fileDiSalvataggio=chooser.getSelectedFile();
  						   FinestraGUI.this.setTitle(titolo+impl+" - "+fileDiSalvataggio.getName());
  						   try{
  							   agendina.ripristina( fileDiSalvataggio.getAbsolutePath() );
  						   }catch(IOException ioe){
  							   JOptionPane.showMessageDialog(null,"Fallimento apertura. File malformato!");
  						   }
  					   }
  				   }
  				   else
  					   JOptionPane.showMessageDialog(null,"Nessuna apertura!");
  			   }catch( Exception exc ){
  				   exc.printStackTrace();
  			   }
  		   }
  		   else if( e.getSource()==aggiungiNominativo ){
  			   if( fAN==null ) fAN=new FrameAggiungiNominativo();
  			   fAN.setVisible(true);
  		   }
  		   else if( e.getSource()==rimuoviNominativo ){
  			   if( fRN==null ) fRN=new FrameRimuoviNominativo();
  			   fRN.setVisible(true);
  		   }
  		   else if( e.getSource()==telefonoDi ){
  			   if( fTD==null ) fTD=new FrameTelefonoDi();
  			   fTD.setVisible(true);
  		   }
  		   else if( e.getSource()==personaDi ){
  			   if( fPD==null ) fPD=new FramePersonaDi();
  			   fPD.setVisible(true);  			   
  		   }
  		   else if( e.getSource()==numeroNominativi ){
  			   JOptionPane.showMessageDialog(null, "Numero nominativi in agenda: "+agendina.size());
  		   }
  		   else if( e.getSource()==svuota ){
  			   agendina.svuota();
  		   }
  		   else if( e.getSource()==elenco ){
  			   FrameElenco fE=new FrameElenco();
  			   fE.setVisible(true);
  		   }
  		   else if( e.getSource()==about ){
  			   JOptionPane.showMessageDialog( null,
  					   "Programma di Gestione di un'Agendina Telefonica\n",
  						"About", JOptionPane.PLAIN_MESSAGE );
  		   }
  	   }
     }//AscoltatoreEventiAzione
}//FinestraGUI
public class AgendinaGUI {
	public static void main( String []args ){
		FinestraGUI f=new FinestraGUI();
		f.setVisible(true);
	}//main
}//AgendinaGUI
