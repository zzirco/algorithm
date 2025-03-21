package baekjoon;

import java.io.*;
import java.util.*;

public class Main_1629 {
	static long recursion(long A, long B, long C) {
		if(B==1) return A%C;
		long tmp = recursion(A,B/2,C);
		if(B%2==0) return tmp%C*tmp%C;
		else return tmp%C*tmp%C*A%C;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long C = Long.parseLong(st.nextToken());
		System.out.println(recursion(A,B,C));
	}
}