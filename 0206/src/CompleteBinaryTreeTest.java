
public class CompleteBinaryTreeTest {
	public static void main(String[] args) {
		
		CompleteBinaryTree<Character> tree = new CompleteBinaryTree<>(10);
		for(int i=0; i<10; i++) {
			tree.add((char)(65+i));
		}
		
		//tree.bfs();
//		tree.bfs2();
//		tree.bfs3();
		tree.dfsByPreorder();
		tree.dfsByInorder();
		tree.dfsByPostorder();
	}
}

// 너비를 고려한 출력을 고민해보자
