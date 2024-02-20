import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;
/*
7
8
0 1
0 2
0 5
0 6
4 3
5 3
5 4
6 4
 */
// 무향 그래프
public class AdjMatrixTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		int[][] adjMatrix = new int[V][V]; // 0으로 초기화(인접되지 않은 상태로 초기화)
		for(int i=0; i<E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjMatrix[to][from] = adjMatrix[from][to] = 1; // 무향이므로 간선 양방향 처리
		}
		//bfs(adjMatrix, 0);
		dfs(adjMatrix, new boolean[V], 0);
	}
	static void bfs(int[][] adjMatrix, int start) {
		int V = adjMatrix.length;
		
		Queue<Integer> queue = new ArrayDeque<>();
		boolean[] visited = new boolean[V];
		
		queue.offer(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.println((char)(current+65));
			for(int i=0; i<V; i++) {
				if(adjMatrix[current][i]!=0&&!visited[i]) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
	}
	static void dfs(int[][] adjMatrix, boolean[] visited, int current) {
		int V = adjMatrix.length;
		visited[current] = true;
		System.out.println((char)(current+65));
		for(int i=0; i<V; i++) {
			if(adjMatrix[current][i]!=0&&!visited[i]) {
				dfs(adjMatrix, visited, i);
			}
		}
	}
}
