package No2;

import java.util.*;

class UserSolution {
	static int n, l;
	static TreeSet<Node> node;
	static class Node implements Comparable<Node> {
		int league;
		int id;
		int ability;
		public Node(int league, int id, int ability) {
			super();
			this.league = league;
			this.id = id;
			this.ability = ability;
		}
		@Override
		public String toString() {
			return "Node [league=" + league + ", id=" + id + ", ability=" + ability + "]";
		}
		@Override
		public int compareTo(Node o) {
			if(this.league==o.league) {
				if(this.ability==o.ability) {
					return Integer.compare(this.id, o.id);
				}
				return Integer.compare(o.ability, this.ability);
			}
			return Integer.compare(this.league, o.league);
		}
	}
    void init(int N, int L, int mAbility[]) {
    	n = N;
    	l = L;
    	node = new TreeSet<>();
    	for(int i=0; i<N; i++) {
    		if(i==0) node.add(new Node(0, i, mAbility[i]));
    		else node.add(new Node(i/(N/L), i, mAbility[i]));
    	}
    }
    int move() {
    	//Collections.sort(node);
    	int num = l-1;
    	int lcnt = n/l;
    	int sum = 0;
    	for(int i=1; i<=num; i++) {
    		Iterator<Node> it = node.iterator();
    		for(int j=0; j<lcnt*i-1; j++) it.next();
    		Node tmp = it.next();
    		int l1 = node.get(lcnt*i-1).league;
    		int l2 = node.get(lcnt*i).league;
    		node.set(lcnt*i-1, node.get(lcnt*i));
    		node.set(lcnt*i,tmp);
    		node.get(lcnt*i-1).league = l1;
    		node.get(lcnt*i).league = l2;
    		sum += node.get(lcnt*i-1).id+node.get(lcnt*i).id;
    	}
        return sum;
    }
    int trade() {
    	//Collections.sort(node);
    	int num = l-1;
    	int lcnt = n/l;
    	int mcnt = (lcnt+1)/2;
    	int sum = 0;
    	for(int i=0; i<num; i++) {
    		Node tmp = node.get(mcnt+i*lcnt-1);
    		int l1 = node.get(mcnt+i*lcnt-1).league;
    		int l2 = node.get(lcnt*(i+1)).league;
    		node.set(mcnt+i*lcnt-1, node.get(lcnt*(i+1)));
    		node.set(lcnt*(i+1), tmp);
    		node.get(mcnt+i*lcnt-1).league = l1;
    		node.get(lcnt*(i+1)).league = l2;
    		sum += node.get(mcnt+i*lcnt-1).id+node.get(lcnt*(i+1)).id;
    	}
        return sum;
    }
}