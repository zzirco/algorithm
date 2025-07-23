package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11729 {
	static StringBuilder sb = new StringBuilder();
	static void recursion(int a, int b, int N) throws Exception {
		if(N==1) {
			sb.append(a + " " + b + "\n");
			return;
		}
		recursion(a,6-a-b,N-1);
		sb.append(a + " " + b + "\n");
		recursion(6-a-b,b,N-1);
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		System.out.println((1<<N)-1);
		recursion(1,3,N);
		System.out.println(sb);
	}
}