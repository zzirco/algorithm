package a0214.camp;

import java.io.*;
import java.util.*;
 
public class Solution_D3_2806_NQueen_서울_20반_신호준 {
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
    	System.setIn(new FileInputStream("res/input_d3_2806.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        	N = Integer.parseInt(st.nextToken());
        	ans = 0;
        	arr = new int[N];
        	dfs(0);
        	sb.append("#"+tc+" "+ans+"\n");
        }
        System.out.println(sb);
        br.close();
    }
}
