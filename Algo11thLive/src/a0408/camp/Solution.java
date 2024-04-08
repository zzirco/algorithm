package a0408.camp;

import java.io.*;
import java.util.*;
 
public class Solution {
    static int N, M, P, C, D, ri, rj;
    static int[] di8 = {-1,-1,-1,0,1,1,1,0};
    static int[] dj8 = {-1,0,1,1,1,0,-1,-1};
    static int[] di = {-1,0,1,0};
    static int[] dj = {0,1,0,-1};
    static List<int[]> list = new ArrayList<>();
    public static void sol() {
    	int min = Integer.MAX_VALUE;
    	int ni=0, nj=0;
    	for(int i=0; i<list.size(); i++) {
    		int d = (int)(Math.pow(ri-list.get(i)[1], 2)+Math.pow(rj-list.get(i)[2], 2));
    		min = Math.min(min, d);
    		ni = list.get(i)[1];
    		nj = list.get(i)[2];
    	}
    	
    }
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	P = Integer.parseInt(st.nextToken());
    	C = Integer.parseInt(st.nextToken());
    	D = Integer.parseInt(st.nextToken());
    	st = new StringTokenizer(br.readLine(), " ");
    	ri = Integer.parseInt(st.nextToken());
    	rj = Integer.parseInt(st.nextToken());
    	for(int i=0; i<P; i++) {
    		st = new StringTokenizer(br.readLine(), " ");
    		int snum = Integer.parseInt(st.nextToken());
        	int si = Integer.parseInt(st.nextToken());
        	int sj = Integer.parseInt(st.nextToken());
        	list.add(new int[] {snum, si, sj});
    	}
    }
}
