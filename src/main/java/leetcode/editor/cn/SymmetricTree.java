//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 1294 👎 0

package leetcode.editor.cn;

import leetcode.editor.cn.struct.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

    public static void main(String[] args) {
        Solution solution = new SymmetricTree().new Solution();
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
         * 广度优先
         */
        public boolean isSymmetric(TreeNode root) {
            return check(root, root);
        }

        public boolean check(TreeNode u, TreeNode v) {
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(u);
            q.offer(v);
            while (!q.isEmpty()) {
                u = q.poll();
                v = q.poll();
                if (u == null && v == null) {
                    continue;
                }
                if ((u == null || v == null) || (u.val != v.val)) {
                    return false;
                }

                q.offer(u.left);
                q.offer(v.right);

                q.offer(u.right);
                q.offer(v.left);
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    /**
     * 深度优先算法
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSame(root.left, root.right);
    }

    public boolean isSame(TreeNode left, TreeNode right) {
        if (left == right) {
            return true;
        }
        if (left != null && right != null && left.val == right.val) {
            return isSame(left.left, right.right) && isSame(left.right, right.left);
        }
        return false;
    }

    /**
     * 广度优先
     */
    public boolean isSymmetricV2(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> save = new LinkedList<>();
        Deque<TreeNode> validate = new LinkedList<>();
        save.addFirst(root.right);
        save.addFirst(root.left);
        while (!save.isEmpty()) {
            Deque<TreeNode> temp = save;
            save = validate;
            validate = temp;
            while (!validate.isEmpty()) {
                TreeNode right = validate.pollLast();
                TreeNode left = validate.pollFirst();
                if (right != null && left != null) {
                    if (right.val != left.val) {
                        return false;
                    }
                    save.offerFirst(left.right);
                    save.offerFirst(left.left);
                    save.offerLast(right.left);
                    save.offerLast(right.right);
                } else if (left != null || right != null) {
                    return false;
                }
            }
        }

        return true;
    }
}