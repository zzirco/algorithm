package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_15649_N과M2 {
	static int N, R;
	static int[] a, b;
	
	private static void comb(int cnt, int start) {
		if (cnt == R) {
			for(int i=0; i<b.length; i++) {
				System.out.print(b[i]+" "); 
			}
			System.out.println();
			return;
		}
		for (int i = start; i < N; i++) {
			b[cnt] = a[i];
			comb(cnt+1, i+1);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		a = new int[N];
		for(int i=0; i<N; i++) {
			a[i] = i+1;
		}
		b = new int[R];
		
		comb(0, 0);
	}
}
