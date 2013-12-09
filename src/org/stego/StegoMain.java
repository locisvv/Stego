package org.stego;

import java.math.BigInteger;

import org.stego.helpers.Helpers;
import org.stego.models.CryptoText;


public class StegoMain {
	public static void main(String arg[]) {

//		String text = "���";
		String str = "����� ������� ������������ ���� ������ �� ����� ������� ������������ ���� ������ ��";
//		
//		boolean[] k2 = {true, true, true, false, false, false}; //111000

		Alfabet alfabet = new Alfabet();
		String text = "�����";
		boolean[] arrayBolean = alfabet.strToBits(text);
		Helpers.p(text);
		Helpers.printArray(arrayBolean);
		
		BigInteger p = GMAlgorithm.newPrimare(16);
		BigInteger q = GMAlgorithm.newPrimare(16);
		
		Encryption encrypt = new Encryption(p.multiply(q));
		CryptoText cryptoText = encrypt.encryption(arrayBolean);
		Helpers.printArray(cryptoText.cryptoText);
		
		Stego stego = new Stego();
		String encryptedStr = stego.encryption(str, cryptoText.cryptoText);
		Helpers.p(encryptedStr);
		boolean[] encArray = stego.decryption(encryptedStr, cryptoText.cryptoText.length);
		Helpers.printArray(encArray);
		
		Decryption d = new Decryption(p, q);
		boolean[] bits = d.decryption(encArray, cryptoText.lastX);
		Helpers.printArray(bits);
		Helpers.p(alfabet.bitsToStr(bits));
	}

}
