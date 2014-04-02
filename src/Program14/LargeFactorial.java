package Program14;

import java.math.BigInteger;

public class LargeFactorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("100! is \n" + factorial(100));
	}
	
	public static BigInteger factorial(long n) {
		BigInteger result = BigInteger.ONE;
		for(int i=1;i<=n;i++)
			result = result.multiply(new BigInteger(i + ""));
		
		return result;
	}

}
