package a0207.camp;

import java.io.*;
import java.util.*;

import org.xml.sax.helpers.AttributeListImpl;

public class Solution_D4_1861_정사각형방_서울_20반_신호준 {
	static final int[] di= {-1,1,0,0}; //상하좌우
	static final int[] dj= {0,0,-1,1};
	static int N;
	static int[][] arr;
	static PriorityQueue<Pair> breadthArr;
	static boolean[][] v;
	
	static class Pair {
		int breadth;
		int num;
		public Pair(int breadth, int num) {
			this.breadth = breadth;
			this.num = num;
		}
	}
	static void bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		v[i][j]=true;
		q.offer(new int[]{i,j});
		int size=0, breadth=0;
		while(!q.isEmpty()) {
			size = q.size();
			while(--size>=0) {
				int[] ij = q.poll();
				int I =ij[0];
				int J =ij[1];
				for(int d=0; d<4; d++) {
					int ni=I+di[d];
					int nj=J+dj[d];
					if(0<=ni && ni<N && 0<=nj && nj<N && !v[ni][nj] && arr[ni][nj]==arr[I][J]+1) {
						v[ni][nj]=true;
						q.offer(new int[] {ni,nj});
					}
				}
			}
			breadth++;
		}
		breadthArr.offer(new Pair(breadth,arr[i][j]));
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1861.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N];
			breadthArr =  new PriorityQueue<>((o1,o2)->o1.breadth==o2.breadth?Integer.compare(o1.num, o2.num):Integer.compare(o2.breadth, o1.breadth));
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					v = new boolean[N][N];
					bfs(i,j);
				}
			}
			Pair p = breadthArr.peek();
			int breadth = p.breadth;
			int num = p.num;
			sb.append("#"+tc+" "+num+" "+breadth+"\n");
		}
		System.out.println(sb);
	}
}
