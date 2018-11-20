package algocourse;

import java.math.BigInteger;
import java.util.Random;

class Karatsuba {
    private final static BigInteger ZERO = new BigInteger("0");

    public static BigInteger karatsuba(BigInteger x, BigInteger y) {

        // cutoff to brute force
        int N = Math.max(x.bitLength(), y.bitLength());
        if (N <= 2000) return x.multiply(y);

        // optimize this parameter
        // number of bits divided by 2, rounded up
        N = (N / 2) + (N % 2);

        // x = a + 2^N b,   y = c + 2^N d
        BigInteger b = x.shiftRight(N);
        BigInteger a = x.subtract(b.shiftLeft(N));
        BigInteger d = y.shiftRight(N);
        BigInteger c = y.subtract(d.shiftLeft(N));

        // compute sub-expressions
        BigInteger ac    = karatsuba(a, c);
        BigInteger bd    = karatsuba(b, d);
        BigInteger abcd  = karatsuba(a.add(b), c.add(d));

        return ac.add(abcd.subtract(ac).subtract(bd).shiftLeft(N)).add(bd.shiftLeft(2*N));
    }


    public static void main(String[] args) {
        long start, stop;;
        start = System.currentTimeMillis();
        BigInteger c = karatsuba(new BigInteger("3141592653589793238462643383279502884197169399375105820974944592"), new BigInteger("2718281828459045235360287471352662497757247093699959574966967627"));
        stop = System.currentTimeMillis();
        System.out.println(stop - start);
        System.out.println(c);
    }
}

