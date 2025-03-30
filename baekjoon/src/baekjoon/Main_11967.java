package baekjoon;

import java.io.*;
import java.util.*;

public class Main_11967 {
    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};
    static int N, M;
    static int[][] map;
    static boolean[][] v;
    static ArrayList<Integer>[] list;

    static int bfs() {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0,0});
        v = new boolean[N][N];
        v[0][0] = true;
        map[0][0] = 1;
        int cnt = 0;
        boolean flag = false;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int i = cur[0];
            int j = cur[1];
            int index = i * N + j;
            int size = list[index].size();
            for(int k=0; k<size; k++) {
                int r = list[index].get(k)/N;
                int c = list[index].get(k)%N;
                if(map[r][c]!=1) {
                    map[r][c] = 1;
                    cnt++;
                    flag = true;
                }
            }
            for(int d=0; d<4; d++) {
                int ni = i + di[d];
                int nj = j + dj[d];
                if(ni<0||ni>=N||nj<0||nj>=N||v[ni][nj]) continue;
                if(map[ni][nj]==1) {
                    q.offer(new int[]{ni,nj});
                    v[ni][nj] = true;
                }
            }
            if(flag) return cnt + bfs();
        }
        return cnt;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        v = new boolean[N][N];
        list = new ArrayList[10000];
        for(int i=0; i<10000; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            list[x*N+y].add(a*N+b);
        }
        System.out.println(bfs()+1);
    }
}
