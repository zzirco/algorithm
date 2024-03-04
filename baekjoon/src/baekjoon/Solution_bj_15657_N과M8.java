package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_15657_N과M8 {
	static int N, M;
	static int[] a, b;
	static StringBuilder sb = new StringBuilder();
	static void comb(int cnt, int start) {
		if(cnt==M) {
			for(int i:b) {
				sb.append(i+" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=start; i<N; i++) {
			b[cnt] = a[i];
			comb(cnt+1,i);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		a = new int[N];
		b = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		comb(0,0);
		System.out.println(sb);
	}
}
