package org.stego.models;

import java.math.BigInteger;

public class CryptoText{
	public boolean[] cryptoText;
	public BigInteger lastX;
	
	public CryptoText(boolean[] cryptoText, BigInteger lastX, BigInteger n) {
		this.cryptoText = cryptoText;
		this.lastX = lastX;
	}
}
