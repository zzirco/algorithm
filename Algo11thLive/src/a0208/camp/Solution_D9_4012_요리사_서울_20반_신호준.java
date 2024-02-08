package a0208.camp;

import java.io.*;
import java.util.*;
 
public class Solution_D9_4012_요리사_서울_20반_신호준 {
	static int N, R;
    static ArrayList<Integer> a, b, c;
    static int[][] S;
    static int ans = Integer.MAX_VALUE;
    
    private static void comb(int cnt, int start) {
    	if(cnt == R) {
    		int total = 0;
    		int sum = 0;
    		c = (ArrayList<Integer>) a.clone();
    		c.remove(b);
    		for(int i:b) {
    			for(int j:b) {
    				sum += S[i][j];
    			}
    		}
    		for(int i:c) {
    			for(int j:c) {
    				total += S[i][j];
    			}
    		}
    		int abs = Math.abs(total-sum);
    		if(abs<ans) ans = abs;
    		return;
    	}
    	for(int i=start; i<N; i++) {
    		b.add(a.get(i));
    		comb(cnt+1, i+1); 
    	}
    }
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("res/input_d9_4012.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
         
        for(int tc=1; tc<=T; tc++) {
        	N = Integer.parseInt(br.readLine());
        	R = N/2;
        	S = new int[N][N];
        	a = new ArrayList<>(); 
    		b = new ArrayList<>(); 
    		c = new ArrayList<>(); 
        	ans = Integer.MAX_VALUE;
        	for(int i=0; i<N; i++) {
        		a.add(i);
        	}
        	for(int i=0; i<N; i++) {
        		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        		for(int j=0; j<N; j++) {
        			S[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        	comb(0,0);
        	sb.append("#"+tc+" "+ans+"\n");
        }
        System.out.println(sb);
        br.close();
    }
}
