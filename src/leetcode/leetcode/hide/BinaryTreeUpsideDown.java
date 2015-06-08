package leetcode.hide;

/*
 * Given a binary tree where all the right nodes are either 
 * leaf nodes with a sibling (a left node that shares the 
 * same parent node) or empty, flip it upside down and turn
 * it into a tree where the original right nodes turned into
 * left leaf nodes. Return the new root.
    For example:
	Given a binary tree {1,2,3,4,5},
	
	
	For example:
	Given a binary tree {1,2,3,4,5},
	 1
	/ \
   2   3
  / \
 4   5
	
 return the root of the binary tree [4,5,2,#,#,3,1].

   4
  / \
 5   2
    / \
   3   1
   
   ----------------
   
	   	 1
		/ \
	   2   3
	  / \
	 4   5
    / \
   6   7
   
   	 6
    / \
   7   4
	  / \
	 5   2
	    / \
	   3   1
   
 * 
 */

import mynote.binarytree.TreeNode;
import mynote.binarytree.TreeUtil;

import java.util.*;
public class BinaryTreeUpsideDown {
	
	 public static TreeNode UpsideDownBinaryTree_o1(TreeNode root) {
		if (root == null)
			return null;
		ArrayList<TreeNode> res = new ArrayList<TreeNode>();
		res.add(null);
		helper(root, res);
		return res.get(0);
	}
		      
	public static TreeNode helper(TreeNode root, ArrayList<TreeNode> res) {
		if (root.left == null) {
			res.set(0, root);
			return root;
		}
		TreeNode newRoot = helper(root.left, res);
		newRoot.left = root.right;
		newRoot.right = root;
		root.left = null;
		root.right = null;
		return newRoot.right;
	}
	
	public static TreeNode upsideDownBinaryTree5(TreeNode root) {
		TreeNode left = root.left, right = root.right;
		root.left = null;
		root.right = null;
		while (left != null) {			
			TreeNode newLeft = left.left;
			TreeNode  newRight = left.right;
			left.left = right;
			left.right = root;			
			root = left;
			left = newLeft;
			right = newRight;
		}
		return root;
	}
	
	public static TreeNode upsideDownBinaryTree4(TreeNode root) {
			
			Stack<TreeNode[]> stack = new Stack<>();
			while (root.left != null ){
				TreeNode[] two = {root, root.right};
				stack.add(two);
				root= root.left;
				two[0].left =null;
				two[0].right = null;
			}
			TreeNode p = root;
			while ( !stack.isEmpty()){
				TreeNode[] two = stack.pop();
				p.left = two[1];
				p.right = two[0];
				p= p.right;
			}
			return root;
	}

	public static TreeNode upsideDownBinaryTree3(TreeNode root) {
		
		Stack<TreeNode> stack = new Stack<>();
		TreeNode p = root;
		while(p.left !=null ) {
			stack.push(p);
			p =p.left;
		}
		TreeNode newroot = p;
		while ( !stack.isEmpty()){
			TreeNode node = stack.pop();
			p.left = node.right;
			p.right = node;
			node.left = null;
			node.right = null;
			p = node;
		}
		return newroot;
	}
	
	private static TreeNode root2 = null;
	
	public static TreeNode upsideDownBinaryTree2(TreeNode root) {
		recur2(root);
		return root2;
	}
	
	public static TreeNode recur2(TreeNode root) {
		 if ( root.left == null ){
			 root2 = root;
			 return root;
		 } else {
			 TreeNode node = recur2(root.left);
			 node.left = root.right;
			 node.right = root;
			 root.left = null;
			 root.right = null;
			 return root;
		 }
	}
	
	
	 
	public static TreeNode upsideDownBinaryTree1(TreeNode root) {
		 return flip( root)[0];
	}
	
	public static TreeNode[] flip(TreeNode root){
		if (root.left == null ){
			TreeNode[]  res = {root, root};
			return res;
		}
		
		TreeNode[]  res = flip(root.left);
		res[1].left = root.right;
		res[1].right = root;
		res[1] = root;
		root.left = null;
		root.right = null;
		return res;
	}
	
	public static void test1(){
		
		String str1 = "{1,2,3,4,5}";
		
		TreeNode root = TreeUtil.deSerialize(str1);
		root = upsideDownBinaryTree1(root);
		System.out.println( TreeUtil.serialize(root) );
				
		root = TreeUtil.deSerialize(str1);
		root = upsideDownBinaryTree2(root);
		System.out.println( TreeUtil.serialize(root) );
				
		root = TreeUtil.deSerialize(str1);
		root = upsideDownBinaryTree3(root);
		System.out.println( TreeUtil.serialize(root) );
				
		root = TreeUtil.deSerialize(str1);
		root = upsideDownBinaryTree4(root);
		System.out.println( TreeUtil.serialize(root) );
		
		root = TreeUtil.deSerialize(str1);
		root = upsideDownBinaryTree5(root);
		System.out.println( TreeUtil.serialize(root) );
				
		root = TreeUtil.deSerialize(str1);
		root = UpsideDownBinaryTree_o1(root);
		System.out.println( TreeUtil.serialize(root) );
	}
	
public static void test2(){
		
		String str1 = "{1,2,3,4,5,#,#,6,7}";
		TreeNode root = TreeUtil.deSerialize(str1);
		root = upsideDownBinaryTree1(root);
		System.out.println( TreeUtil.serialize(root) );
		
		
		root = TreeUtil.deSerialize(str1);
		root = upsideDownBinaryTree2(root);
		System.out.println( TreeUtil.serialize(root) );
		
		
		root = TreeUtil.deSerialize(str1);
		root = upsideDownBinaryTree3(root);
		System.out.println( TreeUtil.serialize(root) );
		
		
		root = TreeUtil.deSerialize(str1);
		root = upsideDownBinaryTree4(root);
		System.out.println( TreeUtil.serialize(root) );
		
		root = TreeUtil.deSerialize(str1);
		root = upsideDownBinaryTree5(root);
		System.out.println( TreeUtil.serialize(root) );
		
		root = TreeUtil.deSerialize(str1);
		root = UpsideDownBinaryTree_o1(root);
		System.out.println( TreeUtil.serialize(root) );
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test1();
		test2();
	}

}
