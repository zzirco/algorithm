package a0227.camp;

import java.io.*;
import java.util.*;

public class Solution_D2_14510_나무높이_서울_20반_신호준 {
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("res/input_d2_14510.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc=1; tc<=T; tc++) {
        	int N = Integer.parseInt(br.readLine());
        	int[] tree = new int[N];
        	int day = 0;
        	st = new StringTokenizer(br.readLine(), " ");
        	int max = 0;
        	for(int i=0; i<N; i++) {
        		tree[i] = Integer.parseInt(st.nextToken());
        		max = Math.max(max, tree[i]);
        	}
        	int odd = 0, even = 0;
        	for(int i=0; i<N; i++) {
        		int diff = max - tree[i];
        		if(diff==0) continue;
        		odd += diff%2;
        		even += diff/2;
        	}
        	if(even>odd) {
        		while(Math.abs(even-odd)>1) {
        			even--;
        			odd += 2;
        		}
        	}
        	int ans;
        	if(odd>even) {
        		ans = odd * 2 - 1;
        	} else if(even>odd) {
        		ans = even * 2;
        	} else {
        		ans = odd + even;
        	}
        	sb.append("#"+tc+" "+ans+"\n");
        }
        System.out.println(sb);
        br.close();
    }
}
