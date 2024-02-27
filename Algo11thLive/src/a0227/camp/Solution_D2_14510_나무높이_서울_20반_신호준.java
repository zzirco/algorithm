package a0227.camp;

import java.io.*;
import java.util.*;

public class Solution_D2_14510_나무높이_서울_20반_신호준 {
	static int N, max;
	static int[] tree;
	static boolean Done() {
		for(int i=0; i<N; i++) {
			if(tree[i]!=max) return false;
		}
		return true;
	}
    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("res/input_d2_14510.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc=1; tc<=T; tc++) {
        	N = Integer.parseInt(br.readLine());
        	tree = new int[N];
        	int day = 0;
        	st = new StringTokenizer(br.readLine(), " ");
        	for(int i=0; i<N; i++) {
        		tree[i] = Integer.parseInt(st.nextToken());
        	}
        	Arrays.sort(tree);
        	max = tree[tree.length-1];
        	boolean is1 = true;
        	while(!Done()) {
        		for(int i=0; i<N; i++) {
        			if(is1) {
        				if(tree[i]!=max&&((max-tree[i])%2==1||(max-tree[i])>2)) {
        					tree[i]++;
        					break;
        				}
        			} else {
        				if(tree[i]!=max&&((max-tree[i])%2==0||(max-tree[i])>2)) {
        					tree[i] += 2;
        					break;
        				}
        			}
        		}
        		is1 = is1?false:true;
        		day++;
        	}
        	sb.append("#"+tc+" "+day+"\n");
        }
        System.out.println(sb);
    }
}
