package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_15649_N과M3 {
	static int N, R;
	static int[] a, b;
	static StringBuilder sb = new StringBuilder();
	private static void perm(int cnt) {
		if (cnt == R) {
			for(int i=0; i<b.length; i++) {
				sb.append(b[i]+" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			b[cnt] = a[i];
			perm(cnt+1);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		a = new int[N];
		b = new int[R];
		for(int i=0; i<N; i++) {
			a[i] = i+1;
		}
		perm(0);
		System.out.println(sb);
	}
}