package baekjoon;

import java.io.*;
import java.util.*;
 
public class Solution_bj_9663_NQueen {
	static int N;
	static int ans;
	static int[] arr;
	static void dfs(int r) {
		if(r==N) {
			ans++;
			return;
		}
		for(int i=0; i<N; i++) {
			arr[r] = i;
			if(possible(r)) {
				dfs(r+1);
			}
		}
	}
	static boolean possible(int r) {
		for(int i=0; i<r; i++) {
			if(arr[i]==arr[r]||Math.abs(arr[i]-arr[r])==r-i) return false;
		}
		return true;
	}
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	N = Integer.parseInt(st.nextToken());
    	ans = 0;
    	arr = new int[N];
    	dfs(0);
    	System.out.println(ans);
        br.close();
    }
}
