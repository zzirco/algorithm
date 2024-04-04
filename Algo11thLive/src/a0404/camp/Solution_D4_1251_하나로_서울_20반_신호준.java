package a0404.camp;

import java.io.*;
import java.util.*;
 
public class Solution_D4_1251_하나로_서울_20반_신호준 {
    public static class Info {
    	int minVertex;
    	double min;
		public Info(int minVertex, double min) {
			super();
			this.minVertex = minVertex;
			this.min = min;
		}
    }
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("res/input_d4_1251.txt"));
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc=1; tc<=T; tc++) {
        	int N = Integer.parseInt(br.readLine());
        	StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        	StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        	double E = Double.parseDouble(br.readLine());
        	int[][] ij = new int[N][2];
        	for(int i=0; i<N; i++) {
        		ij[i][0] = Integer.parseInt(st1.nextToken());
        		ij[i][1] = Integer.parseInt(st2.nextToken());
        	}
        	double[][] g = new double[N][N];
    		boolean[] v = new boolean[N];
    		double[] minEdge = new double[N];
    		for(int i=0; i<N; i++) {
    			for(int j=0; j<N; j++) {
    				g[i][j] = E*(Math.pow(Math.abs(ij[i][0]-ij[j][0]),2)+Math.pow(Math.abs(ij[i][1]-ij[j][1]),2));
    			}
    			minEdge[i] = Double.MAX_VALUE;
    		}
    		double result = 0;
    		int cnt = 0;
    		PriorityQueue<Info> pq = new PriorityQueue<>((o1,o2)->Double.compare(o1.min, o2.min));
    		minEdge[0] = 0;
    		pq.offer(new Info(0,minEdge[0]));
    		while(!pq.isEmpty()) {
    			Info cur = pq.poll();
    			int minVertex = cur.minVertex;
    			double min = cur.min;
    			if(v[minVertex]) continue;
    			v[minVertex] = true;
    			result += min;
    			if(cnt++==N-1) break;
    			for(int j=0; j<N; j++) {
    				if(!v[j]&&minEdge[j]>g[minVertex][j]) {
    					minEdge[j]=g[minVertex][j];
    					pq.offer(new Info(j,minEdge[j]));
    				}
    			}
    		}
    		sb.append("#"+tc+" "+Math.round(result)+"\n");
        }
        System.out.println(sb);
    }
}
