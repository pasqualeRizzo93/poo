package poo.appelli;

import java.util.*;
import java.io.*;

public class TestLista {
	public static void main(String[] args) {
		Lista<NominativoS> list; 
Scanner sc=new Scanner(System.in);
String comando=sc.next().toUpperCase();
switch(comando){
case "INP":list=new ListaConcatenata<NominativoS>(ripristina("nominativi.txt"));

}
	}

}
