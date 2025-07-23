package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_bj_16236_아기상어 {
	static int[] di = {-1,0,0,1};
	static int[] dj = {0,-1,1,0};
	static int N;
	static int[][] arr;
	static boolean[][] v;
	static int size = 2;
	static int sizeCnt = 0;
	static PriorityQueue<Pair> eatList;
	static class Pair implements Comparable<Pair> {
		int i;
		int j;
		int dist;
		Pair(int i, int j, int dist) {
			this.i = i;
			this.j = j;
			this.dist = dist;
		}
		@Override
		public String toString() {
			return "Pair [i=" + i + ", j=" + j + ", dist=" + dist + "]";
		}
		@Override
		public int compareTo(Pair o) {
			if(this.dist==o.dist) {
				if(this.i==o.i) {
					return Integer.compare(this.j, o.j);
				} else {
					return Integer.compare(this.i, o.i);
				}
			} else {
				return Integer.compare(this.dist,o.dist);
			}
		}
	}
	static void bfs(int i, int j, int dist) {
		Queue<int[]> q = new ArrayDeque<>();
		eatList = new PriorityQueue<>();
		q.offer(new int[] {i,j,dist});
		v[i][j] = true;
		while(!q.isEmpty()) {
			int[] ij = q.poll();
			i = ij[0];
			j = ij[1];
			dist = ij[2];
			for(int d=0; d<4; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if(ni>=0&&ni<N&&nj>=0&&nj<N&&!v[ni][nj]&&arr[ni][nj]<=size) {
					if(arr[ni][nj]<size&&arr[ni][nj]!=0) {
						v[ni][nj] = true;
						q.offer(new int[] {ni,nj,dist+1});
						eatList.offer(new Pair(ni,nj,dist+1));
						continue;
					}
					v[ni][nj] = true;
					q.offer(new int[] {ni,nj,dist+1});
				}
			}
		}
	}
	static boolean isDone() { // 배열에 상어 크기 보다 작은 물고기가 있으면 false 리턴
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr[i][j]<size) return false;
			}
		}
		return true;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		v = new boolean[N][N];
		int I=0, J=0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==9) {
					I = i; J = j;
				}
			}
		}
		int time = 0;
		while(!isDone()) { // 먹을 수 있는 물고기가 있으면 반복
			v = new boolean[N][N]; // 방문 배열 초기화
			bfs(I,J,0); // 물고기 탐색
			if(eatList.isEmpty()) { // 탐색 후 먹을 수 있는 물고기가 없으면
				System.out.println(time); // 시간 출력 후 종료
				return;
			} else { // 먹을 수 있는 물고기가 있으면, 큐에 거리순으로 상,좌,우,하 순으로 정렬 되어있으므로 해당 좌표에 상어 이동시키고, 상어 사이즈 갱신
				Pair p = eatList.poll();
				int i = p.i;
				int j = p.j;
				int dist = p.dist;
				arr[I][J] = 0;
				arr[i][j] = 9;
				I = i; J = j;
				sizeCnt++;
				if(sizeCnt==size) {
					size++;
					sizeCnt = 0;
				}
				time += dist;
			}
		}
		System.out.println(time);
	}
}
