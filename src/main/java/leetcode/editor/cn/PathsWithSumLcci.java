//给定一棵二叉树，其中每个节点都含有一个整数数值(该值或正或负)。设计一个算法，打印节点数值总和等于某个给定值的所有路径的数量。注意，路径不一定非得从二叉树的
//根节点或叶节点开始或结束，但是其方向必须向下(只能从父节点指向子节点方向)。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
// 
//
// 返回: 
//
// 3
//解释：和为 22 的路径有：[5,4,11,2], [5,8,4,5], [4,11,7] 
//
// 提示： 
//
// 
// 节点总数 <= 10000 
// 
// Related Topics 树 深度优先搜索 二叉树 
// 👍 79 👎 0

// 求和路径
package leetcode.editor.cn;

import leetcode.editor.cn.struct.TreeNode;

public class PathsWithSumLcci {

    public static void main(String[] args) {
        Solution solution = new PathsWithSumLcci().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    class Solution {

        int count = 0;

        public int pathSum(TreeNode root, int sum) {
            int depth = depth(root);
            int[] path = new int[depth];
            findSum(root, sum, path, 0);
            return count;
        }

        private void findSum(TreeNode node, int sum, int[] path, int level) {
            if (node == null) {
                return;
            }
            // 当前结点插入路径
            path[level] = node.val;
            // 查找以此为重点且总和为sum的路径
            int t = 0;
            for (int i = level; i >= 0; i--) {
                t += path[i];
                if (t == sum) {
                    count++;
                }
            }
            // 查找此结点之下的结点
            findSum(node.left, sum, path, level + 1);
            findSum(node.right, sum, path, level + 1);

            // 从路径中移除当前结点
            path[level] = Integer.MIN_VALUE;
        }

        //查找二叉树最大深度
        private int depth(TreeNode node) {
            if (node == null) {
                return 0;
            } else {
                return 1 + Math.max(depth(node.left), depth(node.right));
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}