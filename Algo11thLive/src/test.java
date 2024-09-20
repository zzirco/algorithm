import java.io.*;
import java.util.*;

public class test {
	static class Node {
		int x;
		int y;
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + "]";
		}
		
	}
    public static void main(String[] args) {
    	int x = 0, y = 0;
    	int index = 5;
    	Node[] n = new Node[index];
    	for(int i=0; i<index; i++) {
    		n[i] = new Node(i,i);
    	}
		System.out.println(Arrays.toString(n));
    }
}
