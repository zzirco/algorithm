package baekjoon;

import java.math.BigInteger;
import java.util.*;

public class Solution_bj_2338_긴자리계산 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger A = sc.nextBigInteger();
		BigInteger B = sc.nextBigInteger();
		System.out.println(A.add(B));
		System.out.println(A.add(B.negate()));
		System.out.println(A.multiply(B));
		sc.close();
	}
}
