package a0403.camp;

import java.io.*;
import java.util.*;
 
public class Solution_D3_4615_재미있는오셀로게임_서울_20반_신호준 {
	static int[] di = {-1,-1,-1,0,1,1,1,0};
	static int[] dj = {-1,0,1,1,1,0,-1,-1};
	static int N, M;
	static int[][] map;
	static boolean[][] v;
	public static void sol(int si, int sj, int color) {
		int i = si;
		int j = sj;
		int d = 0;
		A:while(d<8) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if(ni>=0&&ni<N&&nj>=0&&nj<N) {
				i = ni;
				j = nj;
				if(map[i][j]==0) {
					d++;
					i = si;
					j = sj;
					v = new boolean[N][N];
					continue A;
				}
				v[i][j]=true;
				if(map[i][j]==color) {
					for(int r=0; r<N; r++) {
						for(int c=0; c<N; c++) {
							if(v[r][c]) map[r][c] = color;
						}
					}
					d++;
					i = si;
					j = sj;
					v = new boolean[N][N];
				}
			} else {
				d++;
				i = si;
				j = sj;
				v = new boolean[N][N];
			}
		}
	}
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("res/input_d3_4615.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        	N = Integer.parseInt(st.nextToken());
        	M = Integer.parseInt(st.nextToken());
        	map = new int[N][N];
        	v = new boolean[N][N];
        	map[N/2-1][N/2-1] = 2;
        	map[N/2-1][N/2] = 1;
        	map[N/2][N/2-1] = 1;
        	map[N/2][N/2] = 2;
        	for(int i=0; i<M; i++) {
        		st = new StringTokenizer(br.readLine(), " ");
        		int r = Integer.parseInt(st.nextToken());
        		int c = Integer.parseInt(st.nextToken());
        		int color = Integer.parseInt(st.nextToken());
        		map[c-1][r-1] = color;
        		sol(c-1,r-1,color);
        		
        	}
        	int cnt = 0, cnt2 = 0;
        	for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(map[r][c]==1) cnt++;
					else if(map[r][c]==2) cnt2++;
				}
			}
        	sb.append("#"+tc+" "+cnt+" "+cnt2+"\n");
        }
        System.out.println(sb);
    }
}