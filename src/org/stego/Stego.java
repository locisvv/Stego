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
	
	public String encrypt(String str, boolean[] encrypted){
			
		String newStr = "";
		char[] arrayStr = str.toCharArray();
		
		int k = 0;
		for (int i = 0; i < arrayStr.length; i++) {
			char letter = arrayStr[i];

			char c = alfabet.get(letter) != null ?  alfabet.get(letter) : 0 ;	
			if (c != 0){
				newStr += encrypted[k] ? c : letter; 
				k = k == 5 ? 0 : ++k;
			}
			else{
				newStr += letter; 
			}
		}
		
		return newStr;
	}
	public String decode(String str){
		String result = "";
		char[] arrayStr = str.toCharArray();
		char charInver;
		char letter;
		for (int i = 0; i < arrayStr.length; i++) {
			letter = arrayStr[i];
			charInver = alfabetInvert.get(letter) != null ?  alfabetInvert.get(letter) : 0 ;
			if(charInver != 0){
				result += "1";
			}
			else{
				charInver = alfabet.get(letter) != null ?  alfabet.get(letter) : 0 ;
				if(charInver != 0){
					result += "0";
				}
			}
		}
		return result;
	}

	public static int bitToInteger(String str) {
		return Integer.parseInt(str, 2);
	}
}

















//__
//0,138
//i
//0,044
//д
//0,027
//г
//0,013
//ж
//0,007
//о
//0,086
//р
//0,043
//л
//0,027
//ч
//0,011
//ю
//0,008
//н
//0,068
//е
//0,042
//п
//0,025
//х
//0,011
//є
//0,005
//а
//0,064
//с
//0,037
//з
//0,020
//ї
//0,010
//щ
//0,004
//и
//0,055
//к
//0,033
//я
//0,019
//ц
//0,010
//ф
//0,003
//в
//0,046
//м
//0,029
//ь
//0,016
//ш
//0,005
//ґ
//0,000
//т
//0,045
//у
//0,027
//б
//0,013
//й
//0,009 