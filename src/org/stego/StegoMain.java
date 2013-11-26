package org.stego;


public class StegoMain {
	public static void main(String arg[]) {

//		String text = "¿¡¬";
//		String str = "‡øbssssasss‡ssss‡‡‡‡";
//		
//		boolean[] k2 = {true, true, true, false, false, false}; //111000
//		
//		Stego stego = new Stego();
//		String encryptedStr = stego.encryption(str, k2);
//		p(encryptedStr);
//		p(stego.decryption(encryptedStr));
		
		Encrypt encrypt = new Encrypt();
		CryptoText cryptoText = encrypt.encryption(new boolean[] {false, true, false, true, false, true, false, true, false, true, true, true, true, true, true,true, true, true, true, true});
		printArray(cryptoText.cryptoText);
		printArray(encrypt.decryption(cryptoText.cryptoText, cryptoText.randomKey));
		
//		primareGenerator();
		
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
