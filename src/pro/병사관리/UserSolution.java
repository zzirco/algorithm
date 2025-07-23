package pro.병사관리;

class UserSolution
{
	public class Node {
		int id;
		int v;
		Node nxt;
		
		Node() {}
		
		Node(int id, int v) {
			this.id = id;
			this.v = v;
			this.nxt = null;
		}
		
		Node(int id, int v, Node nxt) {
			this.id = id;
			this.v = v;
			this.nxt = nxt;
		}
	}
	
	public Node[] node = new Node[200055];
	int cnt = 0;
	public int[] version = new int[100055];
	public int[] num = new int[100055];
	
	public Node getNewNode(int id, Node nxt) {
		Node ret = node[cnt++];
		ret.id = id;
		ret.nxt = nxt;
		ret.v = ++version[id];
		return ret;
	}
	
	public class Team {
		Node[] head = new Node[6];
		Node[] tail = new Node[6];
	}
	
	public Team[] t = new Team[6];

    public void init() {
    	cnt = 0;
    	for(int i=0; i<200055; i++) {
    		node[i] = new Node();
    	}
    	for(int i=1; i<=5; i++) {
    		t[i] = new Team();
    		for(int j=1; j<=5; j++) {
    			t[i].head[j] = t[i].tail[j] = getNewNode(0, null);
    		}
    	}
    	for(int i=1; i<=100000; i++) {
    		version[i] = 0;
    		num[i] = 0;
    	}
    }

    public void hire(int mID, int mTeam, int mScore) {  // O(1)
    	Node newNode = getNewNode(mID, null);
    	t[mTeam].tail[mScore].nxt = newNode;
    	t[mTeam].tail[mScore] = newNode;
    	num[mID] = mTeam;
    }

    public void fire(int mID) {  // O(1)
    	version[mID] = -1;
    }

    public void updateSoldier(int mID, int mScore) {  // O(1)
    	hire(mID, num[mID], mScore);
    }

    public void updateTeam(int mTeam, int mChangeScore) {  // O(1)
    	if(mChangeScore < 0) {
    		for(int i=1; i<=5; i++) {
    			int k = i + mChangeScore;
    			k = k < 1 ? 1 : (k > 5 ? 5 : k);
    			if(i==k) continue;
    			
    			if(t[mTeam].head[i].nxt==null) continue;
    			t[mTeam].tail[k].nxt = t[mTeam].head[i].nxt;
    			t[mTeam].tail[k] = t[mTeam].tail[i];
    			t[mTeam].head[i].nxt = null;
    			t[mTeam].tail[i] = t[mTeam].head[i];
    		}
    	}
    	if(mChangeScore > 0) {
    		for(int i=5; i>=1; i--) {
    			int k = i + mChangeScore;
    			k = k < 1 ? 1 : (k > 5 ? 5 : k);
    			if(i==k) continue;
    			
    			if(t[mTeam].head[i].nxt==null) continue;
    			t[mTeam].tail[k].nxt = t[mTeam].head[i].nxt;
    			t[mTeam].tail[k] = t[mTeam].tail[i];
    			t[mTeam].head[i].nxt = null;
    			t[mTeam].tail[i] = t[mTeam].head[i];
    		}
    	}
    }

    public int bestSoldier(int mTeam) {  // O(N)
    	for(int i=5; i>=1; i--) {
    		Node node = t[mTeam].head[i].nxt;
    		if(node==null) continue;
    		
    		int ans = 0;
    		while(node!=null) {
    			if(node.v==version[node.id]) {
    				ans = ans < node.id ? node.id : ans;
    			}
    			node = node.nxt;
    		}
    		if(ans!=0) return ans;
    	}
    	return 0;
    }
}