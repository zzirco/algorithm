package a0220.camp;

import java.io.*;
import java.util.*;

public class Solution_D9_5653_줄기세포배양_서울_20반_신호준 {
	static int N, M, K;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static Pair[][] map;
	static class Pair {
		int live;
		int active; // >0:비활성화 0:활성화 -1:죽은상태 11:비초기화
		Pair(int live, int active) {
			this.live = live;
			this.active = active;
		}
		@Override
		public String toString() {
			return "Pair [live=" + live + ", active=" + active + "]";
		}
	}
	static void bfs(int i, int j, int live) {
		Queue<int[]> q = new ArrayDeque<>();
		//boolean[][] v = new boolean[N][M];
		//v[i][j] = true;
		q.offer(new int[] {i,j,live});
		while(!q.isEmpty()) {
			int[] ij = q.poll();
			i = ij[0];
			j = ij[1];
			live = ij[2];
			for(int d=0; d<4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if(ni>=0&&ni<N&&nj>=0&&nj<M&&map[ni][nj].active==11) {
					map[ni][nj].live = live;
					map[ni][nj].active = live;
					//v[ni][nj] = true;
					//q.offer(new int[] {ni,nj,live});
				}
			}
		}
	}
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("res/input_d9_5653.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        	N = Integer.parseInt(st.nextToken());
        	M = Integer.parseInt(st.nextToken());
        	K = Integer.parseInt(st.nextToken());
        	int cnt = 0;
        	Pair[][] arr = new Pair[N][M];
        	map = new Pair[Math.max(N, M)+2*K][Math.max(N, M)+2*K];
        	// 입력 배열 받기
        	for(int i=0; i<N; i++) {
        		st = new StringTokenizer(br.readLine(), " ");
        		for(int j=0; j<M; j++) {
        			int live = Integer.parseInt(st.nextToken());
        			int active = live;
        			if(live==0) arr[i][j] = new Pair(11,11);
        			else arr[i][j] = new Pair(live,active);
        		}
        	}
        	// 배양 배열 초기화
        	for(int i=0; i<map.length; i++) {
    			for(int j=0; j<map[0].length; j++) {
    				map[i][j] = new Pair(11,11);
    			}
    		}
        	// 입력 받은 배열 배양 배열에 입력
        	for(int i=0; i<N; i++) {
        		for(int j=0; j<M; j++) {
        			map[map.length/2-N/2+i][map.length/2-M/2+j] = arr[i][j];
        		}
        	}
        	int time = 1;
        	// 주어진 배양시간만큼 반복
        	while(true) {
        		if(time==K) break;
        		// 활성화된 줄기세포에 대해 번식 수행
        		for(int i=0; i<map.length; i++) {
        			for(int j=0; j<map[0].length; j++) {
        				if(map[i][j].active==0) {
        					bfs(i,j,map[i][j].live);
        				}
        			}
        		}
        		// 시간이 지남에 따른 활성화 카운트
        		for(int i=0; i<map.length; i++) {
        			for(int j=0; j<map[0].length; j++) {
        				if(map[i][j].active!=11) {
        					map[i][j].active--;
        				}
        			}
        		}
        		time++;
        	}
        	// 주어진 배양시간이 지난 후 비활성화+활성화 줄기세포 수 카운팅
        	for(int i=0; i<map.length; i++) {
    			for(int j=0; j<map[0].length; j++) {
    				if(map[i][j].active>=0&&map[i][j].active<=10) {
    					cnt++;
    				}
    			}
    		}
        	sb.append("#"+tc+" "+cnt+"\n");
        }
        System.out.println(sb);
        br.close();
    }
}
