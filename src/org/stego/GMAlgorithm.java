package org.stego;

import java.math.BigInteger;
import java.util.Random;

import org.stego.helpers.Helpers;
import org.stego.models.CryptoText;

public class GMAlgorithm {
	private static final BigInteger TWO = BigInteger.valueOf(2L);
    private static final BigInteger FOUR = BigInteger.valueOf(4L);

	public static CryptoText encryptionOrDecryption(boolean[] text, BigInteger firstX, BigInteger n) {
		BigInteger random;
		boolean item;
		boolean[] cryptoText = text;
		
		for (int i = 0; i < cryptoText.length; i++) {
			random = firstX.multiply(firstX).remainder(n);
			firstX = random;
			item = random.remainder(TWO).toString().equals("1") ? true : false;
			
			cryptoText[i] ^= item;
		}
		return new CryptoText(cryptoText, firstX, n);
	}
	
	public static BigInteger newPrimare(int bitLength) {
		BigInteger primre = BigInteger.probablePrime(bitLength, new Random());
		boolean isModEqual = primre.remainder(FOUR).toString().equals("3");
		
		return isModEqual ? primre : newPrimare(bitLength);
	}
}