package 모의역량테스트;

import java.io.*;
import java.util.*;

public class Solution_D9_4008_숫자만들기_서울_20반_신호준 {
	static int N;
	static int[] op, num;
	static int max, min;
	public static void dfs(int cur, int cnt) {
		if(cnt==N) {
			max = Math.max(max, cur);
			min = Math.min(min, cur);
		}
		for(int d=0; d<4; d++) {
			if(op[d]>0) {
				op[d]--;
				switch(d) {
					case 0: dfs(cur+num[cnt],cnt+1); break;
					case 1: dfs(cur-num[cnt],cnt+1); break;
					case 2: dfs(cur*num[cnt],cnt+1); break;
					case 3: dfs(cur/num[cnt],cnt+1); break;
				}
				op[d]++;
			}
		}
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d9_4008.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			op = new int[4];
			num = new int[N];
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<4; i++) {
				int operator = Integer.parseInt(st.nextToken());
				op[i] += operator;
			}
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<N; i++) {
				int number = Integer.parseInt(st.nextToken());
				num[i] = number;
			}
			dfs(num[0],1);
			sb.append("#"+tc+" "+(max-min)+"\n");
		}
		System.out.println(sb);
	}
}
