package org.stego;

public class Encrypt {
	public static void main(String[] args) {

		p(extendedEuclid(19, 11) + " ");
		randomGenerator();
	}
	
	public static Euclidean extendedEuclid(int p, int q){
		p(p + " " + q);
		if(q == 0){
			return new Euclidean(p, 1, 0);
		}
		Euclidean e = extendedEuclid(q, p % q);
		return new Euclidean(e.d, e.y, e.x - (p/q*e.y));
	}

	
	public static void  randomGenerator(){
		long[] array = new long[20];
		int p = 11;
		int q = 19;
		int n = p * q;
		int x = 101;
		array[0] = (x * x) % n;
				
		for (int i = 1; i < array.length; i++) {
			array[i] = (array[i-1] * array[i-1]) % n;
		}
		
		printArray(array);
		
		int a = 7;
		int b = -4;
		int m = 13;

		double l = Math.pow(((p + 1) / 4), m) % (p -1);
		double k = Math.pow(((q + 1) / 4), m) % (q -1);
		
		double u = Math.pow(array[13] % p, l) % p;
		double v = Math.pow(array[13] % q, k) % q;
		double key = (a*p*v + b*q*u) % n;
		
		p(key + "");
	}
	public static void p(String str) {
		System.out.println(str);
	}
	
	public static void printArray(long[] array) {
		for (int i = 0; i < array.length; i++) {
			 p(i + " - " + array[i]);
		}
	}
}

class Euclidean{
	public int d;
	public int x;
	public int y;
	
	public Euclidean(int d, int x, int y) {
		this.d = d;
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Euclidean [d=" + d + ", x=" + x + ", y=" + y + "]";
	}
	
	
}
