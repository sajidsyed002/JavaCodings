package problems;

public class DeleteNodeLinkedList {

	public static void main(String[] args) {
		// [1,3,4,7,1,2,6]

	}
	public ListNode deleteMiddle(ListNode head) {
        ListNode sp = head, fp = head, bef = null;
        while(fp != null && fp.next != null){
            bef = sp;
            sp = sp.next;
            fp = fp.next.next;
        }
        if(bef == null)
          return null;
        bef.next = sp.next;
        return head;
    }

}
   class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 

