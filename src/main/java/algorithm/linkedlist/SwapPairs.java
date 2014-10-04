package algorithm.linkedlist;
/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-8-28 
 * Time : 上午12:08:34
 */
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
    	if(head == null){
    		return null;
    	}
        ListNode dummy = new ListNode(0);
        ListNode dst = dummy;
        ListNode p = head;
        
        while (p != null && p.next != null){
            ListNode next = p.next.next;
            dst.next = p.next;
            p.next.next = p;
            dst = p;
            p = next;
        }
        
        dst.next = p;
        return dummy.next;
    }
    
    
}
