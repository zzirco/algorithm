package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_15663_N과M9 {
	static int N, M;
	static HashSet<Integer> arr;
	static TreeSet<Integer> a;
	static int[] b;
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
			b[cnt] = a.;
			comb(cnt+1,i);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new HashSet<>();
		b = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr.add(Integer.parseInt(st.nextToken()));
		}
		TreeSet<Integer> a = new TreeSet<>();
		a.addAll(arr);
		comb(0,0);
		System.out.println(sb);
	}
}
