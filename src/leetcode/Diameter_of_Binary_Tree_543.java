package leetcode;

public class Diameter_of_Binary_Tree_543 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        Diameter_of_Binary_Tree_543 d = new Diameter_of_Binary_Tree_543();
        d.diameterOfBinaryTree(node);
        System.out.println(d.max);
    }
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }
    public int depth(TreeNode root){
        if (root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);

        max = Math.max(max, left+right);

        return Math.max(left, right)+1;
    }
}
