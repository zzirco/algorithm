package a0207.camp;

import java.io.*;
import java.util.*;

import org.xml.sax.helpers.AttributeListImpl;

public class Solution_D4_1277_미로2_서울_20반_신호준2 {
	static final int[] di= {-1,1,0,0}; //상하좌우
	static final int[] dj= {0,0,-1,1};
	static int N;
	static int[][] arr;
	static boolean[][] v;
	static int b = 0;
	
	static void bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>();
		v[i][j]=true;
		q.offer(new int[]{i,j});
		while(!q.isEmpty()) {
			int[] ij = q.poll();
			int I =ij[0];
			int J =ij[1];
			for(int d=0; d<4; d++) {
				int ni=I+di[d];
				int nj=J+dj[d];
				if(0<=ni && ni<N && 0<=nj && nj<N && !v[ni][nj] && arr[ni][nj]!=1) {
					if(arr[ni][nj]==3) {
						b = 1;
					}
					v[ni][nj]=true;
					q.offer(new int[] {ni,nj});
				}
			}
		}
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d4_1277.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int tc=1; tc<=10; tc++) {
			int testcase = Integer.parseInt(br.readLine());
			N = 100;
			b = 0;
			arr = new int[N][N];
			v = new boolean[N][N];
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				String[] sa = st.nextToken().split("");
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(sa[j]);
				}
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(arr[i][j]==2) {
						bfs(i,j);
					}
				}
			}
			sb.append("#"+testcase+" "+b+"\n");
		}
		System.out.println(sb);
	}
}
