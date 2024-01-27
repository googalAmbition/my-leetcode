//从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
//
// 注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-tra
//versal/ 
// Related Topics 树 广度优先搜索 
// 👍 92 👎 0

// 从上到下打印二叉树 II
package leetcode.editor.cn;

import leetcode.editor.cn.struct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CongShangDaoXiaDaYinErChaShuIiLcof {

    public static void main(String[] args) {
        Solution solution = new CongShangDaoXiaDaYinErChaShuIiLcof().new Solution();
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

        public List<List<Integer>> levelOrder(TreeNode root) {

            Queue<TreeNode> first = new LinkedList<>();
            Queue<TreeNode> second = new LinkedList<>();

            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            first.add(root);

            while (!first.isEmpty() || !second.isEmpty()) {
                if (first.isEmpty()) {
                    first = second;
                    second = new LinkedList<>();
                } else {
                    List<Integer> line = new ArrayList<>();
                    while (!first.isEmpty()) {
                        TreeNode poll = first.poll();
                        if (poll != null) {
                            line.add(poll.val);
                            second.add(poll.left);
                            second.add(poll.right);
                        }
                    }
                    if (line.size() > 0) {
                        result.add(line);
                    }
                }
            }

            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}