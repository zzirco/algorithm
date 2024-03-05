package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_15663_N과M9 {
	static int N, M;
	static int[] a, b;
	static boolean[] v;
	static LinkedHashSet<String> list = new LinkedHashSet<>();
	static StringBuilder sb = new StringBuilder();
	static void perm(int cnt) {
		if(cnt==M) {
			String s = "";
			for(int i:b) {
				s += i+" ";
			}
			list.add(s);
			return;
		}
		for(int i=0; i<N; i++) {
			if(v[i]) continue;
			v[i] = true;
			b[cnt] = a[i];
			perm(cnt+1);
			v[i] = false;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		a = new int[N];
		b = new int[M];
		v = new boolean[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		perm(0);
		for(String s:list) {
			System.out.println(s);
		}
		System.out.println(sb);
	}
}
