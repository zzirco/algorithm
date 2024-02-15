package a0215.camp;

import java.io.*;
import java.util.*;
 
public class Solution_D3_1873_상호의배틀필드_서울_20반_신호준 {
	static int H, W, d;
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static String[] da = {"^","v","<",">"};
	static String[][] map;
	static int[] start;
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("res/input_d3_1873.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        	 H = Integer.parseInt(st.nextToken());
        	 W = Integer.parseInt(st.nextToken());
        	 map = new String[H][W];
        	 start = new int[1];
        	 for(int i=0; i<H; i++) {
        		 String s = br.readLine();
        		 String[] sa = s.split("");
        		 for(int j=0; j<W; j++) {
        			 map[i][j] = sa[j];
        			 switch(map[i][j]) {
        			 case "^":
        				 start = new int[] {i,j};
        				 d = 0; break;
        			 case "v":
        				 start = new int[] {i,j};
        				 d = 1; break;
        			 case "<":
        				 start = new int[] {i,j};
        				 d = 2; break;
        			 case ">":
        				 start = new int[] {i,j};
        				 d = 3; break;
        			 }
        		 }
        	 }
        	 st = new StringTokenizer(br.readLine(), " ");
        	 int N = Integer.parseInt(st.nextToken());
        	 String[] order = br.readLine().split("");
        	 for(int i=0; i<N; i++) {
        		 move(order[i], start);
        	 }
        	 sb.append("#"+tc+" ");
        	 for(int i=0; i<H; i++) {
        		 for(int j=0; j<W; j++) {
        			sb.append(map[i][j]);
        		 }
        		 sb.append("\n");
        	 }
        }
        System.out.println(sb);
        br.close();
    }
	static void move(String order, int[] cur) {
		int[] ij = cur;
		int i = ij[0];
		int j = ij[1];
		switch(order) {
		case "U":
			d=0;
			map[i][j] = da[d];
			if(possible(i-1,j,"U")) {
				map[i][j] = ".";
				start = new int[] {i-1,j};
			}
			break;
		case "D":
			d=1;
			map[i][j] = da[d];
			if(possible(i+1,j,"U")) {
				map[i][j] = ".";
				start = new int[] {i+1,j};
			}
			break;
		case "L":
			d=2;
			map[i][j] = da[d];
			if(possible(i,j-1,"U")) {
				map[i][j] = ".";
				start = new int[] {i,j-1};
			}
			break;
		case "R":
			d=3;
			map[i][j] = da[d];
			if(possible(i,j+1,"U")) {
				map[i][j] = ".";
				start = new int[] {i,j+1};
			}
			break;
		case "S":
			possible(i,j,"S");
			break;
		}
	}
	static boolean possible(int i, int j,String order) {
		if(!order.equals("S")) {
			if(i>=0&&i<H&&j>=0&&j<W) {
				if(map[i][j].equals(".")) {
					map[i][j] = da[d];
					return true;
				} else {
					return false;
				}
			}
			return false;
		} else {
			while(true) {
				int ni = i+di[d];
				int nj = j+dj[d];
				if(ni>=0&&ni<H&&nj>=0&&nj<W) {
					if(map[ni][nj].equals(".")) {
						i = ni;
						j = nj;
						continue;
					} else if(map[ni][nj].equals("*")) {
						map[ni][nj] = ".";
						break;
					} else if(map[ni][nj].equals("#")) {
						break;
					} else if(map[ni][nj].equals("-")) {
						i = ni;
						j = nj;
						continue;
					}
				} else {
					break;
				}
			}
			return true;
		}
	}
}
