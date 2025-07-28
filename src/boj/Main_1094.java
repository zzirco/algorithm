package boj;

import java.io.*;
import java.util.*;

public class Main_1094 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        list.add(64);
        while(true) {
            int sum = 0;
            for(int i:list) {
                sum += i;
            }
            Collections.sort(list);
            if(sum > X) {
                if((sum-list.get(0)/2)<X) list.add(list.get(0)/2);
                list.set(0, list.get(0)/2);
            }
            else break;
        }
        System.out.println(list.size());
    }
}
