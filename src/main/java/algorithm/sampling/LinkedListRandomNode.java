package algorithm.sampling;



/**
 * Description : Reservoir Sampling
 * Source : https://leetcode.com/problems/linked-list-random-node/
 * Created_By : xmpy
 * Time : Aug 14, 2016 1:17:22 PM  
 */
public class LinkedListRandomNode {
	 public class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	 }
    private ListNode head;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public LinkedListRandomNode(ListNode head) {
        this.head = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int r = head.val;
        int n = 1;
        ListNode curr = head.next;
        while(curr != null) {
            if ((int)(Math.random() * (n + 1)) == 0) {
                r = curr.val;
            }
            n += 1;
            curr = curr.next;
        }
        return r;
    }
}
