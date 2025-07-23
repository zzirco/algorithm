package boj;

import java.util.*;

public class Solution_bj_11047_동전0 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		Integer[] coins = new Integer[N];
		for(int i=0; i<N; i++) {
			coins[i] = sc.nextInt();
		}
		Arrays.sort(coins,Collections.reverseOrder());
		int cnt = 0;
		for(int c:coins) {
			if(c>K) continue;
			cnt += K/c;
			K %= c;
		}
		System.out.println(cnt);
		sc.close();
	}
}
