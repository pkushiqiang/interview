package mynote.linkedlist;

public class ReorderList {
	
	public static void reorderList(ListNode head) {
        if( head == null || head.next == null || head.next.next == null )
            return ;
            
        ListNode slow = head, fast = head;
        while ( fast!=null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode p = slow.next;
        ListNode np = p.next;
        slow.next = null;
        p.next = null;
        while ( np!= null ){
            ListNode nnp = np.next;
            np.next = p;            
            p = np;
            np = nnp;
        }
        
        ListNode p1 = head;
        ListNode node = null;
        while ( p != null ) {
            node = p;
            p = p.next;
            node.next = p1.next;
            p1.next = node;
            p1 = node.next;
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	int[] nums = {1,2,3,4,5};
		int[] nums = {1,2,3,4,5,6,7};
		ListNode head = ListNode.create(nums);
		reorderList(head);
		
		System.out.println(ListNode.printList(head));
	}

}
