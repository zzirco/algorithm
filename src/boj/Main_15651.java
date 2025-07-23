package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15651 {
	static int N, M;
	static int[] a, b;
	static StringBuilder sb = new StringBuilder();
	static void perm(int cnt) {
		if(cnt==M) {
			for(int num:b) {
				sb.append(num + " ");
			}
			sb.append("\n");
			return;
		}
		for(int i=0; i<N; i++) {
			b[cnt] = a[i];
			perm(cnt+1);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		a = new int[N];
		b = new int[M];
		for(int i=0; i<N; i++) {
			a[i] = i+1;
		}
		perm(0);
		System.out.println(sb);
	}
}