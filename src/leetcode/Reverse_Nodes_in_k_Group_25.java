package leetcode;

public class Reverse_Nodes_in_k_Group_25 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        ListNode node = ListNode.array2list(arr);
        Reverse_Nodes_in_k_Group_25 r = new Reverse_Nodes_in_k_Group_25();
        ListNode reverseknode = r.reverseKGroup(node,2);
        System.out.println(reverseknode.val);
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null) return head;
        ListNode prev = head;
        int count = 0;
        while (count < k && prev!= null){
            prev = prev.next;
            count++;
        }
        if (count!= k){
            return head;
        }
        else {
            count = 0;
            prev = reverseKGroup(prev, k);
            ListNode node = head;
            while (count < k){
                ListNode next = node.next;
                node.next = prev;
                prev = node;
                node = next;
                count++;
            }
            return prev;
        }
    }
}
