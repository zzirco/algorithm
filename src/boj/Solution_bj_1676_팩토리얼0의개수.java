package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_bj_1676_팩토리얼0의개수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		for(int i=1; i<=N; i++) {
			int tmp = i;
			while(tmp%5==0) {
				tmp/=5;
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
