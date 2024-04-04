package a0404.camp;

import java.io.*;
import java.util.*;
 
public class Solution_D4_1249_보급로_서울_20반_신호준 {
    static int N, ans;
    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};
    static int [][] map;
    static int[][] sum;
    static boolean[][] v;
    static class Node {
    	int i, j, d; 
    	Node(int i,int j, int d){ 
    		this.i=i;
    		this.j=j;
    		this.d=d;
    	}
    }
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("res/input_d4_1249.txt"));
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc=1; tc<=T; tc++) {
        	N = Integer.parseInt(br.readLine());
            ans = Integer.MAX_VALUE;
            map = new int[N][N];
            sum = new int[N][N];
            v = new boolean[N][N];
            for(int i=0; i<N; i++) {
                Arrays.fill(sum[i], Integer.MAX_VALUE);
            }
            sum[0][0]=0;
            for(int i=0; i<N; i++) {
                String s = br.readLine();
                for(int j=0; j<N; j++) {
                    map[i][j] = s.charAt(j) - '0';
                }
            }
            PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1.d, o2.d));
            pq.offer(new Node(0,0,0));
            while(!pq.isEmpty()) {
            	Node cur = pq.poll();
            	if(cur.d>sum[cur.i][cur.j]) continue; 
            	for(int d=0; d<4; d++) {
            		int ni = cur.i + di[d];
            		int nj = cur.j + dj[d];
            		if(ni>=0&&ni<N&&nj>=0&&nj<N) {
            			int nd = cur.d + map[ni][nj];
            			if(sum[ni][nj]>nd) {
            				sum[ni][nj] = nd;
            				pq.offer(new Node(ni, nj, sum[ni][nj]));
            			}
            		}
            	}
            }
            sb.append("#"+tc+" "+sum[N-1][N-1]+"\n");
        }
        System.out.println(sb);
    }
}
