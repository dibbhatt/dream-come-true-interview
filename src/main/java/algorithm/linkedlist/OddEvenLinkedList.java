package algorithm.linkedlist;

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = new ListNode(0);
        ListNode oddP = oddHead;
        ListNode evenHead = new ListNode(0);
        ListNode evenP = evenHead;
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        
        while(odd != null && even != null) {
            ListNode currOdd = odd;
            ListNode currEven = even;
            odd = currEven.next;
            even = (currEven.next == null) ? null : currEven.next.next;
            oddP.next = currOdd;
            oddP = currOdd;
            evenP.next = currEven;
            evenP = currEven;
        }
        
        if (odd != null) {
            oddP.next = odd;
            oddP = odd;
        }
        evenP.next = null;
        oddP.next = evenHead.next;
        return oddHead.next;
    }
}
