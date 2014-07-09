/**
 * 
 */
package poo.appelli;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Paths;

/**
 * @author DeSimone_F
 *
 */
public class Test {

    
    public static void main(String[] args) throws Exception{
	
	Lista<NominativoS> lista = new ListaConcatenata<NominativoS>();
	BufferedReader br = new BufferedReader(new FileReader(new File(Paths.get("nominativi.txt").toAbsolutePath().toString())));
	String linea = "";
	
	while  ((linea=br.readLine())!=null){
	    System.out.println("letta la linea : "+linea);
	    // qui con uno string tokenizer leggi i pezzi della riga 
	    // crei un oggetto NominativoS  con quello che hai letto e lo aggiunti alla tua lista
	    // dopodicheè fai le tue prove
	}
    }
}
