package algorithm.linkedlist;

import org.junit.Test;

/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-9-9 
 * Time : 上午12:57:41
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        ListNode p = head;
        ListNode pre = dummy;
        while (p != null) {
            ListNode last = p;
            for (int i = 1; i < k; i++) {
                if (last == null){
                    break;
                }
                last = last.next;
            }
            if (last == null) {
                pre.next = p;
                break;
            }
            ListNode nextPre = p;
            for (int i = 0; i < k; i++) {
            	//System.out.println(i + " " + p.val);
                ListNode nextP = p.next;
                p.next = pre.next;
                pre.next = p;
                p = nextP;
            }
            pre = nextPre;
        }
        //head.next = p;
        return dummy.next;
    }
    
    @Test
    public void test(){
    	ListNode head = new ListNode(0);
    	head.next = new ListNode(1);
    	head.next.next = new ListNode(2);
    	head.next.next.next = new ListNode(3);
    	head.next.next.next.next = new ListNode(4);
    	
    	ListNode result = reverseKGroup(head, 2);
    	ListNode p = result;
    	for (int i = 0; i < 5; i++) {
    		System.out.println(p.val);
    		p = p.next;
    	}
    }
}
