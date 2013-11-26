package org.stego;

import java.math.BigInteger;
import java.util.Random;

public class Encrypt {
	private BigInteger p;
	private BigInteger q;
	public BigInteger n;
	
	private BigInteger x;
	
	public Encrypt() {
		p = newPrimare(16);
		q = newPrimare(16);
		n = p.multiply(q);
		x = newPrimareX();  
		
		p(x.toString() + "x1");
	}
	
	private BigInteger newPrimareX() {
		BigInteger primareX = newPrimare(8);
		p(primareX.toString());
		boolean isModEqual = n.remainder(primareX).toString().equals("0");
		
		return !isModEqual ? primareX : newPrimareX();
	}
	
	private BigInteger newPrimare(int bitLength) {
		BigInteger primre = BigInteger.probablePrime(bitLength, new Random());
		boolean isModEqual = primre.remainder(new BigInteger("4")).toString().equals("3");
		
		return isModEqual ? primre : newPrimare(bitLength);
	}
	
	public CryptoText encryption(boolean[] text) {
		BigInteger firstX = x.multiply(x).remainder(n);
		p("firstX" + firstX.toString());
		return encryptionOrDecryption(text, firstX);
	}
	
	public boolean[] decryption(boolean[] text, BigInteger randomKey) {
		BigInteger firstX = getX0(text.length, randomKey);
		p("firstX" + firstX.toString());
		return encryptionOrDecryption(text, firstX).cryptoText;
	}
	
	private CryptoText encryptionOrDecryption(boolean[] text, BigInteger firstX) {
		BigInteger random;
		boolean item;
		
		boolean[] cryptoText = text;
		BigInteger previousItem = firstX;
		
		for (int i = 0; i < cryptoText.length; i++) {
			random = randomGenerator(previousItem);
			previousItem = random;
			
			item = random.mod(new BigInteger("2")).equals("1") ? true : false;
			p(true + "");
			cryptoText[i] ^= item;
		}
		
		return new CryptoText(cryptoText, previousItem);
	}
	
	//BBS - генератор випадкових чисел 
	private BigInteger randomGenerator(BigInteger previousItem){
		return previousItem.multiply(previousItem).remainder(n);		
	}
	
	private BigInteger getX0(int m, BigInteger randomKey) {
		Euclidean params = extendedEuclid(p, q);
		BigInteger a = params.x;
		BigInteger b = params.y;
		
		BigInteger one = new BigInteger("1");
		BigInteger four = new BigInteger("4");
		
		BigInteger l = p.add(one).divide(four).pow(m).remainder(p.subtract(one));
		BigInteger k = q.add(one).divide(four).pow(m).remainder(q.subtract(one));
		
		p("a " + a.toString());
		p("b " + b.toString());
		p("l " + l.toString());
		p("k " + l.toString());
		
		BigInteger u = randomKey.remainder(p).pow(Integer.parseInt(l.toString())).remainder(p);
		BigInteger v = randomKey.remainder(q).pow(Integer.parseInt(k.toString())).remainder(q);
		
		BigInteger mulA = a.multiply(p).multiply(v);
		BigInteger mulB = b.multiply(q).multiply(u);
		return mulA.add(mulB).remainder(n);
	}
	
	private Euclidean extendedEuclid(BigInteger p2, BigInteger q2){
		if(q2.toString().equals("0")){
			return new Euclidean(p2, new BigInteger("1"), new BigInteger("0"));
		}
		Euclidean e = extendedEuclid(q2, p2.remainder(q2));
		BigInteger p2q2 = p2.divide(q2).multiply(e.y);
		return new Euclidean(e.d, e.y, e.x.subtract(p2q2));
	}
	
	public static void p(String str) {
		System.out.println(str);
	}
}

class Euclidean{
	public BigInteger d;
	public BigInteger x;
	public BigInteger y;
	
	public Euclidean(BigInteger d, BigInteger x, BigInteger y) {
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
	public BigInteger randomKey;
	
	public CryptoText(boolean[] cryptoText, BigInteger previousItem) {
		this.cryptoText = cryptoText;
		this.randomKey = previousItem;
	}

}
