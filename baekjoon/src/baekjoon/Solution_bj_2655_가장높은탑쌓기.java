package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_2655_가장높은탑쌓기 {
	static int N;
	static Box[] box;
	static int max;
	static String ans;
	static ArrayList<Integer> ansList;
	public static class Box {
		int a;
		int h;
		int w;
		public Box(int a, int h, int w) {
			super();
			this.a = a;
			this.h = h;
			this.w = w;
		}
		@Override
		public String toString() {
			return "Box [a=" + a + ", h=" + h + ", w=" + w + "]";
		}
	}
	public static void sol(int cnt, int preA, int preW, int h, String s) {
		if(cnt==N) {
			if(max<h) {
				max = h;
				ans = s;
			}
			return;
		}
		if(box[cnt].a<preA&&box[cnt].w<preW) {
			sol(cnt+1,box[cnt].a,box[cnt].w, h+box[cnt].h, s+(cnt+1)+" ");
			sol(cnt+1, preA, preW, h, s);
		}
		sol(cnt+1, preA, preW, h, s);
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		box = new Box[N];
		max = Integer.MIN_VALUE;
		ans = "";
		ansList = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			box[i] = new Box(a,h,w);
		}
		sol(0,Integer.MAX_VALUE, Integer.MAX_VALUE, 0, "");
		st = new StringTokenizer(ans, " ");
		while(st.hasMoreTokens()) {
			ansList.add(Integer.parseInt(st.nextToken()));
		}
		System.out.println(ansList.size());
		for(int i=ansList.size()-1; i>=0; i--) {
			System.out.println(ansList.get(i));
		}
		br.close();
	}
}
