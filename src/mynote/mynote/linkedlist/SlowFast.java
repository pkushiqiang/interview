package mynote.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class SlowFast {
	
	public static ListNode slowFast(ListNode head){
		ListNode slow = head , fast =head;
		while ( fast != null && fast.next != null ) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ListNode head;
		List<Integer> list = new ArrayList<>();
		for (int i=1; i<=10; i++) {
			list.add(i);
			head = ListNode.create(list);
			System.out.println(ListNode.printList(head));
			System.out.println(slowFast(head).val);
			System.out.println("----------------------");
		}
	}

}
