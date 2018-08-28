package swardtooffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class ListNode{
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}

public class ReverseList {
    //利用栈
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<ListNode> nodeStack = new Stack<>();
        while (listNode != null){
            nodeStack.push(listNode);
            listNode = listNode.next;
        }
        ArrayList<Integer> reverseList = new ArrayList<>();
        while (!nodeStack.empty())
        {
            reverseList.add(nodeStack.pop().val);
        }
        return reverseList;
    }
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> reverseList = new ArrayList<>();
        if (listNode == null) return reverseList;
        ListNode head = listNode, follow = null;
        while (head.next != null){
            ListNode next = head.next;
            head.next = follow;
            follow = head;
            head = next;
        }

        while (head != null){
            reverseList.add(head.val);
        }
        return reverseList;
    }
}
