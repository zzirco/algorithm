package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class Solution_bj_2295_세수의합 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		HashSet<Integer> set = new HashSet<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				set.add(arr[i]+arr[j]);
			}
		}
		Iterator<Integer> it = set.iterator();
		int idx = 0;
		int[] arr2 = new int[set.size()];
		while(it.hasNext()) {
			arr2[idx++] = it.next();
		}
		Arrays.sort(arr);
		Arrays.sort(arr2);
		for(int i=N-1; i>0; i--) {
			for(int j=0; j<i; j++) {
				int st = 0;
				int en = arr2.length-1;
				while(st<=en) {
					int mid = (st+en)/2;
					if(arr[i]-arr[j]==arr2[mid]) {
						System.out.println(arr[i]);
						return;
					} else if(arr[i]-arr[j]<arr2[mid]) en = mid - 1;
					else st = mid + 1;
				}
			}
		}
	}
}
