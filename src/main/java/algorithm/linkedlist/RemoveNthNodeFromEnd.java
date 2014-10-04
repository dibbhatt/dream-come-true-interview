package algorithm.linkedlist;
/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-8-16 
 * Time : 下午5:24:42
 */
public class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode p = head;
        ListNode p2 = head;
        for (int i = 0; i < n; i++){
            p2 = p2.next;
        }
        
        while (p2 != null){
            pre = pre.next; 
            p = p.next;
            p2 = p2.next;
        }
        
        pre.next = p.next;
        return dummy.next;
    }
}
