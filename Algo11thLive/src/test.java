import java.io.*;
import java.util.*;

public class test {
	static int N;
	static int[][] g;
	static int[] p;
	public static void make() {
		p = new int[N];
		for(int i=0; i<N; i++) p[i] = i;
	}
	public static int find(int a) {
		if(p[a] == a) return a;
		return p[a] = find(p[a]);
	}
	public static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a==b) return false;
		p[b] = a;
		return true;
	}
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int E = sc.nextInt();
		g = new int[E][3];
		for(int i=0; i<E; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			int weight = sc.nextInt();
			g[i] = new int[] {from, to, weight};
		}
		Arrays.sort(g,(o1,o2)->Integer.compare(o1[2], o2[2]));
		make();
		int result = 0, cnt = 0;
		for(int[] edge:g) {
			if(union(edge[0],edge[1])) {
				result+=edge[2];
				if(cnt++==N-1) break;
			}
		}
		System.out.println(result);
		sc.close();
	}
}
