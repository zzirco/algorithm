package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_bj_14502_연구소 {
	static final int[] di = {-1,1,0,0};
	static final int[] dj = {0,0,-1,1};
	static int N, M;
	static int[][] arr;
	static int[][] arrCopy;
	static boolean[][] v;
	static ArrayList<Integer> zero;
	static ArrayList<int[]> virus;
	static int ans;
	static int[] b = new int[3];
	static void comb(int cnt, int start) {
		if(cnt==3) {
			for(int index:b) {
				int i = index/M;
				int j = index%M;
				arr[i][j] = 1;
			}
			v = new boolean[N][M];
			for(int[] v:virus) {
				int i = v[0];
				int j = v[1];
				bfs(i,j);
			}
			int zeroCnt = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(arr[i][j]==0) {
						zeroCnt++;
					}
				}
			}
//			for(int i=0; i<N; i++) {
//				for(int j=0; j<M; j++) {
//					System.out.print(arr[i][j]+" ");
//				}
//				System.out.println();
//			}
			for(int i=0; i<N; i++) {
				arr[i] = arrCopy[i].clone();
			}
//			System.out.println();
//			for(int i=0; i<N; i++) {
//				for(int j=0; j<M; j++) {
//					System.out.print(arr[i][j]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println();
//			System.out.println("zeroCnt : "+zeroCnt);
			ans = Math.max(ans, zeroCnt);
//			System.out.println();
			return;
		}
		for(int i=start; i<zero.size(); i++) {
			b[cnt] = zero.get(i);
			comb(cnt+1, i+1);
		}
	}
	static void bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {i,j});
		v[i][j] = true;
		while(!q.isEmpty()) {
			int[] ij = q.poll();
			i = ij[0];
			j = ij[1];
			for(int d=0; d<4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if(ni>=0&&ni<N&&nj>=0&&nj<M&&!v[ni][nj]&&arr[ni][nj]!=1) {
					arr[ni][nj] = 2;
					v[ni][nj] = true;
					q.offer(new int[] {ni,nj});
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		arrCopy = new int[N][M];
		v = new boolean[N][M];
		zero = new ArrayList<>();
		virus = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==2) {
					virus.add(new int[] {i,j});
				}
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j]==0) {
					zero.add(i*M+j);
				}
			}
		}
		ans = 0;
		for(int i=0; i<N; i++) {
			arrCopy[i] = arr[i].clone();
		}
		comb(0,0);
		System.out.println(ans);
	}
}
