package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_bj_17406_배열돌리기4 {
	static int[] di = {1,0,-1,0}; //하우상좌 시계
	static int[] dj = {0,1,0,-1};
	
	static int n, R;
	static int[] a, b;
	static boolean[] v;
	static Queue<int[]> q;
	static void perm(int cnt) {
		if(cnt==R) {
			int[] arr = new int[R];
			arr = b.clone();
			q.offer(arr);
			return;
		}
		for(int i=0; i<n; i++) {
			if(v[i]) continue;
			v[i] = true;
			b[cnt] = a[i];
			perm(cnt+1);
			v[i] = false;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][M];
		// 숫자 배열 입력받기
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 회전 연산 입력받기
		int[][] order = new int[K][3];
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<3; j++) {
				order[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 회전 연산 순열 생성
		n = order.length;
		R = order.length;
		a = new int[n];
		b = new int[R];
		v = new boolean[n];
		q = new ArrayDeque<>();
		for(int i=0; i<n; i++) {
			a[i] = i;
		}
 		perm(0);
		// 회전 수행
 		int min = Integer.MAX_VALUE;
 		while(!q.isEmpty()) {
 			int[][] copy = new int[N][M];
 			for(int i=0; i<N; i++) {
 				copy[i] = arr[i].clone();
 			}
 			int[] queue = q.poll();
 			for(int i:queue) {
 				int r = order[i][0];
 				int c = order[i][1];
 				int s = order[i][2];
 				for(int j=0; j<s; j++) {
 					int I = r-s-1+j;
 					int J = c-s-1+j;
 					int tmp = copy[I][J];
 					int d = 0;
 					while(d<4) {
 						int ni = I + di[d];
 						int nj = J + dj[d];
 						if(ni>=r-s-1+j&&ni<r+s-j&&nj>=c-s-1+j&&nj<c+s-j) {
 							copy[I][J] = copy[ni][nj];
 							I = ni; J = nj;
 						} else {
 							d++;
 						}
 					}
 					copy[I][J+1] = tmp;
 				}
 			}
 			for(int i=0; i<N; i++) {
 				int sum = 0;
 				for(int j=0; j<M; j++) {
 					sum += copy[i][j];
 				}
 				if(sum<min) min = sum;
 			}
 		}
		System.out.println(min);
	}
}
