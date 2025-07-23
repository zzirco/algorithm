package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15657 {
	static int N, M;
	static int[] a, b;
	static StringBuilder sb = new StringBuilder();
	static void comb(int start, int cnt) {
		if(cnt==M) {
			for(int num:b) {
				sb.append(num + " ");
			}
			sb.append("\n");
			return;
		}
		for(int i=start; i<N; i++) {
			b[cnt] = a[i];
			comb(i,cnt+1);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		a = new int[N];
		b = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		comb(0,0);
		System.out.println(sb);
	}
}