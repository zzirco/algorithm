package baekjoon;

import java.io.*;
import java.util.*;

public class Main_15649 {
	static int N, M;
	static int[] a, b;
	static boolean[] v;
	static void perm(int cnt) {
		if(cnt==M) {
			for(int num:b) {
				System.out.print(num + " ");
			}
			System.out.println();
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		a = new int[N];
		b = new int[M];
		v = new boolean[N];
		for(int i=0; i<N; i++) {
			a[i] = i+1;
		}
		perm(0);
	}
}