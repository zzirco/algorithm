import java.io.*;
import java.util.*;

public class PrimMain2 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/prim_input.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] g = new int[N][N];
		int[] minEdge = new int[N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				g[i][j] = sc.nextInt();
			}
			minEdge[i] = Integer.MAX_VALUE;
		}
		int result = 0, cnt = 0;
		
	}
}
