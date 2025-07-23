package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_bj_19951_태상이의훈련소생활 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int[] tmp = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			int height = Integer.parseInt(st.nextToken());
			tmp[start] = tmp[start] + height;
			if(end+1<N) {
				tmp[end+1] = tmp[end+1] - height;
			}
		}
		for(int i=1; i<N; i++) {
			tmp[i] = tmp[i-1] + tmp[i];
		}
		for(int i=0; i<N; i++) {
			arr[i] = arr[i] + tmp[i];
		}
		for(int i=0; i<N; i++) {
			sb.append(arr[i]+" ");
		}
		System.out.println(sb);
	}
}
