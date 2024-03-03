package a0229.camp;

import java.io.*;
import java.util.*;
 
public class Solution_D9_1949_등산로조성_서울_20반_신호준 {
	static int N;
	static int K;
	static int high;
	static int max;
	static int[][] arr;
	static boolean[][] v;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("res/input_d9_1949.txt"));
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
        	max = 0;
        	high = 0;
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	N = Integer.parseInt(st.nextToken());
        	K = Integer.parseInt(st.nextToken());
        	arr = new int[N][N];
        	v = new boolean[N][N];
        	for(int i=0; i<N; i++) {
        		st = new StringTokenizer(br.readLine(), " ");
        		for(int j=0; j<N; j++) {
        			arr[i][j] = Integer.parseInt(st.nextToken());
        			high = Math.max(high, arr[i][j]);
        		}
        	}
        	for(int i=0; i<N; i++) {
        		for(int j=0; j<N; j++) {
        			if(arr[i][j] == high) {
        				v[i][j] = true;
        				dfs(i,j,1,1);
        				v[i][j] = false;
        			}
        		}
        	}
        	sb.append("#"+tc+" "+max+"\n");
        }
        System.out.println(sb);
    }
    static void dfs(int i, int j, int cnt, int cut) {
        int current = arr[i][j];
        for(int d=0; d<4; d++) {
        	int ni = i + dx[d];
        	int nj = j + dy[d];
            if(ni>=0&&ni<N&&nj>=0&&nj<N&&!v[ni][nj]) {
            	int next = arr[ni][nj];
		        if(next < current) {
		        	v[ni][nj] = true;
		            dfs(ni, nj, cnt+1, cut);
		            v[ni][nj] = false;
		        }
		        else if(cut==1) {
		        	for(int k=1; k<=K; k++) {
			        	if((next - k) < current){
				        	arr[ni][nj] -= k;
				        	dfs(ni, nj, cnt+1, cut-1);
				        	arr[ni][nj] += k;
				        }
		        	}
		        } 
            }
        }
        if(cnt>max) {
            max = cnt;
        }
    }
}
