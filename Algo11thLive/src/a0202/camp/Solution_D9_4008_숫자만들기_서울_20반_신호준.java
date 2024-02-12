package a0202.camp;

import java.io.*;
import java.util.*;

public class Solution_D9_4008_숫자만들기_서울_20반_신호준 {
	public static int N;
	public static int[] number;
	public static int[] operator;
	public static int MAX;
	public static int MIN;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			number = new int[N];
			operator = new int[4];
			MAX = Integer.MIN_VALUE;
			MIN = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 4; i++) {
				operator[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				number[i] = Integer.parseInt(st.nextToken());
			}
			dfs(number[0], 1);
			sb.append("#"+tc+" "+(MAX-MIN)+"\n");
		}
		System.out.println(sb);
	}
	public static void dfs(int num, int idx) {
		if (idx == N) {
			MAX = Math.max(MAX, num);
			MIN = Math.min(MIN, num);
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (operator[i] > 0) {
				operator[i]--;
				switch (i) {
				case 0:	dfs(num + number[idx], idx + 1);	break;
				case 1:	dfs(num - number[idx], idx + 1);	break;
				case 2:	dfs(num * number[idx], idx + 1);	break;
				case 3:	dfs(num / number[idx], idx + 1);	break;
				}
				operator[i]++;
			}
		}
	}
}
