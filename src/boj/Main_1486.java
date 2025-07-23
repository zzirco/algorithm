package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1486 {
    static int[] di = {-1,0,1,0};
    static int[] dj = {0,-1,0,1};
    static int N, M, T, D;
    static int[][] map;
    static boolean[][] v;



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        v = new boolean[N][M];
        int[][] dist = new int[N][M];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for(int j=0; j<M; j++) {
                map[i][j] = s.charAt(j);
                if(map[i][j]>=97) map[i][j] -= 71;
                else map[i][j] -= 65;
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o->o[2]));
        dist[0][0] = 0;
        pq.offer(new int[]{0,0,dist[0][0]});
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int i = cur[0];
            int j = cur[1];
            int min = cur[2];
            if(v[i][j]) continue;
            v[i][j] = true;
            for(int r=0; r<N; r++) {
                for(int c=0; c<M; c++) {
                }
            }
        }
        System.out.println(Arrays.deepToString(map));
    }
}
