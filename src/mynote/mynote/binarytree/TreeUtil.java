package mynote.binarytree;


import java.util.*;

public class TreeUtil {
	
	public static TreeNode deSerialize(String str) {
		if (str == null || str.length()<3)
			return null;
		str = str.substring(1, str.length()-1);
		String[] strs = str.split(",");
		String val = strs[0];
		if (val.equals("#"))
			return null;
		TreeNode root = new TreeNode(Integer.valueOf(val));
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int i =1;
		while (i<strs.length ){
			
			TreeNode node = queue.poll();
			val = strs[i++];
			if ( !val.equals("#")  ){
				TreeNode left = new TreeNode(Integer.valueOf(val) );
				node.left = left;
				queue.add(left);
			}			
			val = strs[i++];
			if ( !val.equals("#")  ){
				TreeNode right = new TreeNode(Integer.valueOf(val) );
				node.right = right;
				queue.add(right);
			}
		}
		return root;
	}

	public static String serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		Queue<TreeNode> queue = new LinkedList<>();

		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (node == null) {
					sb.append("#,");
				} else {
					sb.append(node.val+",");
					queue.add(node.left);
					queue.add(node.right);
				}
			}
		}
		int i=sb.length()-2;
		while( sb.charAt(i) == '#' )
			i-=2;		
		sb.setLength(i+1);
		sb.append("}");
		return sb.toString();
	}
	
	public static String preOrder(TreeNode root){
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		preOrder(root,sb);
		sb.setLength(sb.length()-1);
		sb.append("}");
		return sb.toString();
	}
	
	private static void preOrder(TreeNode root, StringBuilder sb ){
		if (root == null)
			return;
		sb.append(root.val+",");
		preOrder(root.left,sb);
		preOrder(root.right,sb);
	}
	
	public static String inOrder(TreeNode root){
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		inOrder(root,sb);
		sb.setLength(sb.length()-1);
		sb.append("}");
		return sb.toString();
	}
	
	private static void inOrder(TreeNode root, StringBuilder sb ){
		if (root == null)
			return;		
		inOrder(root.left,sb);
		sb.append(root.val+",");
		inOrder(root.right,sb);
	}
	
	public static String postOrder(TreeNode root){
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		postOrder(root,sb);
		sb.setLength(sb.length()-1);
		sb.append("}");
		return sb.toString();
	}
	
	private static void postOrder(TreeNode root, StringBuilder sb ){
		if (root == null)
			return;		
		postOrder(root.left,sb);		
		postOrder(root.right,sb);
		sb.append(root.val+",");
	}
	
	 
	
	public static String levelOrder(TreeNode root){
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()){
			int len = queue.size();			
			for (int i=0; i<len ; i++){
				TreeNode node = queue.poll();
				sb.append(node.val+",");
				if( node.left != null )
					queue.add(node.left);
				if (node.right != null )
					queue.add(node.right);
			}
		}
	 
		sb.setLength(sb.length()-1);
		sb.append("}");
		return sb.toString();
	}
	
	public static void  test1(){
		String str1 = "{1,2,3,#,#,4,#,#,5}";
		TreeNode root = deSerialize(str1);
		String str2 = serialize(root);
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(preOrder(root));
		System.out.println(inOrder(root));
		System.out.println(postOrder(root));
		System.out.println(levelOrder(root));
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test1();
	}

}
