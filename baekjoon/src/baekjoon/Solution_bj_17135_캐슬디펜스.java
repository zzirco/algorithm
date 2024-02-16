package baekjoon;

import java.io.*;
import java.util.*;
 
public class Solution_bj_17135_캐슬디펜스 {
	static int N, M, D;
	static int[][] map;
	static int[][] mapCopy;
	static boolean[][] v;
	static int ans = 0;
	static int cntEnemy = 0;
	static int[] di = {0,0,-1,1};
	static int[] dj = {-1,1,0,0};
	static int[][] ach = new int[3][2];
	static int[] a, b;
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	D = Integer.parseInt(st.nextToken());
    	map = new int[N+1][M];
    	mapCopy = new int[N+1][M];
    	v = new boolean[N+1][M];
    	a = new int[M];
    	b = new int[3];
    	for(int i=0; i<N; i++) {
    		st = new StringTokenizer(br.readLine(), " ");
    		for(int j=0; j<M; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	for(int j=0; j<M; j++) {
			a[j] = j;
		}
    	comb(0,0);
        System.out.println(ans);
        br.close();
    }
	static void comb(int cnt, int start) {
		if(cnt==3) {
	    	for(int i=0; i<N+1; i++) {
	    		mapCopy[i] = map[i].clone();
	    	}
			int[] copy = new int[3];
			copy = b.clone();
			operate(copy);
			ans = Math.max(ans, cntEnemy);
			cntEnemy = 0;
			for(int i=0; i<N+1; i++) {
				map[i] = mapCopy[i].clone();
	    	}
			return;
		}
		for(int i=start; i<M; i++) {
			b[cnt] = a[i];
			comb(cnt+1, i+1);
		}
	}
	static void operate(int[] b) {
		while(!isDone()) {
			shot(b);
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(v[i][j]) map[i][j] = 0;
				}
			}
			move();
		}
	}
	static boolean isDone() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==1) return false;
			}
		}
		return true;
	}
	static void shot(int[] b) {
//		for(int i=0; i<3; i++) {
//			int r = N;
//			int c = b[i];
			v = new boolean[N+1][M];
			bfs(b);
//		}
	}
    static void move() {
    	for(int i=N-1; i>=0; i--) {
    		for(int j=0; j<M; j++) {
    			if(map[i][j]==1) {
    				if(i!=N-1) {
    					map[i+1][j] = 1;
    				}
    				map[i][j] = 0;
    			}
    		}
    	}
    }
    static void bfs(int[] b) {
    	int i, j;
    	Queue<int[]> q = new ArrayDeque<>();
    	for(int k=0; k<3; k++) {
    		int r = N;
    		int c = b[k];
    		v[r][c] = true;
    		q.offer(new int[] {r,c,0});
    		i = r;
    		j = c;
    	}
    	while(!q.isEmpty()) {
    		int[] ij = q.poll();
    		i = ij[0];
    		j = ij[1];
    		int cnt = ij[2];
    		if(map[i][j]==1) {
    			//map[i][j] = 0;
    			cntEnemy++;
    			continue;
    		}
    		if(cnt==D) continue;
    		for(int d=0; d<3; d++) {
    			int ni = i + di[d];
    			int nj = j + dj[d];
    			if(ni>=0&&ni<N&&nj>=0&&nj<M) {
    				if(!v[ni][nj]) {
    					v[ni][nj] = true;
    					q.offer(new int[] {ni,nj,cnt+1});
    				} else if(v[ni][nj]&&map[ni][nj]==1) {
    					cntEnemy--;
    					q.offer(new int[] {ni,nj,cnt+1});
    				}
    			}
    		}
    	}
    }
}
/*
4 4 2
1 1 1 1
1 1 1 0
1 1 0 1
0 1 0 1
*/
