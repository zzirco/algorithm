package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_bj_8393_합 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		for(int i=1; i<=N; i++) {
			sum += i;
		}
		System.out.println(sum);
		br.close();
	}
}
