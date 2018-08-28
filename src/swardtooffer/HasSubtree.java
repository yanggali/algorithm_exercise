package swardtooffer;

import java.util.ArrayDeque;
import java.util.Queue;

public class HasSubtree {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root2 == null || root1 == null){
            return false;
        }
        Queue<TreeNode> s = new ArrayDeque<>();
        s.add(root1);
        while (!s.isEmpty()){
            TreeNode t = ((ArrayDeque<TreeNode>) s).pop();
            if (t.val == root2.val){
                if (isMatched(t, root2))
                {
                    return true;
                }
            }
            if (t.left != null){
                s.add(t.left);
            }
            if (t.right != null){
                s.add(t.right);
            }
        }
        return false;

    }
    public boolean isMatched(TreeNode root1, TreeNode root2){
        if (root2 == null){
            return true;
        }
        else if (root1 == null){
            return false;
        }
        else {
            return root1.val == root2.val && isMatched(root1.left, root2.left) && isMatched(root1.right, root2.right);
        }
    }
}
