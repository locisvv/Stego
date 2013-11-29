package org.stego;

import java.math.BigInteger;
import org.stego.models.Euclidean;

public class Decryption {
	
	private static final BigInteger ZERO = BigInteger.valueOf(0L);
	private static final BigInteger ONE = BigInteger.valueOf(1L);
    private static final BigInteger FOUR = BigInteger.valueOf(4L);
	
	private BigInteger p;
	private BigInteger q;
	private BigInteger n;
	
	public Decryption(BigInteger p, BigInteger q) {
		this.p = p;
		this.q = q;
		n = q.multiply(p);
	}
		
	public boolean[] decryption(boolean[] text, BigInteger randomKey) {
		BigInteger firstX = getX0(text.length, randomKey);
		return GMAlgorithm.encryptionOrDecryption(text, firstX, n).cryptoText;
	}
	
	//Знаходження х0 за останнім випадковим числом BBS генератора і його порядковий номер  
	private BigInteger getX0(int m, BigInteger randomKey) {
		Euclidean params = extendedEuclid(p, q);
		BigInteger a = params.x;
		BigInteger b = params.y;
		
		//Визначення лишків
		BigInteger l = p.add(ONE).divide(FOUR).pow(m).remainder(p.subtract(ONE));
		BigInteger k = q.add(ONE).divide(FOUR).pow(m).remainder(q.subtract(ONE));
		
		BigInteger u = randomKey.remainder(p).pow(Integer.parseInt(l.toString())).remainder(p);
		BigInteger v = randomKey.remainder(q).pow(Integer.parseInt(k.toString())).remainder(q);
		
		BigInteger mulA = a.multiply(p).multiply(v);
		BigInteger mulB = b.multiply(q).multiply(u);
		
		
		return mulA.add(mulB).remainder(n);
	}
	
	//Розширений евклідовий алгоритм для знаходження X і Y у рівнянні xp + yq = 1  
	private Euclidean extendedEuclid(BigInteger p2, BigInteger q2){
		if(q2.toString().equals("0")){
			return new Euclidean(p2, ONE, ZERO);
		}
		
		Euclidean e = extendedEuclid(q2, p2.remainder(q2));
		BigInteger p2q2 = p2.divide(q2).multiply(e.y);
		return new Euclidean(e.d, e.y, e.x.subtract(p2q2));
	}
}
