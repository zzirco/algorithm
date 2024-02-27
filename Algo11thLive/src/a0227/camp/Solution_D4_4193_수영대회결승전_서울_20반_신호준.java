package a0227.camp;

import java.io.*;
import java.util.*;

public class Solution_D4_4193_수영대회결승전_서울_20반_신호준 {
	static final int[] di = {-1,1,0,0};
	static final int[] dj = {0,0,-1,1};
	static int N;
	static int[][] arr;
	static boolean[][] v;
	static int time;
	static int bfs(int[] start, int[] end) {
		int i = start[0];
		int j = start[1];
		int cnt = 0;
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i,j,cnt});
		v[i][j] = true;
		while(!q.isEmpty()) {
			int[] ij = q.poll();
			i = ij[0];
			j = ij[1];
			cnt = ij[2];
			for(int d=0; d<4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if(ni>=0&&ni<N&&nj>=0&&nj<N&&!v[ni][nj]&&arr[ni][nj]!=1) {
					if(ni==end[0]&&nj==end[1]) {
						time = cnt+1;
						return time;
					}
					if(arr[ni][nj]==2) {
						if(cnt%3==2) {
							v[ni][nj] = true;
							q.offer(new int[] {ni,nj,cnt+1});
							continue;
						} else {
							v[i][j] = true;
							q.offer(new int[] {i,j,cnt+1});
							continue;
						}
					}
					v[ni][nj] = true;
					q.offer(new int[] {ni,nj,cnt+1});
				}
			}
		}
		time = -1;
		return time;
	}
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("res/input_d4_4193.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc=1; tc<=T; tc++) {
        	N = Integer.parseInt(br.readLine());
        	arr = new int[N][N];
        	v = new boolean[N][N];
        	time = Integer.MAX_VALUE;
        	for(int i=0; i<N; i++) {
        		st = new StringTokenizer(br.readLine(), " ");
        		for(int j=0; j<N; j++) {
        			arr[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	int[] start = new int[2];
        	int[] end = new int[2];
        	st = new StringTokenizer(br.readLine(), " ");
        	start[0] = Integer.parseInt(st.nextToken());
        	start[1] = Integer.parseInt(st.nextToken());
        	st = new StringTokenizer(br.readLine(), " ");
        	end[0] = Integer.parseInt(st.nextToken());
        	end[1] = Integer.parseInt(st.nextToken());
        	sb.append("#"+tc+" ");
        	sb.append(bfs(start, end));
        	sb.append("\n");
        }
        System.out.println(sb);
    }
}
