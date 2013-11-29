package org.stego.models;

import java.math.BigInteger;

public class Euclidean{
	public BigInteger d;
	public BigInteger x;
	public BigInteger y;
	
	public Euclidean(BigInteger d, BigInteger x, BigInteger y) {
		this.d = d;
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Euclidean [d=" + d + ", x=" + x + ", y=" + y + "]";
	}	
}