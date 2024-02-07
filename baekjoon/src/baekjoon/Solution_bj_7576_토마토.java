package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_7576_토마토 {
	static final int[] di= {-1,1,0,0}; // 상하좌우
	static final int[] dj= {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[][] tomato = new int[N][M]; // 토마토 익은 상태 저장
		int[][] time = new int[N][M]; // 익는 날짜 저장
		ArrayDeque<int[]> q = new ArrayDeque<>(); // bfs 탐색 큐
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
				if(tomato[i][j]==1) { // 익은 토마토 위치 큐에 저장
					q.offer(new int[] {i,j});
				}
				if(tomato[i][j]==0) { // 익지 않은 토마토 날짜 -1로 초기화
					time[i][j] = -1;
				}
			}
		}
		while(!q.isEmpty()) {
			int[] ij = q.poll();
			int i=ij[0];
			int j=ij[1];
			for(int d=0; d<4; d++) {
				int ni=i+di[d];
				int nj=j+dj[d];
				if(0<=ni && ni<N && 0<=nj && nj<M && time[ni][nj]==-1) { // 탐색범위가 인덱스 내이고 토마토가 익지 않았다면
					time[ni][nj] = time[i][j] + 1;
					q.offer(new int[]{ni,nj});
				}
			}
		}
		int ans = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(time[i][j]==-1) {
					System.out.println(-1);
					return;
				}
				ans = Math.max(ans, time[i][j]);
			}
		}
		System.out.println(ans);
	}
}
