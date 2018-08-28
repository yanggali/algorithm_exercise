package leetcode;

import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}

class Solution {
    /**
     * 求n叉树的高度
     * @param root
     * @return
     */
    public int maxDepth(Node root) {
        if(root == null){
            return 0;
        }
        int maxlen = 0;
        for (Node child : root.children) {
            maxlen = Math.max(maxDepth(child), maxlen);
        }
        return maxlen + 1;
    }

    /**
     * 求N叉树的后序遍历
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        getpostorder(root, list);
        return list;
    }

    public void getpostorder(Node root, ArrayList<Integer> list){
        for (Node child : root.children) {
            getpostorder(child, list);
        }
        list.add(root.val);
    }
}
