package mynote.linkedlist;
import java.util.*;
public class ListNode {

	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
	}
	
	public static ListNode create(int[] nums){
		ListNode head = new ListNode(nums[0]);
		ListNode p = head; 
		for ( int i=1; i<nums.length ; i++) {
			ListNode node = new ListNode(nums[i]);
			p.next = node;
			p = node;
		}
		return head;
	}
	
	public static ListNode create(List<Integer> list){
		ListNode head = new ListNode(list.get(0));
		ListNode p = head; 
		for ( int i=1; i<list.size() ; i++) {
			ListNode node = new ListNode(list.get(i));
			p.next = node;
			p = node;
		}
		return head;
	}
	
	public static String printList(ListNode head) {
		ListNode p = head;
		StringBuilder sb = new StringBuilder();		
		
		while ( p!= null) {
			sb.append(p.val);
			sb.append(" -> ");
			p = p.next;
		}
		sb.setLength(sb.length() - 4);
		return sb.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4,5};
		ListNode head = create(nums);
		System.out.println(printList(head));
		
		List<Integer> list = new ArrayList<>();
		for (int i=1; i<=10; i++) {
			list.add(i);
			head = create(list);
			System.out.println(printList(head));
		}
	}

}
