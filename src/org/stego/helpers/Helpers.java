package org.stego.helpers;

public class Helpers {
	
	public static void p(String str) {
		System.out.println(str);
	}
	public static void printArray(long[] array) {
		for (int i = 0; i < array.length; i++) {
			 p(i + " - " + array[i]);
		}
	}
	public static void printArray(boolean[] array) {
		String str = "";
		int k = 0;
		for (int i = 0; i < array.length; i++) {
			 str += array[i] ? "1" : "0";
			 if(k==5) {
				 str += " ";
				 k = 0;
			 }
			 else k++;
		}
		p(str);
	}
}
