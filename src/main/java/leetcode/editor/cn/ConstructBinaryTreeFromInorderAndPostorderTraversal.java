//给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并
//返回这颗 二叉树 。 
//
// 
//
// 示例 1: 
// 
// 
//输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//输出：[3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入：inorder = [-1], postorder = [-1]
//输出：[-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= inorder.length <= 3000 
// postorder.length == inorder.length 
// -3000 <= inorder[i], postorder[i] <= 3000 
// inorder 和 postorder 都由 不同 的值组成 
// postorder 中每一个值都在 inorder 中 
// inorder 保证是树的中序遍历 
// postorder 保证是树的后序遍历 
// 
//
// 👍 1201 👎 0

package leetcode.editor.cn;

import java.util.HashMap;

import leetcode.editor.cn.struct.TreeNode;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
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
        HashMap<Integer, Integer> memo = new HashMap<>();
        int[] post;

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            for (int i = 0; i < inorder.length; i++) {
                memo.put(inorder[i], i);
            }
            post = postorder;
            TreeNode root = buildTree(0, inorder.length - 1, 0, post.length - 1);
            return root;
        }

        public TreeNode buildTree(int is, int ie, int ps, int pe) {
            if (ie < is || pe < ps) {
                return null;
            }

            int root = post[pe];
            int ri = memo.get(root);

            TreeNode node = new TreeNode(root);
            node.left = buildTree(is, ri - 1, ps, ps + ri - is - 1);
            node.right = buildTree(ri + 1, ie, ps + ri - is, pe - 1);
            // node.right = buildTree(ri + 1, ie, pe - ri + is, pe - 1);
            return node;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


}
