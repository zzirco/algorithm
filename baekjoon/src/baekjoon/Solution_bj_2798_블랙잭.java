package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_2798_블랙잭 {
	static int N, R=3;
	static int[] a, b=new int[R];
	static ArrayList<Integer> al = new ArrayList<>();
	
	private static void comb(int cnt, int start) {
		if (cnt == R) {
			int sum = 0;
			for(int i=0; i<b.length; i++) {
				sum += b[i];
			}
			al.add(sum);
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
		int M = Integer.parseInt(st.nextToken());
		a = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			a[i]=Integer.parseInt(st.nextToken());
		}
		comb(0,0);
		int abs = Integer.MAX_VALUE;
		int ans = 0;
		for(int i=0; i<al.size(); i++) {
			if(abs>Math.abs(M-al.get(i)) && M-al.get(i)>=0) {
				abs = Math.abs(M-al.get(i));
				ans = al.get(i);
			}
		}
		System.out.println(ans);
		br.close();
	}
}
