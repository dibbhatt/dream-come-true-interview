package algorithm.linkedlist;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(0);
        while (head != null) {
            ListNode curr = head;
            head = curr.next;
            curr.next = dummy.next;
            dummy.next = curr;
        }
        return dummy.next;
    }
}
