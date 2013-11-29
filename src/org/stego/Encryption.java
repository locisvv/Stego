package org.stego;

import java.math.BigInteger;

import org.stego.models.CryptoText;

public class Encryption {
	private BigInteger n;
	
	private BigInteger x;
	
	public Encryption(BigInteger n) {
		this.n = n;
		x = newPrimareX();
	}
	
	//Генеруэться взємно просте число із n
	private BigInteger newPrimareX() {
		BigInteger primareX = GMAlgorithm.newPrimare(8);
		
		boolean isModEqual = n.remainder(primareX).toString().equals("0");
		
		return !isModEqual ? primareX : newPrimareX();
	}
	
	public CryptoText encryption(boolean[] text) {
		BigInteger firstX = x.multiply(x).remainder(n);
		return GMAlgorithm.encryptionOrDecryption(text, firstX, n);
	}
}