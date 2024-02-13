package a0213.camp;

import java.io.*;
import java.util.*;
 
public class Solution_D3_6808_규영이와인영이의카드게임_서울_20반_신호준 {
	static int N=9, R=9;
	static int[] a, b;
	static boolean[] v;
	static List<Integer> Gyuyoung;
	static List<Integer> Inyoung;
	static int win, lose;
	static void perm(int cnt) {
		if(cnt==R) {
			int sum1 = 0;
			int sum2 = 0;
			for(int i=0; i<R; i++) {
				if(Gyuyoung.get(i)>b[i]) {
					sum1 += Gyuyoung.get(i)+b[i];
				} else {
					sum2 += Gyuyoung.get(i)+b[i];
				}
			}
			if(sum1>sum2) win++;
			else if(sum1<sum2) lose++;
			return;
		}
		for(int i=0; i<N; i++) {
			if(v[i]) continue;
			v[i] = true;
			b[cnt] = a[i];
			perm(cnt+1);
			v[i] = false;
		}
	}
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("res/input_d3_6808.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
        	a = new int[N];
        	b = new int[R];
        	v = new boolean[N];
        	Gyuyoung = new ArrayList<>();
        	Inyoung = new ArrayList<>();
        	win = 0;
        	lose = 0;
        	for(int i=1; i<=18; i++) {
        		Inyoung.add(i);
        	}
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        	for(int i=0; i<9; i++) {
        		Gyuyoung.add(Inyoung.remove(Inyoung.indexOf(Integer.parseInt(st.nextToken()))));
        	}
        	for(int i=0; i<9; i++) {
        		a[i] = Inyoung.get(i);
        	}
        	perm(0);
        	sb.append("#"+tc+" "+win+" "+lose+"\n");
        }
        System.out.println(sb);
        br.close();
    }
}
