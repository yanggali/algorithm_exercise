package leetcode;

class ListNode {
   int val;
   ListNode next;
   ListNode(int x) { val = x; }
}

public class Add_Two_Numbers_2 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);

        ListNode l2 = new ListNode(5);

        Add_Two_Numbers_2 t = new Add_Two_Numbers_2();
        ListNode sum = t.addTwoNumbers(l1,l2);
        System.out.println(sum.val);
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode c1 = l1, c2 = l2;
        ListNode sentinel = new ListNode(0);
        int sum = c1.val + c2.val;
        ListNode d = new ListNode(sum % 10);
        sentinel.next = d;
        while (c1.next != null || c2.next != null){
            sum/=10;
            if (c1.next != null) {
                c1 = c1.next;
                sum += c1.val;
            }
            if (c2.next != null){
                c2 = c2.next;
                sum += c2.val;
            }
            d.next = new ListNode(sum % 10);
            d = d.next;
        }
        d.next = (sum / 10 == 0 ? null : new ListNode(sum/10));

        return sentinel.next;
    }
}
