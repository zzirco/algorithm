package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_16398_행성연결 {
	static int N;
	static int[][] g;
	static int[] p;
	static void make() {
		p = new int[N];
		for(int i=0; i<N; i++) p[i] = i;
	}
	static int find(int a) {
		
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		}
	}
}
