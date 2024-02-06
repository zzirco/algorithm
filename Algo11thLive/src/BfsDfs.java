import java.io.*;
import java.util.*;

public class BfsDfs {
	static final int[] di= {-1,0,1,0}; //상우하좌
	static final int[] dj= {0,1,0,-1};
	static int N=5, C=0;
	static int[][] a;
	static boolean[][] v;
	
	static void bfs3(int i, int j) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		v[i][j]=true;
		q.offer(new int[]{i,j,0}); // time 변수를 별도로 선언하지 않고, 파라미터로 전달
		while(!q.isEmpty()) {
			int[] ij = q.poll();
			i=ij[0];
			j=ij[1];
			int time=ij[2];
			a[i][j]=C++;
			System.out.println(time);
			for(int[] b:a)System.out.println(Arrays.toString(b));System.out.println();
			for(int d=0; d<4; d++) {
				int ni=i+di[d];
				int nj=j+dj[d];
				if(0<=ni && ni<N && 0<=nj && nj<N && !v[ni][nj]) {
					v[ni][nj]=true;
					q.offer(new int[]{ni,nj,time+1});
				}
			}
		}
	}
	static void bfs2(int i, int j) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		v[i][j]=true;
		q.offer(new int[]{i,j});
		int time=0;
		while(!q.isEmpty()) {
			int S=q.size();
			for(int s=0; s<S; s++) {
				int[] ij = q.poll();
				i=ij[0];
				j=ij[1];
				a[i][j]=C++;
				System.out.println(time);
				for(int[] b:a)System.out.println(Arrays.toString(b));System.out.println();
				for(int d=0; d<4; d++) {
					int ni=i+di[d];
					int nj=j+dj[d];
					if(0<=ni && ni<N && 0<=nj && nj<N && !v[ni][nj]) {
						v[ni][nj]=true;
						q.offer(new int[]{ni,nj});
					}
				}
			}
			time++;
		}
	}
	static void bfs(int i, int j) {
		ArrayDeque<int[]> q = new ArrayDeque<>();
		v[i][j]=true;
		q.offer(new int[]{i,j});
		while(!q.isEmpty()) {
			int[] ij = q.poll();
			i=ij[0];
			j=ij[1];
			//if(v[i][j]) continue; // 우선순위큐의 경우 여기서 방문처리 한다.
			a[i][j]=C++;
			for(int[] b:a)System.out.println(Arrays.toString(b));System.out.println();
			for(int d=0; d<4; d++) {
				int ni=i+di[d];
				int nj=j+dj[d];
				if(0<=ni && ni<N && 0<=nj && nj<N && !v[ni][nj]) {
					v[ni][nj]=true; // 항상 큐에 넣기 전에 방문처리부터 하자.
					q.offer(new int[]{ni,nj});
				}
			}
		}
	}
	static void dfs(int i, int j) {
		v[i][j]=true;
		a[i][j]=C++;
		for(int[] b:a)System.out.println(Arrays.toString(b));System.out.println();
		for(int d=0; d<4; d++) {
			int ni=i+di[d];
			int nj=j+dj[d];
			if(0<=ni && ni<N && 0<=nj && nj<N && !v[ni][nj]) {
				dfs(ni,nj);
			}
		}
	}
	public static void main(String[] args) throws Exception {
		a=new int[N][N];
		v=new boolean[N][N];
		C=1;
		dfs(N/2,N/2);
		//bfs3(N/2,N/2);
	}
}
