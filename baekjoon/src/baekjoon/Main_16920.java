package baekjoon;

import java.io.*;
import java.util.*;

public class Main_16920 {
    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};
    static int N, M, P;
    static int[] S;
    static ArrayDeque<int[]>[] q;
    static int[] area;
    static int[][] map;
    static boolean[][] v;

    static void bfs(ArrayDeque<int[]> q, int player) {
        int cnt = 0;
        for(int r=0; r<S[player]; r++) {
            int size = q.size();
            if(size==0) break;
            for(int c=0; c<size; c++) {
                int[] cur = q.poll();
                int i = cur[0];
                int j = cur[1];
                v[i][j] = true;
                for(int d=0; d<4; d++) {
                    int ni = i + di[d];
                    int nj = j + dj[d];
                    if(ni>=0&&ni<N&&nj>=0&&nj<M&&!v[ni][nj]&&map[ni][nj]==0) {
                        q.offer(new int[]{ni,nj});
                        map[ni][nj] = player + 1;
                        v[ni][nj] = true;
                        cnt++;
                    }
                }
            }
        }
        area[player] += cnt;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        v = new boolean[N][M];
        S = new int[P];
        q = new ArrayDeque[P];
        area = new int[P];
        for(int i=0; i<P; i++) {
            q[i] = new ArrayDeque<>();
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<P; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<N; i++) {
            String s = br.readLine();
            for(int j=0; j<M; j++) {
                char c = s.charAt(j);
                if(c=='.') map[i][j] = 0;
                else if(c=='#') map[i][j] = -1;
                else {
                    int n = c - '1';
                    map[i][j] = n + 1;
                    q[n].offer(new int[]{i,j});
                    area[n]++;
                }
            }
        }
        int index = 0;
        while(true) {
            boolean flag = false;
            for(int i=0; i<P; i++) {
                if(!q[i].isEmpty()) {
                    flag = true;
                    break;
                }
            }
            if(!flag) break;
            bfs(q[index],index);
            if(index==P-1) index = 0;
            else index++;
        }
        for(int i=0; i<P; i++) {
            System.out.print(area[i] + " ");
        }
    }
}
