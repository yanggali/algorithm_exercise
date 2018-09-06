package leetcode;

public class Intersection_of_Two_Linked_Lists_160 {
    public static void main(String[] args) {
        Intersection_of_Two_Linked_Lists_160 i = new Intersection_of_Two_Linked_Lists_160();
        ListNode a = new ListNode(2);
        a.next = new ListNode(3);
        ListNode b = new ListNode(4);
        b.next = new ListNode(3);
        System.out.println(i.getIntersectionNode(a, b) != null);
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int l1 = 0, l2 = 0;
        ListNode t1 = headA, t2 = headB;
        while (t1 != null){
            l1++;
            t1 = t1.next;
        }
        while (t2 != null){
            l2++;
            t2 = t2.next;
        }
        int i = 0;
        t1 = headA;
        t2 = headB;
        if (l1 > l2) {
            while (i < l1 - l2) {
                t1 = t1.next;
                i++;
            }
        } else{
            while (i < l2 - l1) {
                t2 = t2.next;
                i++;
            }
        }
        while (t1 != null){
            if (t1.val == t2.val && t1.next == t2.next){
                return t1;
            }
            else {
                t1 = t1.next;
                t2 = t2.next;
            }
        }
        return null;
    }
}
