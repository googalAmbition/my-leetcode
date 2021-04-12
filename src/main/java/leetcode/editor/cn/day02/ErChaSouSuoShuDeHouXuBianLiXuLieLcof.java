//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。 
//
// 
//
// 参考以下这颗二叉搜索树： 
//
//      5
//    / \
//   2   6
//  / \
// 1   3 
//
// 示例 1： 
//
// 输入: [1,6,3,2,5]
//输出: false 
//
// 示例 2： 
//
// 输入: [1,3,2,6,5]
//输出: true 
//
// 
//
// 提示： 
//
// 
// 数组长度 <= 1000 
// 
// 👍 237 👎 0

// 二叉搜索树的后序遍历序列
package leetcode.editor.cn.day02;

public class ErChaSouSuoShuDeHouXuBianLiXuLieLcof {

    public static void main(String[] args) {
        Solution solution = new ErChaSouSuoShuDeHouXuBianLiXuLieLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean verifyPostorder(int[] postorder) {
            return recur(postorder, 0, postorder.length - 1);
        }
        // 输入: [1,3,2,6,5]

        boolean recur(int[] postorder, int start, int end) {
            if (start >= end) {
                return true;
            }
            int p = start;
            while (postorder[p] < postorder[end]) {
                p++;
            }
            int m = p;
            while (postorder[p] > postorder[end]) {
                p++;
            }
            return p == end && recur(postorder, start, m - 1) && recur(postorder, m, end - 1);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}