package org.stego;

import java.math.BigInteger;

public class Encrypt {
	public static int p = 11;
	public static int q = 19;
	public static int n = p * q;
	public static int x = 101;
	
	public static void main(String[] args) {
		CryptoText cryptoText = encryption(new boolean[] {false, true, true, true, true, true, true, true, true, true, true, true, true, true, true,true, true, true, true, true});
		printArray(cryptoText.cryptoText);
		printArray(decryption(cryptoText.cryptoText, cryptoText.randomKey));
	}
	
	public static CryptoText encryption(boolean[] text) {
		long firstX = (x * x) % n;
		return encryptionOrDecryption(text, firstX);
	}
	
	public static boolean[] decryption(boolean[] text, long randomKey) {
		long firstX = getX0(text.length, randomKey);
		return encryptionOrDecryption(text, firstX).cryptoText;
	}
	
	public static CryptoText encryptionOrDecryption(boolean[] text, long firstX) {
		long random;
		boolean item;
		boolean[] cryptoText = text;
		long previousItem = firstX;
		for (int i = 0; i < cryptoText.length; i++) {
			random = randomGenerator(previousItem);
			previousItem = random;
			item = (random % 2) == 1 ? true : false;
			cryptoText[i] ^= item;
		}
		
		return new CryptoText(cryptoText, previousItem);
	}
	
	public static long randomGenerator(long previousItem){
		return (previousItem * previousItem) % n;		
	}
	
	public static long getX0(int m, long mItem) {
		Euclidean params = extendedEuclid(p, q);
		int a = params.x;
		int b = params.y;
		
		double l = Math.pow(((p + 1) / 4), m) % (p -1);
		double k = Math.pow(((q + 1) / 4), m) % (q -1);
		
		double u = Math.pow(mItem % p, l) % p;
		double v = Math.pow(mItem % q, k) % q;
		
		return (long) (a*p*v + b*q*u) % n;
	}
	
	public static Euclidean extendedEuclid(int p, int q){
		if(q == 0){
			return new Euclidean(p, 1, 0);
		}
		Euclidean e = extendedEuclid(q, p % q);
		return new Euclidean(e.d, e.y, e.x - (p/q*e.y));
	}
	
	public static void p(String str) {
		System.out.println(str);
	}
	
	public static void printArray(long[] array) {
		for (int i = 0; i < array.length; i++) {
			 p(i + " - " + array[i]);
		}
	}
	public static void printArray(boolean[] array) {
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

class CryptoText{
	public boolean[] cryptoText;
	public long randomKey;
	
	public CryptoText(boolean[] cryptoText, long randomKey) {
		this.cryptoText = cryptoText;
		this.randomKey = randomKey;
	}

}
