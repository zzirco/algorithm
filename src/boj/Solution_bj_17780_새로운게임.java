package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_bj_17780_새로운게임 {
	static int[] di = {0,0,-1,1};
	static int[] dj = {1,-1,0,0};
	static class Node {
		int r;
		int c;
		int d;
		int p;
		public Node(int i, int j, int d) {
			this.r = i;
			this.c = j;
			this.d = d;
		}
		@Override
		public String toString() {
			return "Node [i=" + r + ", j=" + c + ", d=" + d + "]";
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		Node[] arr = new Node[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		for(int k=0; k<K; k++) {
			int i = Integer.parseInt(st.nextToken()) - 1;
			int j = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken()) - 1;
			arr[k] = new Node(i,j,d);
		}
		int cnt = 1;
		int turn = 0;
		while(true) {
			if(cnt==K) {
				System.out.println(turn);
				break;
			}
			for(int i=0; i<K; i++) {
				if(arr[i].p==i) {
					int r = arr[i].r;
					int c = arr[i].c;
					int d = arr[i].d;
					int nr = r + di[d];
					int nc = c + dj[d];
					if(map[nr][nc]==0) {
						arr[i].r = nr;
						arr[i].c = nc;
					} else if (map[nr][nc]==1) {
						
					} else {
						arr[i].r = r - di[d];
						arr[i].c = c - dj[d];
						if(d==0) arr[i].d = 1;
						else if(d==1) arr[i].d = 0;
						else if(d==2) arr[i].d = 3;
						else arr[i].d = 2;
					}
				}
			}
			turn++;
		}
	}
}
