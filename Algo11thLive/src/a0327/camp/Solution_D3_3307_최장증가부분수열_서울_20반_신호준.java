package a0327.camp;

import java.io.*;
import java.util.*;

public class Solution_D3_3307_최장증가부분수열_서울_20반_신호준 {
	static int N;
	static int[] arr;
	static List<Integer> list;
	public static int binarySearch(int start, int end, int target) {
		while(start<end) {
			int mid = (start+end)/2;
			if(list.get(mid)<target) start = mid + 1;
			else end = mid;
		}
		return end;
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_3307.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			list = new ArrayList<>();
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			list.add(arr[0]);
			for(int i=1; i<N; i++) {
				if(arr[i]>list.get(list.size()-1)) {
					list.add(arr[i]);
				}
				int idx = binarySearch(0, list.size()-1, arr[i]);
				list.set(idx, arr[i]);
			}
			sb.append("#"+tc+" "+list.size()+"\n");
		}
		System.out.println(sb);
		br.close();
	}
}
