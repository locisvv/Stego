package org.stego;

public class Alfabet {
	static boolean[][] alfabet = {
		{false},
		{true},
		{true, false},
		{true, true},
		{true, false, false},
		{true, false, true},
		{true, true, false},
		{true, true, true},
		{true, false, false, false},
		{true, false, false, true},
		{true, false, true, false},
		{true, false, true, true},
		{true, true, false, false},
		{true, true, false, true},
		{true, true, true, false},
		{true, true, true, true},
		{true, false, false, false, false},
		{true, false, false, false, true},
		{true, false, false, true, false},
		{true, false, false, true, true},
		{true, false, true, false, false},
		{true, false, true, false, true},
		{true, false, true, true, false},
		{true, false, true, true, true},
		{true, true, false, false, false},
		{true, true, false, false, true},
		{true, true, false, true, false},
		{true, true, false, true, true},
		{true, true, true, false, false},
		{true, true, true, false, true},
		{true, true, true, true, false},
		{true, true, true, true, true},
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
	
	public static void main(String[] arg){
		for(int i = 0; i < 64; i++){
			int b = i;
			String s = "";
			while(true){
				int k;
				k = b % 2;
				b /= 2;
				s = (k == 1 ? "true, " : "false, ") + s;
				if(b < 1){
					break;
				}
			}
			System.out.println("{" + s.substring(0, s.length()-2) + "},");
		}
	}
}
