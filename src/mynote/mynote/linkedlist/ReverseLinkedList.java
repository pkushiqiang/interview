package mynote.linkedlist;

public class ReverseLinkedList {
	
	public static  ListNode reverseList(ListNode head) {
        if ( head == null || head.next == null )
            return head;
            
        ListNode np = head.next;
        head.next = null;
        // most important statement
        while ( np!= null ){
            ListNode nnp = np.next;
            np.next = head;
            head = np;
            np = nnp;
        }
        return head;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4,5,6,7};
		ListNode head = ListNode.create(nums);
		head = reverseList(head);
		
		System.out.println(ListNode.printList(head));
	}

}
