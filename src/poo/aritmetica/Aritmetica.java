package poo.aritmetica;
import poo.razionali.Razionale;
class Aritmetica {
	public static void main (String [] args) {
		Razionale r1=new Razionale (2,3);
		Razionale r2=new Razionale (7,9);
		Razionale r3=new Razionale (4,8);
		Razionale r4=new Razionale (5,8);
		Razionale r5=r1.sub(r2.mul(r3.add(r4)));
		System.out.println(r1+"-"+r2+"*"+r3+"+"+r4+"="+r5);
	}
}