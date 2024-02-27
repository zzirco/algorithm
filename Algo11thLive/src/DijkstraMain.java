import java.io.*;
import java.util.*;

public class DijkstraMain {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/dijkstra_input.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int S = sc.nextInt();
		int E = sc.nextInt();
		int[][] g = new int[N][N];
		boolean[] v = new boolean[N];
		int[] dist = new int[N]; // 다익스트라 d[]
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				g[i][j] = sc.nextInt();
			}
			dist[i] = Integer.MAX_VALUE;
		}
		//int result = 0, cnt = 0;
		dist[0] = 0;
		for(int i=0; i<N; i++) {
			int minVertex = -1;
			int min = Integer.MAX_VALUE;
			for(int j=0; j<N; j++) {
				if(!v[j]&&min>dist[j]) {
					minVertex = j;
					min = dist[j];
				}
			}
			v[minVertex] = true;
			//result += min;
			if(minVertex==N-1) break;
			for(int j=0; j<N; j++) {
				if(!v[j]&&g[minVertex][j]!=0&&dist[j]>min+g[minVertex][j]) {
					dist[j]=min+g[minVertex][j];
				}
//				if(!v[j]&&g[minVertex][j]!=0&&dist[j]>dist[minVertex]+g[minVertex][j]) {
//					dist[j]=dist[minVertex]+g[minVertex][j];
//				}
			}
		}
		System.out.println(dist[N-1]);
		sc.close();
	}
}
