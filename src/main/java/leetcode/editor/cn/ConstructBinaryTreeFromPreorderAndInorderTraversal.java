//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。 
//
// 
//
// 示例 1: 
// 
// 
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均 无重复 元素 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
//
// 👍 2244 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

import leetcode.editor.cn.struct.TreeNode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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
        /**
         * 1.前序确定头
         * 2.中序确定左右
         * 3.中序+头确定左右个数
         */
        Map<Integer, Integer> num2indexMap = new HashMap<>();

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            for (int i = 0; i < inorder.length; i++) {
                num2indexMap.put(inorder[i], i);
            }
            return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length);
        }

        private TreeNode build(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
            if (preStart > preEnd) {
                return null;
            }

            TreeNode root = new TreeNode(preorder[preStart]);
            Integer index = num2indexMap.get(preorder[preStart]);
            int leftSize = index - inStart;

            root.left = build(preorder, inorder, preStart + 1, preStart + leftSize, inStart, index - 1);
            root.right = build(preorder, inorder, preStart + leftSize + 1, preEnd, index + 1, inEnd);

            return root;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

} 
