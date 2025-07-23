package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_bj_9205_맥주마시면서걸어가기 {
	static int N;
	static int[][] v;
	static int[][] g;
	public static int floyd() {
		for(int k=0; k<N+2; k++) {
			for(int i=0; i<N+2; i++) {
				for(int j=0; j<N+2; j++) {
					g[i][j] = Math.min(g[i][j], g[i][k]+g[k][j]);
				}
			}
		}
		return g[0][N+1];
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			v = new int[N+2][2];
			g = new int[N+2][N+2];
			for(int i=0; i<N+2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				v[i][0] = Integer.parseInt(st.nextToken());
				v[i][1] = Integer.parseInt(st.nextToken());
			}
			for(int i=0; i<N+2; i++) {
				for(int j=0; j<N+2; j++) {
					g[i][j] = g[j][i] = Short.MAX_VALUE;
				}
			}
			for(int i=0; i<N+2; i++) {
				for(int j=i+1; j<N+2; j++) {
					int d = Math.abs(v[i][0]-v[j][0])+Math.abs(v[i][1]-v[j][1]);
					if(d<=20*50) g[i][j] = g[j][i] = 1;
				}
			}
			String s = floyd()<Short.MAX_VALUE?"happy":"sad";
			sb.append(s+"\n");
		}
		System.out.println(sb);
	}
}
