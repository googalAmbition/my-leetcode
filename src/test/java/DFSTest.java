import java.util.ArrayList;
import java.util.List;

import leetcode.editor.cn.struct.TreeNode;

/**
 * @author chentiancheng@kuaishou.com
 * Created on 2024-02-29
 */
public class DFSTest {


    public static void main(String[] args) {
        Solution solution = new DFSTest().
                new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        solution.inorderTraversal(root);
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        List<Integer> ans = new ArrayList<>();

        List<Integer> sum = new ArrayList<>();

        public List<Integer> inorderTraversal(TreeNode root) {
            dfsv2(root, 0);
            System.out.println(sum);
            return ans;
        }

        void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            System.out.println("before:" + root.left);
            dfs(root.left);
            System.out.println("mind:" + root);
            ans.add(root.val);
            dfs(root.right);
            System.out.println("aftewr:" + root.right);
        }

        int dfsv2(TreeNode root, int s) {
            int su = 0;
            if (root == null) {
                return 0;
            }
            int e = s + root.val;
            su += root.val;
            su += dfsv2(root.left, e);

            dfsv2(root.right, e);
            return e;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)


}
