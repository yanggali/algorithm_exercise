package leetcode;

import java.util.List;

public class Palindrome_Linked_List_234 {
    public static void main(String[] args) {
        Palindrome_Linked_List_234 p = new Palindrome_Linked_List_234();
        ListNode head = null;
        System.out.println(p.isPalindrome(head));
    }
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode fast = head,slow = head;
        while (fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        slow = reverse(slow);
        fast = head;
        while (slow != null){
            if (fast.val != slow.val){
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        while (head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
