import java.io.*;
import java.util.*;

public class PrimPQTest {
	static class Vertex implements Comparable<Vertex> {
		int no, weight;

		public Vertex(int no, int weight) {
			super();
			this.no = no;
			this.weight = weight;
		}

		@Override
		public int compareTo(PrimPQTest.Vertex o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(in.readLine());
		
		int[][] adjMatrix = new int[V][V]; // 인접행렬 준비
		boolean[] visited = new boolean[V]; // 트리정점여부
		int[] minEdge = new int[V]; // 비트리정점 기준으로 트리정점들과 연결했을 경우 최소간선비용
		
		StringTokenizer st = null;
		
		for(int i=0; i<V; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int j=0; j<V; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		Arrays.fill(minEdge, Integer.MAX_VALUE); // 최소값 갱신위해 max로 초기화
		minEdge[0] = 0; // 임의의 시작점 0을 위해 처리
		pq.offer(new Vertex(0,minEdge[0]));
		
		int result = 0; // 최소신장트리 비용
		int c = 0;
		while(!pq.isEmpty()) {
			
			// step 1 : 비트리 정점 중 최소간선비용의 정점 찾기!!
			Vertex minVertex = pq.poll();
			if(visited[minVertex.no]) continue;
			
			result += minVertex.weight; // 간선 비용 누적
			visited[minVertex.no] = true; // 트리 정점에 포함
			if(++c==V) break;
			
			// step 2 : 새롭게 트리 정점에 확장된 정점 기준으로 비투리 정점들과의 간선비용 고려 최적 업데이트
			for(int i=0; i<V; i++) {
				if(!visited[i]&&adjMatrix[minVertex.no][i]!=0&&adjMatrix[minVertex.no][i]<minEdge[i]) {
					minEdge[i] = adjMatrix[minVertex.no][i];
					pq.offer(new Vertex(i,minEdge[i]));
				}
			}
		}
		System.out.println(c==V?result:-1);
	}
}
