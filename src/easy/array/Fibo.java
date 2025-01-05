package easy.array;

import java.math.BigInteger;

public class Fibo {

    public static void main(String[] args) {
//        System.out.println(getNthFib(1));
//        System.out.println(getNthFib(2));
//        System.out.println(getNthFib(3));
//        System.out.println(getNthFib(4));
//        System.out.println(getNthFib(5));
//        System.out.println(getNthFib(6));
//        System.out.println(getNthFib(7));
        System.out.println(getNthFib(100));
    }

    public static BigInteger getNthFib(int n) {
        BigInteger ith = BigInteger.ZERO;
        BigInteger subsequent = BigInteger.ONE;
        if (n == 1) {
            return ith;
        } else if (n == 2) {
            return subsequent;
        } else {
            int iter = 0;
            BigInteger next = BigInteger.ZERO;
            while (iter < n - 2) {
                next = ith.add(subsequent);
                ith = subsequent;
                subsequent = next;
                iter++;
            }
            return next;
        }
    }
}
