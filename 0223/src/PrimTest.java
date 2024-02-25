import java.io.*;
import java.util.*;

public class PrimTest {
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
		Arrays.fill(minEdge, Integer.MAX_VALUE); // 최소값 갱신위해 max로 초기화
		minEdge[0] = 0; // 임의의 시작점 0을 위해 처리
		int result = 0; // 최소신장트리 비용
		int c;
		for(c=0; c<V; c++) {
			
			// step 1 : 비트리 정점 중 최소간선비용의 정점 찾기!!
			int min = Integer.MAX_VALUE;
			int minVertex = -1;
			
			for(int i=0; i<V; i++) {
				if(!visited[i]&&minEdge[i]<min) {
					min = minEdge[i];
					minVertex = i;
				}
			}
			
			if(minVertex==-1) break;
			result += min; // 간선 비용 누적
			visited[minVertex] = true; // 트리 정점에 포함
			
			// step 2 : 새롭게 트리 정점에 확장된 정점 기준으로 비투리 정점들과의 간선비용 고려 최적 업데이트
			for(int i=0; i<V; i++) {
				if(!visited[i]&&adjMatrix[minVertex][i]!=0&&adjMatrix[minVertex][i]<minEdge[i]) {
					minEdge[i] = adjMatrix[minVertex][i];
				}
			}
		}
		System.out.println(c==V?result:-1);
	}
}
