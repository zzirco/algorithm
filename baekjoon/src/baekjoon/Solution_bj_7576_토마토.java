package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_7576_토마토 {
	static final int[] di= {-1,1,0,0}; // 상하좌우
	static final int[] dj= {0,0,-1,1};
	static int N, M;
	static int[][] arr;
	static boolean[][] v;
	static ArrayList<Integer> timeArr;
	
	static void bfs(int i, int j) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		v[i][j]=true;
		q.offer(new int[]{i,j,1});
		while(!q.isEmpty()) {
			int[] ij = q.poll();
			i=ij[0];
			j=ij[1];
			int time=ij[2];
			for(int d=0; d<4; d++) {
				int ni=i+di[d];
				int nj=j+dj[d];
				if(0<=ni && ni<N && 0<=nj && nj<M && !v[ni][nj] && arr[ni][nj]==0) {
					v[ni][nj]=true;
					arr[ni][nj]=1;
					q.offer(new int[]{ni,nj,time+1});
					timeArr.add(time);
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		v = new boolean[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean b = true;
		A:for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j]==0) {
					b = false;
					break A;
				}
			}
		}
		if(b) {
			System.out.println("0");
			return;
		}
		int ans = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j]==1&&!v[i][j]) {
					timeArr = new ArrayList<>();
					bfs(i,j);
					Collections.sort(timeArr);
					if(timeArr.size()!=0) {
						int time = timeArr.get(timeArr.size()-1);
						if(time>ans) {
							ans = time;
						}
					}
				}
			}
		}
		b = false;
		A:for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j]==0) {
					b = true;
					break A;
				}
			}
		}
		if(b) {
			System.out.println("-1");
			return;
		}
		sb.append(ans);
		System.out.println(sb);
	}
}
