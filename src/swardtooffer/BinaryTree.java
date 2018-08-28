package swardtooffer;

import java.net.Inet4Address;
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    TreeNode(int x) { val = x; }
}


public class BinaryTree {
    /**
     * 找和最大的一层
     */
    public int findMaxLevel(TreeNode root){
        if (root == null){
            return 0;
        }
        int maxlevel = 0,level = 0,maxsum = 0, currentsum = 0;
        Queue<TreeNode> q = new ArrayDeque<>();
        TreeNode temp;
        q.add(root);
        q.add(new TreeNode(-1));
        while (!q.isEmpty()){
            temp = ((ArrayDeque<TreeNode>) q).pop();
            if (temp.val == -1){
                if (currentsum > maxsum){
                    maxsum = currentsum;
                    maxlevel = level;
                }
                currentsum = 0;
                if (!q.isEmpty()){
                    q.add(new TreeNode(-1));
                }
                level++;
            }
            else {
                currentsum += temp.val;
                if (temp.left != null){
                    q.add(temp.left);
                }
                if (temp.right != null){
                    q.add(temp.right);
                }
            }
        }
        return maxlevel;
    }
    public static int diameterlen = 0;
    public static int diameter(TreeNode root, int len){
        if (root == null){
            return 0;
        }
        int left = diameter(root.left,diameterlen);
        int right = diameter(root.right, diameterlen);
        diameterlen = left+right > diameterlen ? left+right:diameterlen;
        return Math.max(left, right) +1;
    }

    public static int maxsum = 0;
    public static void getlongest(TreeNode root, int currentsum){
        if (root == null){
            return;
        }
        currentsum += root.val;
        if (root.left == null && root.right == null){
            maxsum = Math.max(maxsum, currentsum);
        }
        else {
            getlongest(root.left, currentsum);
            getlongest(root.right, currentsum);
        }
    }
    /**
     * 输出二叉树所有路径
     * @param root
     */
    public void print(TreeNode root){
        int[] path = new int[256];
        printallpaths(root, path, 0);
    }
    public void printallpaths(TreeNode root, int[] path, int pathlen){
        if (root == null){
            return;
        }
        path[pathlen] = root.val;
        pathlen++;
        if (root.left == null && root.right == null){
            printarray(path, pathlen);
        }
        else {
            printallpaths(root.left, path, pathlen);
            printallpaths(root.right, path, pathlen);
        }
    }
    public void printarray(int[] path, int pathlen){
        for (int i = 0; i < pathlen;i++){
            System.out.print(path[i]+" ");
        }
        System.out.println();
    }

    /**
     * 重建二叉树
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return reConstructBinaryTree(pre,0, pre.length-1,in, 0, in.length-1);
    }

    public TreeNode reConstructBinaryTree(int[] pre, int preS, int preE, int[] in, int inS, int inE) {
        if (preE < preS || inE < inS){
            return null;
        }
        int root = pre[preS];
        for (int i = inS; i <= inE;i++){
            if (in[i] == root){
                TreeNode rootnode = new TreeNode(root);
                rootnode.left = reConstructBinaryTree(pre, preS+1, preS+i-inS, in, inS, i-1);
                rootnode.right = reConstructBinaryTree(pre, preS + i - inS + 1, preE, in , i+1, inE);
                return rootnode;
            }
        }
        return null;
    }

    /**
     * 后序遍历二叉树， 非递归
     * @param root
     */
    public void AfterNon(TreeNode root){
        if (root == null){
            return;
        }
        Stack<TreeNode> s = new Stack<>();
        TreeNode lastvisted = new TreeNode();
        while (root != null || !s.isEmpty()){
            if (root != null){
                s.push(root);
                root = root.left;
            }
            else {
                TreeNode t = s.peek();
                if (t.right != null && t.right != lastvisted)
                {
                    root = t.right;
                }
                else {
                    System.out.println(t.val);
                    lastvisted = t;
                    s.pop();
                }
            }
        }
    }

    /**
     * 宽度优先遍历（队列）
     * @param root
     */
    public void width(TreeNode root){
        if (root == null){
            return;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()){
            TreeNode walk = ((ArrayDeque<TreeNode>) q).pop();
            System.out.println(walk.val);
            if (walk.left != null){
                q.add(walk.left);
            }
            if (walk.right != null){
                q.add(walk.right);
            }
        }
    }

    /**
     * 深度优先遍历（栈）
     * @param root
     */
    public void depth(TreeNode root){
        if (root == null){
            return;
        }
        Stack<TreeNode> s= new Stack<>();
        s.add(root);
        while (!s.isEmpty()){
            TreeNode walk = s.pop();
            System.out.println(walk.val);
            if (walk.right != null){
                s.push(walk.right);
            }
            if (walk.left != null){
                s.push(walk.left);
            }
        }
    }

    /**
     * 二叉树的镜像
     * @param root
     */
    public void Mirror(TreeNode root) {
        if (root == null){
            return;
        }
        if (root.left == null && root.right == null){
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left != null){
            Mirror(root.left);
        }
        if (root.right != null){
            Mirror(root.right);
        }
    }

    /**
     * 判断数组是否是二叉搜索树的后序遍历结果
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length <= 0) return false;
        return issequenceofbst(sequence, 0, sequence.length-1);
    }
    public boolean issequenceofbst(int[] sequence, int start, int end){
        if (start >= end){
            return false;
        }
        int root = sequence[end];
        int mid = end;
        for (int i = start; i < end;i++){
            if (sequence[i] > root){
                mid = i;
                break;
            }
        }
        boolean issequence = true;
        for (int j = mid; j < end;j++){
            if (sequence[j] < root){
                issequence = false;
                break;
            }
        }
        return issequence && issequenceofbst(sequence, start, mid-1) && issequenceofbst(sequence, mid,end-1);
    }
    /**
     * 从下往上打印二叉树
     * @param root
     * @return
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        Stack<TreeNode> s = new Stack<>();
        q.add(root);
        while (!q.isEmpty()){
            TreeNode temp = ((ArrayDeque<TreeNode>) q).pop();
            if (temp.right != null){
                q.add(temp.right);
            }
            if (temp.left != null){
                q.add(temp.left);
            }
            s.add(temp);
        }
        while (!s.isEmpty()){
            list.add(s.pop().val);
        }
        return list;
    }

    /**
     * 打印出二叉树中结点值的和为输入整数的所有路径
     * @param root
     * @param target
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int[] path = new int[255];
        int currentsum = 0;
        findpathequaltarget(root, list,currentsum,path,0,target);
        return list;
    }

    public void findpathequaltarget(TreeNode root, ArrayList<ArrayList<Integer>> list, int currentsum, int[] path, int pathlen, int target) {
        if (root == null) return;
        path[pathlen] = root.val;
        pathlen++;
        currentsum += root.val;
        if (root.left == null && root.right == null) {
            if (currentsum == target) {
                list.add(getlist(path, pathlen));
            }
        } else {
            findpathequaltarget(root.left, list, currentsum, path, pathlen, target);
            findpathequaltarget(root.right, list, currentsum, path, pathlen, target);
        }
    }
    public ArrayList<Integer> getlist(int[] path, int end){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0;i < end;i++){
            list.add(path[i]);
        }
        return list;
    }

    /**
     * 求树的最长路径
     * @param root
     * @return
     */
    public int TreeDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        return left > right ? left + 1:right+1;
    }

    /**
     * 求二叉树的中序遍历
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }
        inorder(root, list);
        return list;
    }
    public void inorder(TreeNode root, ArrayList<Integer> list){
        if (root == null) return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }

    /**
     * 判断是否为平衡二叉树
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null){
            return true;
        }
        int lefth = getheight(root.left);
        int righth = getheight(root.right);
        if (Math.abs(lefth - righth) > 1){
            return false;
        }
        else {
            return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
        }
    }
    public int getheight(TreeNode root){
        if (root == null){
            return 0;
        }
        return Math.max(getheight(root.left), getheight(root.right))+1;
    }

    public static void main(String[] args) {
        int[] pre = {1,2,4,8,9,5,3,6,7};
        int[] in = {8,4,9,2,5,1,6,3,7};
        int[] temparray = {4,8,6,12,16,14,10};
        BinaryTree temp = new BinaryTree();
        TreeNode root = temp.reConstructBinaryTree(pre, in);
        ArrayList<ArrayList<Integer>> list = temp.FindPath(root, 16);
        System.out.println(list.size());
    }
}
