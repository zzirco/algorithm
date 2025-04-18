package baekjoon;

import java.io.*;
import java.util.*;

public class Main_1941 {
    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};
    static int[] tmp = new int[7];
    static char[][] map = new char[5][5];
    static boolean[][] v = new boolean[5][5];
    static int ans = 0;
    static void seven(int start, int cnt, int yCnt) {
        if(yCnt>3) return;
        if(cnt==7) {
            v = new boolean[5][5];
            bfs(tmp[0]/5,tmp[0]%5);
            return;
        }
        for(int i=start; i<25; i++) {
            tmp[cnt] = i;
            if(map[i/5][i%5]=='Y') seven(i+1,cnt+1,yCnt+1);
            else seven(i+1,cnt+1,yCnt);
        }
    }
    static void bfs(int i, int j) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{i,j});
        v[i][j] = true;
        int cnt = 1;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            i = cur[0];
            j = cur[1];
            for(int d=0; d<4; d++) {
                int ni = i + di[d];
                int nj = j + dj[d];
                if(ni<0||ni>=5||nj<0||nj>=5||v[ni][nj]) continue;
                for(int k=0; k<7; k++) {
                    if(tmp[k]==ni*5+nj) {
                        q.offer(new int[]{ni,nj});
                        v[ni][nj] = true;
                        cnt++;
                    }
                }
            }
        }
        if(cnt==7) ans++;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i=0; i<5; i++) {
            String s = br.readLine();
            for(int j=0; j<5; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        seven(0,0,0);
        System.out.println(ans);
    }
}
