package a0215.camp;

import java.io.*;
import java.util.*;

public class Solution_D3_1219_길찾기_서울_20반_신호준 {
	static int N;
	static Node[] g;
	static boolean[] v;
	static int ans;
	static class Node {
		int vertex;
		Node link;
		Node(int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}
		@Override
		public String toString() {
			return vertex+"->"+link;
		}
	}
	static void dfs(int i) {
		v[i] = true;
		for(Node j=g[i]; j!=null; j=j.link) {// 0->N
			if(j.vertex==99) {
				ans = 1;
				return;
			}
			if(!v[j.vertex]) {
				dfs(j.vertex);
			}
		}
	}
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("res/input_d3_1219.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int tc=1; tc<=10; tc++) {
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        	int T = Integer.parseInt(st.nextToken());
        	int N = Integer.parseInt(st.nextToken());
        	st = new StringTokenizer(br.readLine(), " ");
    		g = new Node[100];
    		v = new boolean[100];
    		ans = 0;
    		for(int i=0; i<N; i++) {
    			int from = Integer.parseInt(st.nextToken());
    			int to = Integer.parseInt(st.nextToken());
    			g[from] = new Node(to, g[from]);
    		}
    		dfs(0);
    		System.out.println("#"+T+ " "+ans);
        }
        System.out.println(sb);
        br.close();
    }
}
