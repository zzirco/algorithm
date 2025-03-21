package baekjoon;

import java.io.*;
import java.util.*;

public class Main_15650 {
	static int N, M;
	static int[] a, b;
	static boolean[] v;
	static void comb(int start, int cnt) {
		if(cnt==M) {
			for(int num:b) {
				System.out.print(num + " ");
			}
			System.out.println();
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
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		a = new int[N];
		b = new int[M];
		v = new boolean[N];
		for(int i=0; i<N; i++) {
			a[i] = i+1;
		}
		comb(0,0);
	}
}