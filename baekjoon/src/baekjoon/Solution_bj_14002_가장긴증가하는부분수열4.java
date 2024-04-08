package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_14002_가장긴증가하는부분수열4 {
	static int N;
	static int[] arr;
	static List<Integer> list = new ArrayList<>();
	public static int binarySearch(int start, int end, int target) {
		while(start<end) {
			int mid = (start+end)/2;
			if(list.get(mid)<target) start = mid + 1;
			else end = mid;
		}
		return end;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		list.add(arr[0]);
		for(int i=1; i<N; i++) {
			if(arr[i]>list.get(list.size()-1)) {
				list.add(arr[i]);
				continue;
			}
			int idx = binarySearch(0, list.size()-1, arr[i]);
			list.set(idx, arr[i]);
		}
		sb.append(list.size()+"\n");
		for(int i=0; i<list.size(); i++) {
			sb.append(list.get(i)+" ");
		}
		System.out.println(sb);
	}
}
