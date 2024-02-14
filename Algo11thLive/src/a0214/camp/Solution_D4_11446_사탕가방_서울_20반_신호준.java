package a0214.camp;

import java.io.*;
import java.util.*;
 
public class Solution_D4_11446_사탕가방_서울_20반_신호준 {
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("res/input_d4_11446.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        	int N = Integer.parseInt(st.nextToken());
        	int M = Integer.parseInt(st.nextToken());
        	int[] arr = new int[N];
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int i=0; i<N; i++) {
        		arr[i] = Integer.parseInt(st.nextToken());
        	}
        	sb.append("");
        }
        System.out.println(sb);
        br.close();
    }
}
