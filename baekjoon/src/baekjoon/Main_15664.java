package baekjoon;

import java.io.*;
import java.util.*;

public class Main_15664 {
	static int N, M;
	static int[] a, b;
	static boolean[] v;
	static LinkedHashSet<String> set = new LinkedHashSet<>();
	static void comb(int start, int cnt) {
		if(cnt==M) {
			String s = "";
			for(int num:b) {
				s += num + " ";
			}
			set.add(s);
			return;
		}
		for(int i=start; i<N; i++) {
			b[cnt] = a[i];
			comb(i+1,cnt+1);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		a = new int[N];
		b = new int[M];
		v = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		comb(0,0);
		for(String s:set) {
			sb.append(s + "\n");
		}
		System.out.println(sb);
	}
}