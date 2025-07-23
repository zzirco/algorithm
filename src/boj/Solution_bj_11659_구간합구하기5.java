package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_bj_11659_구간합구하기5 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N*N];
		int[] s = new int[N*N];
		
		for(int i=0; i<N*N; i++) {
			if(i%N==0) {
				st = new StringTokenizer(br.readLine(), " ");
			}
			arr[i] = Integer.parseInt(st.nextToken());
			if(i==0) {
				s[i] = arr[i];
			} else {
				s[i] = s[i-1]+arr[i];
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int sum=0, res=0;
			for(int k=x1; k<=x2; k++) {
	            if(((k*N-N)+y1-2)<0) {
	                sum = s[(k*N-N)+y2-1];
	            } else {
	                sum = s[(k*N-N)+y2-1] - s[(k*N-N)+y1-2];
	            }
	            res += sum;
	        }
			sb.append(res+"\n");
		}
		System.out.println(sb);
		br.close();
	}
}
