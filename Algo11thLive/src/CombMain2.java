import java.io.*;
import java.util.*;

public class CombMain2 {
    static int N=4,R=3,C=0;
    static int[] a = {1,2,3,4}, b = new int[R];
    static boolean[] v = new boolean[N];
    static void subs(int cnt, String str) {
    	if(cnt==N) {
    		System.out.println(str); C++;
    		return;
    	}
    	subs(cnt+1, str+a[cnt]);
    	subs(cnt+1, str);
    }
    public static void main(String[] args) throws Exception {
    	C = 0;
    	subs(0,"");
    	System.out.println(C);
    }
}