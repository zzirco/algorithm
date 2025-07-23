package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_bj_2475_검증수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[] arr = new long[5];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<5; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		int sum = 0;
		for(int i=0; i<5; i++) {
			sum += arr[i]*arr[i];
		}
		System.out.println(sum%10);
		br.close();
	}
}
