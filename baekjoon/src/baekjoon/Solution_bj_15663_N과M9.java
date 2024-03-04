package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_15663_N과M9 {
	static int N, M;
	static int[] a, b;
	static LinkedHashSet<Integer> lhs;
	static StringBuilder sb = new StringBuilder();
	static void comb(int cnt, int start) {
		if(cnt==M) {
			lhs = new LinkedHashSet<>();
			for(int i:b) {
				lhs.add(i);
			}
			System.out.println("lhs:"+lhs);
			for(int i:lhs) {
				sb.append(i+" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=start; i<N; i++) {
			b[cnt] = a[i];
			comb(cnt+1,i+1);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		a = new int[N];
		b = new int[M];
		lhs = new LinkedHashSet<>();
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		comb(0,0);
		System.out.println(sb);
	}
}
