import java.io.*;
import java.util.*;

public class Algo1_서울_20반_신호준 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int c1 = Integer.parseInt(st.nextToken());
				int c2 = Integer.parseInt(st.nextToken());
				if(c1==X) {
					X = c2;
				} else if(c2==X) {
					X = c1;
				}
			}
			sb.append("#"+tc+" "+X+"\n");
		}
		System.out.println(sb);
		br.close();
	}
}
