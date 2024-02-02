package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_11659_구간합구하기4 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N+1];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=1; i<N+1; i++) {
			arr[i] = arr[i-1]+Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int sum = arr[end]-arr[start-1];
			sb.append(sum+"\n");
		}
		System.out.println(sb);
		br.close();
	}
}
