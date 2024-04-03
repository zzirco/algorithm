package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_2042_구간합구하기 {
	static int N, M, K;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	public static void change(int b, int c) {
		arr[b] = c;
	}
	public static void sum(int b, int c) {
		int sum = 0;
		for(int i=b; i<=c; i++) {
			sum += arr[i];
		}
		sb.append(sum+"\n");
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for(int i=0; i<M+K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(a==1) change(b-1,c);
			else sum(b-1,c-1);
		}
		System.out.println(sb);
	}
}
