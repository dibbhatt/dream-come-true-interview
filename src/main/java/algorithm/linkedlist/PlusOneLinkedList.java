package algorithm.linkedlist;

public class PlusOneLinkedList {
    public ListNode reverse(ListNode head) {
        ListNode pre = head;
        ListNode p = pre.next;
        while(p != null) {
            ListNode next = p.next;
            p.next = pre;
            pre = p;
            p = next;
        }
        head.next = null;
        return pre;
    }
    
    public ListNode plusOne(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode reversed = reverse(head);
        ListNode p = reversed;
        while(p != null) {
            if (p.val != 9) {
                p.val += 1;
                break;
            } 
            p.val = 0;
            p = p.next;
        }
        if (p == null) {
            ListNode rhead = new ListNode(1);
            rhead.next = reverse(reversed);
            return rhead;
        }
        
        return reverse(reversed);
    }
}
