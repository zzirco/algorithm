package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_3040_백설공주와일곱난쟁이 {
	static int N=9,R=7;
	static int[] a=new int[9], b=new int[7];
	static int[] ans = new int[7];
	static void comb(int cnt, int start) {
		if(cnt==R) {
			int sum = 0;
			for(int item:b) {
				sum += item;
			}
			if(sum==100) {
				ans = b.clone();
			}
			return;
		}
		for(int i=start; i<N; i++) {
			b[cnt] = a[i];
			comb(cnt+1, i+1);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<9; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		comb(0,0);
		for(int i=0; i<7; i++) {
			sb.append(ans[i]+"\n");
		}
		System.out.println(sb);
	}
}
