package algorithm.linkedlist;

 class RandomListNode {
     int label;
     RandomListNode next, random;
     RandomListNode(int x) { this.label = x; }
 };
/** 
 * Created_By : zhaoxm (xmpy) 
 * Date : 2014-7-26 
 * Time : 下午5:23:34
 */
public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode p = head;
        while (p != null){
            RandomListNode pnext = p.next;
            p.next = new RandomListNode(p.label);
            p.next.next = pnext;
            p = p.next.next;
        }
        
        p = head;
        
        while(p != null){
            p.next.random = p.random.next;
            p = p.next.next;
        }
        
        p = head;
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode tail = dummy;
        while(p != null){
            tail.next = p.next;
            p.next = p.next.next;
            p = p.next;
            tail = tail.next;
        }
        return dummy.next;
    }
}
