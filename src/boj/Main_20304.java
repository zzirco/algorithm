package boj;

import java.io.*;
import java.util.*;

public class Main_20304 {
    static int N, M;
    static int[] di = {2,-1,1};
    static int[] map;
    static boolean[] v;
    static ArrayDeque<int[]> q = new ArrayDeque<>();;

    static void bfs(int i, int cnt) {
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            i = cur[0];
            cnt = cur[1];
            for(int d=0; d<3; d++) {
                int ni = d==0?i*di[d]:i+di[d];
                if(ni>=0&&ni<=N&&!v[ni]) {
                    q.offer(new int[]{ni,cnt+1});
                    v[ni] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        map = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            int num = Integer.parseInt(st.nextToken());
            q.offer(new int[]{num,0});
            v[num] = true;
        }
    }
}
