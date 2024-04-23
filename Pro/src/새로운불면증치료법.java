import java.io.*;
import java.util.*;

public class 새로운불면증치료법 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int x = 0;
			int idx = 1;
			while(true) {
				int tmp = idx*N;
				while(tmp>0) {
					x |= (1<<tmp%10);
					tmp /= 10;
				}
				if(x==(1<<10)-1) break;
				idx++;
			}
			sb.append("#"+tc+" "+idx*N+"\n");
		}
		System.out.println(sb);
		br.close();
	}
}
