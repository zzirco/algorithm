package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_15686_치킨배달 {
	static int n, R;
	static int[][] b;
	static ArrayList<int[]> house;
	static ArrayList<int[]> chicken;
	static int ans = Integer.MAX_VALUE;
	static void comb(int cnt, int start) {
		if(cnt==R) {
			//for(int[] i:b) System.out.print(Arrays.toString(i));
			//System.out.println(b.length);
			//System.out.println();
			int current = minCityDistance();
			if(ans>current) ans = current;
			return;
		}
		for(int i=start; i<n; i++) {
			b[cnt] = chicken.get(i);
			comb(cnt+1, i+1);
		}
	}
	static int minCityDistance() {
		int cityDistance = 0;
		ArrayList<int[]> houseCopy = (ArrayList<int[]>)house.clone();
		while(!houseCopy.isEmpty()) {
			int[] ij = houseCopy.remove(0);
			int i = ij[0];
			int j = ij[1];
			int chickenDistance = Integer.MAX_VALUE;
			int[][] bCopy = new int[b.length][2];
			for(int k=0; k<b.length; k++) {
				bCopy[k] = b[k].clone();
			}
			for(int k=0; k<bCopy.length; k++) {
				int[] rc = bCopy[k];
				int r = rc[0];
				int c = rc[1];
				int distance = Math.abs(i-r)+Math.abs(j-c);
				if(chickenDistance>distance) chickenDistance = distance;
			}
			cityDistance += chickenDistance;
		}
		return cityDistance;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][N];
		house = new ArrayList<>();
		chicken = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==1) house.add(new int[] {i,j});
				else if(arr[i][j]==2) chicken.add(new int[] {i,j});
			}
		}
		n = chicken.size();
		b = new int[R][2];
		comb(0,0);
		System.out.println(ans);
	}
}
