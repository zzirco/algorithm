package boj;

import java.util.Scanner;

public class Solution_bj_1009_분산처리 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			long x = (long)Math.pow(a, b);
			sb.append(x%10+"\n");
		}
		System.out.println(sb);
		sc.close();
	}
}
