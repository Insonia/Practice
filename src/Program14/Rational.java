package Program14;

import java.lang.Thread.State;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.omg.CORBA.PUBLIC_MEMBER;

public class Rational extends Number implements Comparable{
	private long numerator = 0;
	private long denomimator = 1;
	
	public Rational(){
		this(0,1);
	}
	
	public Rational(long numerator,long denominator){
		long gcd = gcd(numerator, denominator);
		this.numerator = ((denominator>0?1:-1))*numerator / gcd;
		this.denomimator = Math.abs(denominator) / gcd;
	}
	
	private static long gcd(long n, long d){
		long n1 = Math.abs(n);
		long n2 = Math.abs(d);
		int gcd = 1;
		
		for(int k=1;k<=n1 && k<=n2;k++){
			if(n1%k==0 && n2%k == 0)
				gcd = k;
		}
		
		return gcd;
	}
	
	public long getNumerator() {
		return numerator;
	}
	
	public long getDenominator() {
		return denomimator;
	}
	
	public Rational add(Rational secondRational) {
		long n = numerator*secondRational.getDenominator() + denomimator * secondRational.getNumerator();
		long d = denomimator * secondRational.getDenominator();
		return new Rational(n,d);
	}
	
	public Rational subtract(Rational secondRational) {
		long n = numerator * secondRational.getDenominator() - denomimator * secondRational.getNumerator();
		long d = denomimator * secondRational.getDenominator();
		return new Rational(n,d);
	}
	
	public Rational multipy(Rational secondRational) {
		long n = numerator * secondRational.getNumerator();
		long d = denomimator * secondRational.getDenominator();
		return new Rational(n,d);
	}
	
	public Rational divide(Rational secondRational) {
		long n = numerator * secondRational.getDenominator();
		long d = denomimator * secondRational.getNumerator();
		return new Rational(n,d);
	}
	
	public String toString() {
		if(denomimator == 1)
			return numerator + "";
		else
			return numerator + "/" + denomimator;
	}
	
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		if((this.subtract((Rational)o)).getNumerator() > 0)
			return 1;
		else if(this.subtract((Rational)o).getNumerator() < 0)
			return -1;
		else
			return 0;
		
	}
	@Override
	public int intValue() {
		// TODO Auto-generated method stub
		return (int)doubleValue();
	}
	@Override
	public long longValue() {
		// TODO Auto-generated method stub
		return (long)doubleValue();
	}
	@Override
	public float floatValue() {
		// TODO Auto-generated method stub
		return (float)floatValue();
	}
	@Override
	public double doubleValue() {
		// TODO Auto-generated method stub
		return numerator *1.0 / denomimator;
	}
}
