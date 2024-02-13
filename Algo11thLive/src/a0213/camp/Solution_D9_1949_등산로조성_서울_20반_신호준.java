package a0213.camp;

import java.io.*;
import java.util.*;
 
public class Solution_D9_1949_등산로조성_서울_20반_신호준 {
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("res/input_d9_1949.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        	int N = Integer.parseInt(st.nextToken());
        	int K = Integer.parseInt(st.nextToken());
        	int[][] arr = new int[N][N];
        	for(int i=0; i<N; i++) {
        		st = new StringTokenizer(br.readLine(), " ");
        		for(int j=0; j<N; j++) {
        			arr[i][j] = Integer.parseInt(st.nextToken());
        		}
        	}
        }
        System.out.println(sb);
        br.close();
    }
}
