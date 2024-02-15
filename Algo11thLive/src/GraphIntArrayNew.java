import java.io.*;
import java.util.*;

public class GraphIntArrayNew {
	public static void main(String[] args) throws Exception {
		// 메모리 2048 기준
		//int[] ia=new int[1_052_246_012];
		//int[] ia=new int[1_052_246_013];
		int[][] ia=new int[32_122][32_122];
		//int[][] ia=new int[32_123][32_123];
		System.out.println(ia);
		Runtime.getRuntime().gc();
		long usedMemory=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
		System.out.println(usedMemory+" bytes");
		System.out.println(usedMemory/1024.0+" Kbytes");
		System.out.println(usedMemory/1024.0/1024.0+" Mbytes");
		System.out.println(usedMemory/1024.0/1024.0/1024.0+" Gbytes");
	}
}
