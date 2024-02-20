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
	static int[] di = {0,-1,0};
	static int[] dj = {-1,0,1};
	static int[][] archer = new int[3][2];
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
    	// 궁수 조합 뽑기 위한 배열 생성
    	for(int j=0; j<M; j++) {
			a[j] = j;
		}
    	comb(0,0);
        System.out.println(ans);
        br.close();
    }
	static void comb(int cnt, int start) {
		if(cnt==3) {
			// 궁수 위치 조합 별로 주어진 맵에서 캐슬 디펜스 실행
	    	for(int i=0; i<N+1; i++) {
	    		mapCopy[i] = map[i].clone();
	    	}
			int[] copy = new int[3];
			copy = b.clone();
			operate(copy);
			// 캐슬 디펜스 실행 후 결과 갱신
			ans = Math.max(ans, cntEnemy);
			cntEnemy = 0;
			// 해당 조합 수행 후 맵 원상복귀
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
		// 아직 적이 남아있다면 사격과 적 이동 반복
		while(!isDone()) {
			// 사격 수행 후 사격한 위치 0으로 변경
			shot(b);
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(v[i][j]) map[i][j] = 0;
				}
			}
			// 사격 수행 후 적 이동 수행
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
	// 사격 수행 마다 방문 배열 초기화 후 bfs 수행
		v = new boolean[N+1][M];
		bfs(b,0);
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
    // 궁수로부터 제한 거리까지 탐색하면서 가장 가까운 적 사살. 만약 가장 가까운 적이 여러명이면 왼쪽부터 사살.
    static void bfs(int[] b, int cnt) {
    	int i, j;
    	Queue<int[]> q = new ArrayDeque<>();
    	// 처음 궁수 위치 큐에 삽입
    	for(int k=0; k<3; k++) {
    		int r = N;
    		int c = b[k];
    		v[r][c] = true;
    		q.offer(new int[] {r,c,0});
    		i = r;
    		j = c;
    	}
    	// 큐에 삽입된 원소 하나씩 뽑아서 탐색
    	A:while(!q.isEmpty()) {
    		int[] ij = q.poll();
    		i = ij[0];
    		j = ij[1];
    		cnt = ij[2];
//    		if(map[i][j]==1) {
//    			//map[i][j] = 0;
//    			cntEnemy++;
//    			continue;
//    		}
    		// 만약 궁수로부터 거리가 제한거리와 같다면 다음 위치 탐색
    		if(cnt==D) continue;
    		// 왼쪽부터 탐색하면서
    		for(int d=0; d<3; d++) {
    			int count = 0;
    			int ni = i + di[d];
    			int nj = j + dj[d];
    			// 탐색 위치가 인덱스 범위 내 이면
    			if(ni>=0&&ni<N&&nj>=0&&nj<M) {
    				// 탐색 위치를 기존에 방문하지 않았다면
    				if(!v[ni][nj]) {
    					// 탐색 위치에 적이 있으면 방문 처리하고, 적 사살 수 증가 후 다음 궁수 탐색
    					if(map[ni][nj]==1) {
    						v[ni][nj] = true;
    						cntEnemy++;
    						//적을 사살 했으므로 해당 분기의 다른 방향 탐색 제거
    						for(int idx=0; idx<count; idx++) {
    							q.poll();
    						}
    						continue A;
    					}
    					// 탐색 위치에 적이 없다면 방문 처리하고, 해당 위치부터 재탐색
    					count++;
    					v[ni][nj] = true;
    					q.offer(new int[] {ni,nj,cnt+1});
    				} else if(v[ni][nj]&&map[ni][nj]==1) { // 탐색 위치에 적이 있지만 이미 방문 했을 때는 다음 궁수 탐색
    					continue A;
    				}
    			}
    		}
    	}
    }
}
/*
9 10 4
1 0 0 1 0 1 0 1 1 0
0 0 0 1 0 0 0 1 0 0
0 1 0 0 1 0 0 1 1 1
0 0 1 1 0 1 0 1 1 0
0 1 1 0 0 0 0 1 0 1
0 1 1 1 0 1 0 1 0 0
0 0 0 0 0 0 0 1 0 0
1 1 1 1 1 1 1 1 0 1
0 1 1 0 1 1 0 1 1 0
ans : 26

5 5 3
1 1 1 0 1
0 1 1 0 0
1 1 1 0 0
0 1 1 0 0
1 1 1 0 0
ans : 13
*/
