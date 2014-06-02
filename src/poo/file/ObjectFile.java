package poo.file;
import java.io.*;
public class ObjectFile<T extends Serializable>{
	public enum Modo{ LETTURA, SCRITTURA };
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private String nomeFile;
	private T buffer; //anticipa prossimo elemento del file
	private Modo modo;
	
	public ObjectFile( String nomeFile, Modo modo ) throws IOException{
		this.nomeFile=nomeFile;
		this.modo=modo;
		buffer=null;
		if( modo==Modo.LETTURA ){
			try{
				this.ois=new ObjectInputStream( new FileInputStream(nomeFile) );
				buffer=(T)ois.readObject();
			}catch( Exception e ){
				buffer=null;
			}
		}
		else
			this.oos=new ObjectOutputStream( new FileOutputStream(nomeFile) );
	}
	
	public String getNomeFile(){ return nomeFile; }
	
	public Modo modo(){ return modo; }
	
	public void open( Modo modo ) throws IOException{
		close();
		this.modo=modo;
		buffer=null;
		if( modo==Modo.LETTURA ){
			try{
				this.ois=new ObjectInputStream( new FileInputStream(nomeFile) );
				buffer=(T)ois.readObject();
			}catch( Exception e ){
				buffer=null;
			}
		}
		else
			this.oos=new ObjectOutputStream(new FileOutputStream(nomeFile) );
	}//modo
	
	public void close() throws IOException{
		if( modo==Modo.LETTURA ) ois.close();
		else oos.close();
	}//close
	
	public boolean eof(){
		if( modo==Modo.SCRITTURA ) return true;
		return buffer==null;
	}//next
	
	public T peek() throws IOException{
		if( eof() )	throw new EOFException();
		return buffer;
	}//peek
	
	public void get() throws IOException{
		if( eof() )	throw new EOFException();
		try{
			buffer=(T)ois.readObject();
		}catch( Exception e ){
			buffer=null;
		}		
	}//get
	
	public void put( T x ) throws IOException{
		if( modo==Modo.LETTURA ) throw new IOException();
		try{
			oos.writeObject( x );
		}catch( Exception e ){
			throw new IOException();
		}
	}//put

	public String toString(){
		StringBuilder sb=new StringBuilder(500);
		sb.append('[');
		try{
			ObjectInputStream is=new ObjectInputStream( new FileInputStream(nomeFile) );
			T x=null;
			for(;;){
				try{
					x=(T)is.readObject();
				}catch( EOFException eof ){ 
					break; 
				}catch( ClassNotFoundException cnf ){ 
					return null; 
				}
				sb.append( x );
				sb.append(", ");
			}
			sb.setLength( sb.length()-2 ); //rimuove i caratteri in eccesso ", "
			sb.append(']');
			is.close();
		}catch(Exception e){ 
			return null; 
		}
		return sb.toString();
	}//toString
	
}//ObjectFile
