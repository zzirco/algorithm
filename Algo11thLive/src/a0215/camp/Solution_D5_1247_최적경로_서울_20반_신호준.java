package a0215.camp;

import java.io.*;
import java.util.*;

public class Solution_D5_1247_최적경로_서울_20반_신호준 {
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("res/input_d5_1247.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
        	int N = Integer.parseInt(br.readLine());
        	int[][] cus = new int[N][2];
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        	for(int i=0; i<N; i++) {
        		cus[i][0] = Integer.parseInt(st.nextToken());
        		cus[i][1] = Integer.parseInt(st.nextToken());
        	}
    		System.out.println("#"+T+ " ");
        }
        System.out.println(sb);
        br.close();
    }
}
