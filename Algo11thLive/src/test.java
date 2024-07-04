import java.io.*;
import java.util.*;

public class test {
    static int N;
    static int[] arr;
    static int[] cmp = new int[2];
    static int max = Integer.MIN_VALUE;
    static void comb(int cnt, int start) {
        if(cnt==2) {
            int mul = cmp[0] * cmp[1];
            max = Math.max(max, mul);
            return;
        }
        for(int i=start; i<N; i++) {
            cmp[cnt] = arr[i];
            comb(cnt+1, i+1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for(int i=0; i<N; i++) {
            arr[i] = sc.nextInt();
        }
        comb(0,0);
        System.out.println(max);
    }
}
