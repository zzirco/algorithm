package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_bj_2467_용액 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int min = Integer.MAX_VALUE;
		int as = 0, ae = 0;
		A:for(int i=0; i<N-1; i++) {
			int start = i+1;
			int end = N-1;
			while(start<=end) {
				int mid = (start+end)/2;
				int mix =arr[i]+arr[mid];
				if(mix==0) {
					min = Math.abs(mix);
					as = i;
					ae = mid;
					break A;
				}
				if(min>Math.abs(mix)) {
					min = Math.abs(mix);
					as = i;
					ae = mid;
				}
				if(mix>0) end = mid-1;
				else start = mid+1;
			}
		}
		System.out.println(arr[as]+" "+arr[ae]);
	}
}
