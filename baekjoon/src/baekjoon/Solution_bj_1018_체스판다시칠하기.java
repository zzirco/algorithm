package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_1018_체스판다시칠하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[][] arr = new String[N][M];
		
		for(int i=0; i<N; i++) {
			String s = br.readLine();
			String[] sa = s.split("");
			for(int j=0; j<M; j++) {
				arr[i][j] = sa[j];
			}
		}
		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				String[][] arr2 = new String[8][8];
				if(j+8<=M) {
					System.arraycopy(arr[i], i, arr2, j, j+7);
				}
			}
		}
		
		System.out.println(Arrays.deepToString(arr));
	}

}
