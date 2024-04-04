package a0404.camp;

import java.io.*;
import java.util.*;
 
public class Solution_D9_5648_원자소멸시뮬레이션_서울_20반_신호준 {
	static int[] di = {-1,1,0,0};
	static int[] dj = {0,0,-1,1};
	static int N, K;
	static List<Atom> list;
	static class Atom {
		int i, j, d, energy;
		public Atom(int i, int j, int d, int energy) {
			this.i = i;
			this.j = j;
			this.d = d;
			this.energy = energy;
		}
		@Override
		public String toString() {
			return "Atom [i=" + i + ", j=" + j + ", d=" + d + ", energy=" + energy + "]";
		}
	}
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("res/input_d9_5648.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        	N = Integer.parseInt(st.nextToken());
        	list = new ArrayList<>();
        	for(int k=0; k<N; k++) {
        		st = new StringTokenizer(br.readLine(), " ");
        		int i = Integer.parseInt(st.nextToken());
        		int j = Integer.parseInt(st.nextToken());
        		int d = Integer.parseInt(st.nextToken());
        		int energy = Integer.parseInt(st.nextToken());
        		list.add(new Atom(i,j,d,energy));
        	}
        	System.out.println(list);
        }
        System.out.println(sb);
    }
}
