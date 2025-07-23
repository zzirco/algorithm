package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_bj_15649_N과M1 {
	private static void perm(int N, int R, int C, int cnt, int[] a, int[] b, boolean[] v) {
		if (cnt == R) {
			for(int i=0; i<b.length; i++) {
				System.out.print(b[i]+" "); 
			}
			System.out.println();
			C++;
			return;
		}
		for (int i = 0; i < N; i++) {
			if (v[i]) continue; //
			v[i] = true;//
			b[cnt] = a[i];
			perm(N, R, C, cnt+1, a, b, v);
			v[i] = false;//
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int C = 0;
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = i+1;
		}
		int[] b = new int[R];
		boolean[] v = new boolean[N];
		
		C = 0;
		perm(N, R, C, 0, arr, b, v);
	}

}
