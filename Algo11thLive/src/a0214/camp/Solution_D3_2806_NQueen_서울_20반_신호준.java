package a0214.camp;

import java.io.*;
import java.util.*;
 
public class Solution_D3_2806_NQueen_서울_20반_신호준 {
	static int N;
	static int cnt=0;
	static List<int[]> list = new ArrayList<>();
	static int[] di = {-1,1};
	static int[] dj = {1,1};
	static void dfs(int [] ij) {
		int i = ij[0];
		int j = ij[1];
		for(int[] item:list) {
			if(j==item[1]) {
				return;
			}
			for(int d=0; d<2; d++) {
				for(int k=-N; k<N; k++) {
					int ni = item[0] + di[d]*k;
					int nj = item[1] + dj[d]*k;
					if(ni>=0&&ni<N&&nj>=0&&nj<N) {
						if(ni==i&&nj==j) return;
					}
				}
			}
		}
		if(i>N-1) {
			cnt++;
			return;
		}
		for(int p=i+1; p<N; p++) {
    		for(int q=0; q<N; q++) {
    			list.add(new int[] {i,j});
    			dfs(new int[] {p,q});
    		}
    	}
	}
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("res/input_d3_2806.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        	N = Integer.parseInt(st.nextToken());
        	cnt = 0;
        	list = new ArrayList<>();
        	for(int i=0; i<N; i++) {
        		for(int j=0; j<N; j++) {
        			list.add(new int[] {i,j});
        			dfs(new int[] {i,j});
        		}
        	}
        	sb.append("#"+tc+" "+cnt+"\n");
        }
        System.out.println(sb);
        br.close();
    }
}
