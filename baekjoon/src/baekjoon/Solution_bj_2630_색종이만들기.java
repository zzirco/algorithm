package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_2630_색종이만들기 {
	static int N;
	static String[][] arr;
	static StringBuilder sb = new StringBuilder();
	static String quadTree(int r, int c, int n) {
		if(n==1) return arr[r][c];
		String[] sa = new String[4];
		sa[0] = quadTree(r,c,n/2);
		sa[1] = quadTree(r,c+n/2,n/2);
		sa[2] = quadTree(r+n/2,c,n/2);
		sa[3] = quadTree(r+n/2,c+n/2,n/2);
		if(sa[0].equals("0")&&sa[1].equals("0")&&sa[2].equals("0")&&sa[3].equals("0"))
			return "0";
		if(sa[0].equals("1")&&sa[1].equals("1")&&sa[2].equals("1")&&sa[3].equals("1"))
			return "1";
		return "("+sa[0]+sa[1]+sa[2]+sa[3]+")";
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		arr = new String[N][N];
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			for(int j=0; j<N; j++) {
				arr[i]= s.split(" ");
			}
		}
		String ans = quadTree(0,0,N);
		String[] ansa = ans.split("");
		int sum1 = 0;
		int sum2 = 0;
		for(int i=0; i<ansa.length; i++) {
			if(ansa[i].equals("0")) sum1++;
			else if(ansa[i].equals("1")) sum2++;
		}
		sb.append(sum1+"\n"+sum2);
		System.out.println(sb);
	}
}
