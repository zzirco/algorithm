package baekjoon;

import java.io.*;
import java.util.*;

public class Main_2151 {
    static int[] di = {-1,0,1,0};
    static int[] dj = {0,-1,0,1};
    static char[][] map;
    static boolean[][][] v;
    static int N;
    static int si, sj, ei, ej;
    static int ans = -1;

    static void bfs() {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[3]));
        for(int d=0; d<4; d++) {
            q.offer(new int[]{si,sj,d,0});
        }
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int i = cur[0];
            int j = cur[1];
            int dir = cur[2];
            int cnt = cur[3];
            v[i][j][dir] = true;
            if(i==ei&&j==ej) {
                ans = cnt;
                return;
            }
            int ni = i + di[dir];
            int nj = j + dj[dir];
            if(ni<0||ni>=N||nj<0||nj>=N||map[ni][nj]=='*'||v[ni][nj][dir]) continue;
            if(map[ni][nj]=='!') {
                int ndir = (dir+3)%4;
                q.offer(new int[]{ni,nj,ndir,cnt+1});
                ndir = (dir+1)%4;
                q.offer(new int[]{ni,nj,ndir,cnt+1});
            }
            q.offer(new int[]{ni,nj,dir,cnt});
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        v = new boolean[N][N][4];
        int cnt = 0;
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for(int j=0; j<N; j++) {
                map[i][j] = s.charAt(j);
                if(map[i][j]=='#') {
                    if(cnt==0) {
                        si = i;
                        sj = j;
                        cnt++;
                    } else {
                        ei = i;
                        ej = j;
                    }
                }
            }
        }
        bfs();
        System.out.println(ans);
    }
}
