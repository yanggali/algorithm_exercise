//package leetcode;
//
//import com.sun.xml.internal.org.jvnet.fastinfoset.sax.helpers.FastInfosetDefaultHandler;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class Most_Frequent_Subtree_Sum_508 {
//    public int[] findFrequentTreeSum(TreeNode root) {
//        Map<Integer, Integer> map = new HashMap<>();
//        if (root == null) return null;
//        findFrequentTreeSumHelper(map,root);
//    }
//    public int findFrequentTreeSumHelper(Map<Integer, Integer> map, TreeNode root){
//        if (root.left == null && root.right == null){
//            map.put(root.val, map.getOrDefault(root.val, 0) + 1);
//            return root.val;
//        }
//        else {
//            if (root.left != null){
//                int sum = findFrequentTreeSumHelper(map,root.left);
//                map.put(sum, map.getOrDefault(sum,0)+1);
//            }
//            if (root.right != null){
//
//            }
//        }
//    }
//}
