package baekjoon;

import java.io.*;
import java.util.*;

public class Main_4179 {
  static int[] di = {-1,1,0,0};
  static int[] dj = {0,0,-1,1};
  static int R, C;
  static int[][] map;
  static boolean[][] v_jihun;
  static boolean[][] v_fire;
  static ArrayDeque<int[]> jihun = new ArrayDeque<>();
  static ArrayDeque<int[]> fire = new ArrayDeque<>();
  static int min = Integer.MAX_VALUE;

  static void bfs_jihun() {
    while(!jihun.isEmpty()) {
      int[] cur = jihun.poll();
      int i = cur[0];
      int j = cur[1];
      int cnt = cur[2];
      if(i==0||i==R-1||j==0||j==C-1) {
        min = Math.min(min, cnt);
      }
      for(int d=0; d<4; d++) {
        int ni = i + di[d];
        int nj = j + dj[d];
        if(ni>=0&&ni<R&&nj>=0&&nj<C&&!v_jihun[ni][nj]&&map[ni][nj]!=-2) {
          if(map[ni][nj]<=cnt+1) continue;
          v_jihun[ni][nj] = true;
          jihun.offer(new int[]{ni,nj,cnt+1});
        }
      }
    }
  }

  static void bfs_fire() {
    while(!fire.isEmpty()) {
      int[] cur = fire.poll();
      int i = cur[0];
      int j = cur[1];
      int cnt = cur[2];
      for(int d=0; d<4; d++) {
        int ni = i + di[d];
        int nj = j + dj[d];
        if(ni>=0&&ni<R&&nj>=0&&nj<C&&!v_fire[ni][nj]&&map[ni][nj]!=-2) {
          v_fire[ni][nj] = true;
          map[ni][nj] = cnt + 1;
          fire.offer(new int[]{ni,nj,cnt+1});
        }
      }
    }
  }
  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    map = new int[R][C];
    v_jihun = new boolean[R][C];
    v_fire = new boolean[R][C];
    for(int i=0; i<R; i++) {
      String s = br.readLine();
      for(int j=0; j<C; j++) {
        char c = s.charAt(j);
        if(c=='J') {
          jihun.offer(new int[]{i,j,0});
          v_jihun[i][j] = true;
          map[i][j] = Integer.MAX_VALUE;
        }
        else if(c=='F') {
          fire.offer(new int[]{i,j,0});
          v_fire[i][j] = true;
          map[i][j] = 0;
        }
        else if(c=='#') map[i][j] = -2;
        else map[i][j] = Integer.MAX_VALUE;
      }
    }
    bfs_fire();
    bfs_jihun();
    System.out.println(min!=Integer.MAX_VALUE?min+1:"IMPOSSIBLE");
  }
}