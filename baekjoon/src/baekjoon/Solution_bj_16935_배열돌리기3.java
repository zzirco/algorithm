package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_16935_배열돌리기3 {
	static int[][] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		Queue<Integer> q = new ArrayDeque<>();
		st = new StringTokenizer(br.readLine(), " ");
		while(st.hasMoreTokens()) {
			q.offer(Integer.parseInt(st.nextToken()));
		}
		while(!q.isEmpty()) {
			int order = q.poll();
			switch(order) {
				case 1: m1(); break;
				case 2: m2(); break;
				case 3: m3(); break;
				case 4: m4(); break;
				case 5: m5(); break;
				case 6:	m6(); break;
			}
		}
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				sb.append(arr[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	static void m1() {
		int N = arr.length;
		int M = arr[0].length;
		for(int i=0; i<N/2; i++) {
			for(int j=0; j<M; j++) {
				int tmp = arr[i][j];
				arr[i][j] = arr[N-1-i][j];
				arr[N-1-i][j] = tmp;
			}
		}
	}
	static void m2() {
		int N = arr.length;
		int M = arr[0].length;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M/2; j++) {
				int tmp = arr[i][j];
				arr[i][j] = arr[i][M-1-j];
				arr[i][M-1-j] = tmp;
			}
		}
	}
	static void m3() {
		int N = arr.length;
		int M = arr[0].length;
		int[][] tmp = new int[N][M];
		for(int i=0; i<N; i++) {
			tmp[i] = arr[i].clone();
		}
		arr = new int[M][N];
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				arr[i][j] = tmp[N-1-j][i];
			}
		}
	}
	static void m4() {
		int N = arr.length;
		int M = arr[0].length;
		int[][] tmp = new int[N][M];
		for(int i=0; i<N; i++) {
			tmp[i] = arr[i].clone();
		}
		arr = new int[M][N];
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				arr[i][j] = tmp[j][M-1-i];
			}
		}
	}
	static void m5() {
		int N = arr.length;
		int M = arr[0].length;
		int[][] tmp = new int[N][M];
		for(int i=0; i<N; i++) {
			tmp[i] = arr[i].clone();
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(i<N/2&&j<M/2) arr[i][j] =  tmp[i+N/2][j];
				else if(i<N/2&&M/2<=j) arr[i][j] = tmp[i][j-M/2];
				else if(N/2<=i&&j<M/2) arr[i][j] =  tmp[i][j+M/2];
				else arr[i][j] =  tmp[i-N/2][j];
			}
		}
	}
	static void m6() {
		int N = arr.length;
		int M = arr[0].length;
		int[][] tmp = new int[N][M];
		for(int i=0; i<N; i++) {
			tmp[i] = arr[i].clone();
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(i<N/2&&j<M/2) arr[i][j] = tmp[i][j+M/2];
				else if(i<N/2&&M/2<=j) arr[i][j] = tmp[i+N/2][j];
				else if(N/2<=i&&j<M/2) arr[i][j] = tmp[i-N/2][j];
				else arr[i][j] = tmp[i][j-M/2];
			}
		}
	}
}
