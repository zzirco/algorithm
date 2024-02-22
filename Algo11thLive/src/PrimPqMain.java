import java.io.*;
import java.util.*;

public class PrimPqMain {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/prim_input.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] g = new int[N][N];
		boolean[] v = new boolean[N];
		int[] minEdge = new int[N]; // 프림 w[]
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				g[i][j] = sc.nextInt();
			}
			minEdge[i] = Integer.MAX_VALUE;
		}
		//Arrays.fill(minEdge, Integer.MAX_VALUE);
		int result = 0, cnt = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->Integer.compare(o1[1], o2[1]));
		minEdge[0] = 0;
		pq.offer(new int[] {0,minEdge[0]}); // 정점 0, 가중치 1
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int minVertex = cur[0];
			int min = cur[1];
			if(v[minVertex]) continue;
			v[minVertex] = true;
			result += min;
			if(cnt++==N-1) break;
			for(int j=0; j<N; j++) {
				if(!v[j]&&g[minVertex][j]!=0&&minEdge[j]>g[minVertex][j]) {
					minEdge[j]=g[minVertex][j];
					pq.offer(new int[] {j,minEdge[j]});
				}
			}
		}
		System.out.println(result);
		sc.close();
	}
}
