package org.stego;


public class StegoMain {
	public static void main(String arg[]) {

		String text = "¿¡¬";
		String str = "‡øbssssasss‡ssss‡‡‡‡";
		
		boolean[] k2 = {true, true, true, false, false, false}; //111000
		
		Stego stego = new Stego();
		String encryptedStr = stego.encrypt(str, k2);
		p(encryptedStr);
		p(stego.decode(encryptedStr));
		
	}
	public static void p(String str) {
		System.out.println(str);
	}
}
