import java.io.*;
import java.util.*;

public class BinarySearchMain {
	static int[] ia = {3,11,15,20,21,29,45,59,65,72};
	public static void main(String[] args) {
		System.out.println(Arrays.toString(ia));
		System.out.println(binarysearch(65));
		System.out.println(binarysearch(3));
		System.out.println(binarysearch(2));
		System.out.println(binarysearch(46));
		System.out.println(binarysearch(72));
		System.out.println("============================");
		System.out.println(binarysearch2(65,0,ia.length-1));
		System.out.println(binarysearch2(3,0,ia.length-1));
		System.out.println(binarysearch2(2,0,ia.length-1));
		System.out.println(binarysearch2(46,0,ia.length-1));
		System.out.println(binarysearch2(72,0,ia.length-1));
		System.out.println("============================");
		System.out.println(Arrays.binarySearch(ia,65));
		System.out.println(Arrays.binarySearch(ia,3));
		System.out.println(Arrays.binarySearch(ia,2));
		System.out.println(Arrays.binarySearch(ia,46));
		System.out.println(Arrays.binarySearch(ia,72));
	}
	static int binarysearch(int key) {
		int start=0, end=ia.length-1;
		while(start<=end) {
			int mid=(start+end)/2;
			if(ia[mid]==key) return mid;
			else if(ia[mid]<key) start=mid+1;
			else end=mid-1;
		}
		return -1;
	}
	static int binarysearch2(int key, int start, int end) {
		while(start<=end) {
			int mid=(start+end)/2;
			if(ia[mid]==key) 		return mid;
			else if(ia[mid]<key) 	return binarysearch2(key, mid+1, end);
			else 					return binarysearch2(key, start, mid-1);
		}
		return -1;
	}
}
