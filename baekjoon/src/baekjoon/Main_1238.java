package baekjoon;

import java.io.*;
import java.util.*;

public class Main_1238 {
    static int N, M, X;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken()) - 1;
        int[][] g = new int[N][N];
        int[][] g2 = new int[N][N];
        boolean[] v = new boolean[N];
        boolean[] v2 = new boolean[N];
        int[] dist = new int[N];
        int[] dist2 = new int[N];
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());
            g[from][to] = weight;
            g2[to][from] = weight;
        }
        for(int i=0; i<N; i++) {
            dist[i] = Integer.MAX_VALUE;
            dist2[i] = Integer.MAX_VALUE;
        }
        dist = dijkstra(g, v, dist);
        dist2 = dijkstra(g2, v2, dist2);
        int[] cnt = new int[N];
        for(int i=0; i<N; i++) {
            cnt[i] = dist[i] + dist2[i];
        }
        Arrays.sort(cnt);
        System.out.println(cnt[N-1]);
        br.close();
    }
    public static int[] dijkstra(int[][] g, boolean[] v, int[] dist) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        dist[X] = 0;
        pq.offer(new int[] {X,dist[X]});
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int minVertex = cur[0];
            int min = cur[1];
            if(v[minVertex]) continue;
            v[minVertex] = true;
            for(int j=0; j<N; j++) {
                if(!v[j]&&g[minVertex][j]!=0&&dist[j]>min+g[minVertex][j]) {
                    dist[j]=min+g[minVertex][j];
                    pq.offer(new int[] {j,dist[j]});
                }
            }
        }
        return dist;
    }
}
