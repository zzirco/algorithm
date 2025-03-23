import java.io.*;
import java.util.*;

public class test {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] g = new int[N][N];
		boolean[] v = new boolean[N];
		int[] dist = new int[N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				g[i][j] = sc.nextInt();
			}
			dist[i] = Integer.MAX_VALUE;
		}
		PriorityQueue<int[]> q = new PriorityQueue<>((o1,o2)->Integer.compare(o1[1], o2[1]));
		dist[0] = 0;
		q.offer(new int[] {0,dist[0]});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int minVertex = cur[0];
			int min = cur[1];
			if(v[minVertex]) continue;
			v[minVertex] = true;
			if(minVertex==N-1) break;
			for(int i=0; i<N; i++) {
				if(!v[i]&&g[minVertex][i]!=0&&dist[i]>min+g[minVertex][i]) {
					dist[i] = min + g[minVertex][i];
					q.offer(new int[] {i,dist[i]});
				}
			}
		}
		System.out.println(dist[N-1]);
		sc.close();
	}
}