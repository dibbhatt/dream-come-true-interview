package algorithm.linkedlist;

import java.util.Arrays;
import java.util.List;

public class PalindromeLinkedList {
    public List<ListNode> split(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(fast !=null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // This Arrays.asList function is very useful. It can be used to represent a pair, 
        // so you do not need to write you own Pair class any more.
        return Arrays.asList(head, slow.next);
    }
    
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
    
    public boolean isPalindrome(ListNode head) {
        List<ListNode> heads = split(head);
        if (heads == null) {
            return true;
        }
        ListNode head2 = reverse(heads.get(1));
        while (head2 != null) {
            if (head.val != head2.val) {
                return false;
            }
            head = head.next;
            head2 = head2.next;
        }
        return true;
    }
}
