package org.stego;

import java.math.BigInteger;

import org.stego.helpers.Helpers;
import org.stego.models.CryptoText;


public class StegoMain {
	public static void main(String arg[]) {
//
//		String text = "¿¡¬";
//		String str = "‡øbssssasss‡ssss‡‡‡‡";
//		
//		boolean[] k2 = {true, true, true, false, false, false}; //111000
//		
//		Stego stego = new Stego();
//		String encryptedStr = stego.encryption(str, k2);
//		p(encryptedStr);
//		p(stego.decryption(encryptedStr));
		
		boolean[] arrayBolean =  {true, true, true, false, false, false}; //111000
		
		Helpers.printArray(arrayBolean);
		
		BigInteger p = GMAlgorithm.newPrimare(16);
		BigInteger q = GMAlgorithm.newPrimare(16);
		
		Encryption encrypt = new Encryption(p.multiply(q));
		CryptoText cryptoText = encrypt.encryption(arrayBolean);
		Helpers.printArray(cryptoText.cryptoText);
		
		Decryption d = new Decryption(p, q);
		Helpers.printArray(d.decryption(cryptoText.cryptoText, cryptoText.lastX));
				
	}
}
