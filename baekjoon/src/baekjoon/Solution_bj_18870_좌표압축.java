package baekjoon;

import java.io.*;
import java.util.*;

public class Solution_bj_18870_좌표압축 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		HashSet<Integer> set = new HashSet<>();
		for(int i=0; i<N; i++) {
			set.add(arr[i]);
		}
		int[] arr2 = new int[set.size()];
		Iterator<Integer> it = set.iterator();
		int idx = 0;
		while(it.hasNext()) {
			arr2[idx++] = it.next();
		}
		Arrays.sort(arr2);
		int[] ans = new int[N];
		for(int i=0; i<N; i++) {
		    int max = arr2.length;
		    int min = 0;
		    while(min<max){
		        int mid = (min+max)/2;
		        if(arr[i] > arr2[mid]){
		            min = mid+1;
		        }else{
		            max = mid;
		        }
		    }
		    ans[i] = min;
		}
		for(int i=0; i<N; i++) {
			System.out.print(ans[i] + " ");
		}
	}
}
