package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_16435_스네이크버드 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] h = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			h[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(h);
		for(int i=0; i<N; i++) {
			if(L>=h[i]) L++;
			else break;
		}
		System.out.println(L);
		br.close();
	}
}
