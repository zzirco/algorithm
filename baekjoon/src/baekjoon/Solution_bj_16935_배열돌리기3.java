package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_16935_배열돌리기3 {
	static int N, M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		String[][] arr;
		if(N>M) {
			arr = new String[N][N];
		} else {
			arr = new String[M][M];
		}
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				arr[i][j] = st.nextToken();
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
				case 1:
					arr = m1(arr);
					break;
				case 2:
					arr = m2(arr);
					break;
				case 3:
					arr = m3(arr);
					break;
				case 4:
					arr = m4(arr);
					break;
				case 5:
					arr = m5(arr);
					break;
				case 6:	
					arr = m6(arr);
					break;
			}
		}
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				if(arr[i][j]==null) continue;
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	static String[][] m1(String[][] arr) {
		int N = arr.length;
		int M = arr[0].length;
		String[][] ans = new String[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				ans[i][j] = arr[N-1-i][j];
			}
		}
		return ans;
	}
	static String[][] m2(String[][] arr) {
		int N = arr.length;
		int M = arr[0].length;
		String[][] ans = new String[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				ans[i][j] = arr[i][M-1-j];
			}
		}
		return ans;
	}
	static String[][] m3(String[][] arr) {
		int N = arr.length;
		int M = arr[0].length;
		String[][] ans = new String[M][N];
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				ans[i][j] = arr[N][i];
			}
		}
		return ans;
	}
	static String[][] m4(String[][] arr) {
		int N = arr.length;
		int M = arr[0].length;
		String[][] ans = new String[M][N];
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				ans[i][j] = arr[j][M-1-i];
			}
		}
		return ans;
	}
	static String[][] m5(String[][] arr) {
		int N = arr.length;
		int M = arr[0].length;
		String[][] ans = new String[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(i<N/2&&j<M/2) ans[i][j] =  arr[i+N/2][j];
				else if(i<N/2&&M/2<=j) ans[i][j] = arr[i][j-M/2];
				else if(N/2<=i&&j<M/2) ans[i][j] =  arr[i][j+M/2];
				else ans[i][j] =  arr[i-N/2][j];
			}
		}
		return ans;
	}
	static String[][] m6(String[][] arr) {
		int N = arr.length;
		int M = arr[0].length;
		String[][] ans = new String[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(i<N/2&&j<M/2) ans[i][j] = arr[i][j+M/2];
				else if(i<N/2&&M/2<=j) ans[i][j] = arr[i+N/2][j];
				else if(N/2<=i&&j<M/2) ans[i][j] = arr[i-N/2][j];
				else ans[i][j] = arr[i][j-M/2];
			}
		}
		return ans;
	}
}
