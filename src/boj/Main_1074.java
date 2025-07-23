package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1074 {
	static int recursion(int N, int r, int c) {
		if(N==0) return 0;
		int half = 1<<(N-1);
		if(half>r&&half>c) return recursion(N-1,r,c);
		else if(half>r&&half<=c) return half*half+recursion(N-1,r,c-half);
		else if(half<=r&&half>c) return 2*half*half+recursion(N-1,r-half,c);
		else return 3*half*half+recursion(N-1,r-half,c-half);
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		System.out.println(recursion(N,r,c));
	}
}