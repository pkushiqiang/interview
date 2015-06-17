package mynote.java.iterator;

import java.util.*;

class Node implements Iterable<Integer> {
	Node left, right, next;
	int val;	

	public Node(int value) {
		this.val = value;
	}

	public void add(int value) {
		if (value < this.val) {
			if (this.left == null) {
				this.left = new Node(value);
			} else {
				this.left.add(value);
			}
		} else {
			if (this.right == null) {
				this.right = new Node(value);
			} else {
				this.right.add(value);
			}
		}
	}

	@Override
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		return new TreeIterator(this);
	}
	
	class TreeIterator implements Iterator<Integer> {
		Stack<Node> stack;
		private void pushLeft(Node root ){
			Node head = root;
			while (head != null){
				stack.push(head);
				head = head.left;
			}
		}
		
		public TreeIterator( Node root ){
			this.stack = new Stack<Node>();
			this.pushLeft(root);			
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return !stack.isEmpty();
		}

		@Override
		public Integer next() {
			// TODO Auto-generated method stub
			Node top = stack.pop();
			if (top.right != null)
				pushLeft(top.right);
			return top.val;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}
}

public class BinaryTree {

	public static Node buildTree(int[] A) {
		Node root = new Node(A[0]);
		for (int i = 1; i < A.length; i++) {
			root.add(A[i]);
		}
		return root;
	}

	public static void preOrder(Node root, List<Integer> list) {
		if (root == null)
			return;
		preOrder(root.left, list);
		list.add(root.val);
		preOrder(root.right, list);
	}

	public static Node[] preOrderLink(Node root) {

		Node[] nodes = new Node[2];
		nodes[0] = root;
		nodes[1] = root;

		if (root.left != null) {
			Node[] leftNodes = preOrderLink(root.left);
			leftNodes[1].next = root;
			nodes[0] = leftNodes[0];
		}

		if (root.right != null) {
			Node[] rightNodes = preOrderLink(root.right);
			root.next = rightNodes[0];
			nodes[1] = rightNodes[1];
		}
		return nodes;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = { 5, 6, 3, 9, 0, 7, 11, 23, 3, 2 };

		Node root = buildTree(A);
		List<Integer> list = new ArrayList<Integer>();
		preOrder(root, list);
		for (Integer i : list) {
			System.out.print(i + ", ");
		}
		System.out.println();
		Node[] nodes = preOrderLink(root);
		Node head = nodes[0];
		while (head != null) {
			System.out.print(head.val + ", ");
			head = head.next;
		}
		System.out.println();
		Iterator<Integer> iterator = root.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + ", ");
		}
		
		System.out.println();
	}

}
