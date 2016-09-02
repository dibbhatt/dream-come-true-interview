package algorithm.linkedlist;

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null) {
            if (head.val == val) {
                head = head.next;
            } else {
                break;
            }
        }
        
        if (head == null) {
            return null;
        }
        
        ListNode pre = head;
        ListNode p = head.next;
        while (p != null) {
            if (p.val == val) {
                pre.next = p.next;
            }else {
                pre = p;
                p = pre.next;
            }
        }
        return head;
    }
}
