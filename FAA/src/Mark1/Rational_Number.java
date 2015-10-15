package Mark1;
/**
 * 
 * @author Benson Xu
 * Build a thread safe ration number class
 *
 */
public class Rational_Number {
	int numer;
	int denom;

	public static void main(String[] args) {
		Rational_Number a = new Rational_Number(1, 4);
		Rational_Number b = new Rational_Number(1, 4);
		Rational_Number c = new Rational_Number(1, 100);
		a.add(b);
		a.mult(b);
		a.div(c);
		a.sub(c);
	}
	
	public Rational_Number(int a, int b){
		setNumer(a);
		try{
			setDenom(b);
		}

		catch(IllegalArgumentException e){
			e.printStackTrace();
		}
	}
	
	public synchronized int getNumer(){
		return this.numer;
	}
	
	public synchronized int getDenom(){
		return this.denom;
	}
	
	public synchronized void setNumer(int a){
		this.numer = a;
	}
	
	public synchronized void setDenom(int b) throws IllegalArgumentException{
		if (b == 0) {
	        throw new IllegalArgumentException("Denominator is Zero.");
	    }
		this.denom = b;
	}
	
	
	public void add(Rational_Number a){
		int tempa = this.numer;
		int tempb = this.denom;
		
		int tempc = a.numer;
		int tempd = a.denom;
		
		String output = this.toString() + " + " + a.toString() + " = ";
		
		if(tempb == tempd){
			setNumer(tempa + tempc);
		}
		
		else{
			int bigdenom = tempb * tempd;
			tempa = tempa * tempd;
			tempb = tempb * tempc;
			setNumer(tempa + tempc);
			setDenom(bigdenom);
		}
		
		reduce();
		
		output += this.toString();
		System.out.println(output);
	}
	public void sub(Rational_Number a){
		int tempa = this.numer;
		int tempb = this.denom;
		
		int tempc = a.numer;
		int tempd = a.denom;
		
		String output = this.toString() + " - " + a.toString() + " = ";
		
		if(tempb == tempd){
			setNumer(tempa - tempc);
		}
		
		else{
			int bigdenom = tempb * tempd;
			tempa = tempa * tempd;
			tempb = tempb * tempc;
			setNumer(tempa - tempc);
			setDenom(bigdenom);
		}
		
		reduce();

		output += this.toString();
		System.out.println(output);
	}
	
	public void mult(Rational_Number a){
		int tempa = this.numer;
		int tempb = this.denom;
		
		int tempc = a.numer;
		int tempd = a.denom;
		
		String output = this.toString() + " * " + a.toString() + " = ";
		
		setNumer(tempa * tempc);
		setDenom(tempb * tempd);
		
		reduce();
		
		output += this.toString();
		System.out.println(output);
	}
	
	public void div(Rational_Number a){
		int tempa = this.numer;
		int tempb = this.denom;
		
		int tempc = a.numer;
		int tempd = a.denom;
		
		String output = this.toString() + " / " + a.toString() + " = ";
		
		setNumer(tempa * tempd);
		setDenom(tempb * tempc);
		
		reduce();
		
		output += this.toString();
		System.out.println(output);
	}
	
	private void reduce(){
		int gcd = gcd(getNumer(), getDenom());

		
		setNumer(getNumer() / gcd);
		setDenom(getDenom() / gcd);
	}
	
	private int gcd(int a, int b)
	{
	  if(a == 0 || b == 0) return a+b; // base case
	  return gcd(b,a%b);
	}
	
	
	public String toString(){
		return getNumer() + "/" + getDenom();
	}
}
