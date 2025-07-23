package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_bj_1753_최단경로 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(br.readLine())-1;
		ArrayList<int[]>[] g = new ArrayList[V];
		boolean[] v = new boolean[V];
		int[] dist = new int[V];
		for(int i=0; i<V; i++) {
			g[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			g[from].add(new int[] {to,weight});
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1[1], o2[1]));
		dist[S] = 0;
		pq.offer(new int[] {S,dist[S]});
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int minVertex = cur[0];
			int min = cur[1];
			if(v[minVertex]) continue;
			v[minVertex] = true;
			for(int[] node:g[minVertex]) {
				if(!v[node[0]]&&dist[node[0]]>min+node[1]) {
					dist[node[0]]=min+node[1];
					pq.offer(new int[] {node[0],dist[node[0]]});
				}
			}
		}
		for(int d:dist) {
			if(d==Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(d);
		}
		br.close();
	}
}
