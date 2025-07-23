package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_bj_9372_상근이의여행 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] g = new int[N][N];
			boolean[] v = new boolean[N];
			int[] minEdge = new int[N];
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int from = Integer.parseInt(st.nextToken())-1;
				int to = Integer.parseInt(st.nextToken())-1;
				g[from][to] = g[to][from] = 1;
			}
			for(int i=0; i<N; i++) {
				minEdge[i] = Integer.MAX_VALUE;
			}
			int result = 0, cnt = 0;
			minEdge[0] = 0;
			for(int i=0; i<N; i++) {
				int minVertex = -1;
				int min = Integer.MAX_VALUE;
				for(int j=0; j<N; j++) {
					if(!v[j]&&min>minEdge[j]) {
						minVertex = j;
						min = minEdge[j];
					}
				}
				v[minVertex] = true;
				result += min;
				if(cnt++==N-1) break;
				for(int j=0; j<N; j++) {
					if(!v[j]&&g[minVertex][j]!=0&&minEdge[j]>g[minVertex][j]) {
						minEdge[j] = g[minVertex][j];
					}
				}
			}
			sb.append(result+"\n");
		}
		System.out.println(sb);
	}
}
