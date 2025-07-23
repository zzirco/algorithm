package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_bj_1238_파티 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken()) - 1;
		int[][] g = new int[N][N];
		boolean[] v = new boolean[N];
		int[][] dist = new int[N][N];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			int weight = Integer.parseInt(st.nextToken());
			g[from][to] = weight;
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1[1], o2[1]));
		for(int k=0; k<N; k++) {
			dist[k][k] = 0;
			v = new boolean[N];
			pq.offer(new int[] {k,dist[k][k]});
			while(!pq.isEmpty()) {
				int[] cur = pq.poll();
				int minVertex = cur[0];
				int min = cur[1];
				if(v[minVertex]) continue;
				v[minVertex] = true;
//				if(minVertex==X) break;
				for(int j=0; j<N; j++) {
					if(!v[j]&&g[minVertex][j]!=0&&dist[k][j]>min+g[minVertex][j]) {
						dist[k][j]=min+g[minVertex][j];
						pq.offer(new int[] {j,dist[k][j]});
					}
				}
			}
		}
		int[] cnt = new int[N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				cnt[i] = dist[i][X] + dist[X][i];
			}
		}
		Arrays.sort(cnt);
		System.out.println(cnt[N-1]);
		br.close();
	}
}
