package baekjoon;

import java.util.*;

public class Solution_bj_1330_두수비교하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double A = sc.nextDouble();
		double B = sc.nextDouble();
		if(A>B) System.out.println(">");
		else if(A<B) System.out.println("<");
		else System.out.println("==");
		sc.close();
	}
}
