package org.stego;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Stego {
	public HashMap<Character, Character> alfabet;
	public HashMap<Character, Character> alfabetInvert;
	
	public Stego(){
		alfabet = new HashMap<Character, Character>();
		alfabet.put('а', 'A');
		alfabet.put('в', 'B');
		alfabet.put('е', 'E');
		alfabet.put('і', 'I');
		alfabet.put('к', 'K');
		alfabet.put('м', 'M');
		alfabet.put('о', 'O');
		alfabet.put('р', 'P');
		alfabet.put('с', 'C');
		alfabet.put('т', 'T');
		alfabet.put('х', 'X');
		
		alfabetInvert = (HashMap<Character, Character>) invert(alfabet);
	}
	private <V, K> Map<V, K> invert(Map<K, V> map) {

	    Map<V, K> inv = new HashMap<V, K>();

	    for (Entry<K, V> entry : map.entrySet())
	        inv.put(entry.getValue(), entry.getKey());

	    return inv;
	}
	
	public String encryption(String str, boolean[] encrypted){
			
		String newStr = "";
		char[] arrayStr = str.toCharArray();
		
		int k = 0;
		for (int i = 0; i < arrayStr.length; i++) {
			char letter = arrayStr[i];
			
			char c = alfabet.get(letter) != null ?  alfabet.get(letter) : 0 ;	
			if (c != 0 && k < encrypted.length){
				newStr += encrypted[k] ? c : letter;
				k++;
			}
			else{
				newStr += letter; 
			}
		}
		
		return newStr;
	}
	public boolean[] decryption(String str, int length){
		boolean[] result = new boolean[length];
		
		char[] arrayStr = str.toCharArray();
		char charInver;
		char letter;
		
		int k = 0;
		for (int i = 0; i < arrayStr.length; i++) {
			if(k >= length){
				break;
			}
			
			letter = arrayStr[i];
			
			charInver = alfabetInvert.get(letter) != null ?  alfabetInvert.get(letter) : 0 ;
			if(charInver != 0){
				result[k] = true;
				k++;
			}
			else{
				charInver = alfabet.get(letter) != null ?  alfabet.get(letter) : 0 ;
				if(charInver != 0){
					result[k] = false;
					k++;
				}
			}
		}
		return result;
	}

	public static int bitToInteger(String str) {
		return Integer.parseInt(str, 2);
	}
}