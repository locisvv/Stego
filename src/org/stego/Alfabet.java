package org.stego;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.stego.helpers.Helpers;

public class Alfabet {
	
	static char[] alfabet = {'�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�',
		    				   '�','�','�','�','�','�','�','�','�',    '�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�','�',    '�','�',	
		    				   ' ', '.'};
	
	static boolean[][] alfabetBool = {
		{false, false, false, false, false, false},
		{false, false, false, false, false, true},
		{false, false, false, false, true, false},
		{false, false, false, false, true, true},
		{false, false, false, true, false, false},
		{false, false, false, true, false, true},
		{false, false, false, true, true, false},
		{false, false, false, true, true, true},
		{false, false, true, false, false, false},
		{false, false, true, false, false, true},
		{false, false, true, false, true, false},
		{false, false, true, false, true, true},
		{false, false, true, true, false, false},
		{false, false, true, true, false, true},
		{false, false, true, true, true, false},
		{false, false, true, true, true, true},
		{false, true, false, false, false, false},
		{false, true, false, false, false, true},
		{false, true, false, false, true, false},
		{false, true, false, false, true, true},
		{false, true, false, true, false, false},
		{false, true, false, true, false, true},
		{false, true, false, true, true, false},
		{false, true, false, true, true, true},
		{false, true, true, false, false, false},
		{false, true, true, false, false, true},
		{false, true, true, false, true, false},
		{false, true, true, false, true, true},
		{false, true, true, true, false, false},
		{false, true, true, true, false, true},
		{false, true, true, true, true, false},
		{false, true, true, true, true, true},
		{true, false, false, false, false, false},
		{true, false, false, false, false, true},
		{true, false, false, false, true, false},
		{true, false, false, false, true, true},
		{true, false, false, true, false, false},
		{true, false, false, true, false, true},
		{true, false, false, true, true, false},
		{true, false, false, true, true, true},
		{true, false, true, false, false, false},
		{true, false, true, false, false, true},
		{true, false, true, false, true, false},
		{true, false, true, false, true, true},
		{true, false, true, true, false, false},
		{true, false, true, true, false, true},
		{true, false, true, true, true, false},
		{true, false, true, true, true, true},
		{true, true, false, false, false, false},
		{true, true, false, false, false, true},
		{true, true, false, false, true, false},
		{true, true, false, false, true, true},
		{true, true, false, true, false, false},
		{true, true, false, true, false, true},
		{true, true, false, true, true, false},
		{true, true, false, true, true, true},
		{true, true, true, false, false, false},
		{true, true, true, false, false, true},
		{true, true, true, false, true, false},
		{true, true, true, false, true, true},
		{true, true, true, true, false, false},
		{true, true, true, true, false, true},
		{true, true, true, true, true, false},
		{true, true, true, true, true, true}};
	
	
	public static HashMap<Character, Character> cryptoAlfabet;
	public static HashMap<Character, Character> cryptoAlfabetInvert;
	public static HashMap<Character, Integer> alfabetUA;
	
	public Alfabet(){
		initCryptoAlfabet();
		initAlfabetUA();
	}
	
	public static void initCryptoAlfabet(){
		cryptoAlfabet = new HashMap<Character, Character>();
		cryptoAlfabet.put('�', 'A');
		cryptoAlfabet.put('�', 'B');
		cryptoAlfabet.put('�', 'E');
		cryptoAlfabet.put('�', 'I');
		cryptoAlfabet.put('�', 'K');
		cryptoAlfabet.put('�', 'M');
		cryptoAlfabet.put('�', 'O');
		cryptoAlfabet.put('�', 'P');
		cryptoAlfabet.put('�', 'C');
		cryptoAlfabet.put('�', 'T');
		cryptoAlfabet.put('�', 'X');
		
		cryptoAlfabetInvert = (HashMap<Character, Character>) invert(cryptoAlfabet);
	}
	
	private static <V, K> Map<V, K> invert(Map<K, V> map) {
	    Map<V, K> inv = new HashMap<V, K>();

	    for (Entry<K, V> entry : map.entrySet())
	        inv.put(entry.getValue(), entry.getKey());

	    return inv;
	}
	
	public static void initAlfabetUA(){
		alfabetUA = new HashMap<Character, Integer>();
		for (int i = 0; i < alfabet.length; i++) {
			alfabetUA.put(alfabet[i], i);
		}
	}
	
	public static boolean[] strToBits(String str) {
		char[] letters = str.toCharArray();
		boolean[] bits = new boolean[str.length()*6];
		boolean[] b;
		int k = 0;
		int letterNumber;
		int incorrectLetter = 0;
		
		for (int i = 0; i < letters.length; i++) {
			letterNumber = getLetterNumber(letters[i]);
			
			if(letterNumber == -1){
				incorrectLetter++;
			}
			else{
				b = alfabetBool[letterNumber];
				System.arraycopy(b, 0, bits, k, 6);
				k += 6;
			}
		}
		
		boolean[] newBits = new boolean[bits.length - (incorrectLetter * 6)];
		System.arraycopy(bits, 0, newBits, 0, newBits.length);
		return newBits;
	}
	
	private static int getLetterNumber(char c) {
		Object n = alfabetUA.get(c);
		return n != null ? (int) n : -1;
	}
	
	public static String bitsToStr(boolean[] bits) {
		String str = "";
		String strBits = "";
		int countrt = 0;

		for (int i = 0; i < bits.length; i++) {
			strBits += bits[i] ? 1 : 0;

			if(countrt == 5){
				int bb = Integer.parseInt(strBits, 2);
				str += alfabet[bb];
				strBits = "";
				countrt = 0;
			}
			else{
				countrt++;
			}			
		}
		return str;
	}
	
	
	public static void main(String[] arg){
//		for(int i = 0; i < 64; i++){
//			int b = i;
//			String s = "";
//			while(true){
//				int k;
//				k = b % 2;
//				b /= 2;
//				s = (k == 1 ? "true, " : "false, ") + s;
//				if(b < 1){
//					break;
//				}
//			}
//			System.out.println("{" + s.substring(0, s.length()-2) + "},");
//		}

		initAlfabetUA();
	}
}
