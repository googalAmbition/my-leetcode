//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 10⁵] 内 
// -1000 <= Node.val <= 1000 
// 
//
// 👍 1156 👎 0

package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Queue;

import leetcode.editor.cn.struct.TreeNode;

public class MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new MinimumDepthOfBinaryTree().new Solution();
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
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            int deep = 1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode poll = queue.poll();
                    if (poll.left == null && poll.right == null) {
                        return deep;
                    }
                    if (poll.left != null) {
                        queue.offer(poll.left);
                    }
                    if (poll.right != null) {
                        queue.offer(poll.right);
                    }

                }
                deep++;

            }

            return deep;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

} 
