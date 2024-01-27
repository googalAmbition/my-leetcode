//堆箱子。给你一堆n个箱子，箱子宽 wi、深 di、高 hi。箱子不能翻转，将箱子堆起来时，下面箱子的宽度、高度和深度必须大于上面的箱子。实现一种方法，搭出最
//高的一堆箱子。箱堆的高度为每个箱子高度的总和。 
//
// 输入使用数组[wi, di, hi]表示每个箱子。 
//
// 示例1: 
//
//  输入：box = [[1, 1, 1], [2, 2, 2], [3, 3, 3]]
// 输出：6
// 
//
// 示例2: 
//
//  输入：box = [[1, 1, 1], [2, 3, 4], [2, 6, 7], [3, 4, 5]]
// 输出：10
// 
//
// 提示: 
//
// 
// 箱子的数目不大于3000个。 
// 
// Related Topics 数组 动态规划 排序 
// 👍 46 👎 0

// 堆箱子
package leetcode.editor.cn;

import java.util.Arrays;

public class PileBoxLcci {

    public static void main(String[] args) {
        Solution solution = new PileBoxLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int pileBox(int[][] box) {
            Arrays.sort(box, (a, b) -> {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                } else {
                    return b[1] - a[1];
                }
            });
            int m = box.length;
            int max = 0;
            int[] dp = new int[m + 1];
            for (int i = 1; i < m + 1; i++) {
                dp[i] = box[i - 1][2];
                for (int j = 1; j < m + 1; j++) {
                    if (box[j - 1][1] < box[i - 1][1] && box[j - 1][2] < box[i - 1][2]) {
                        dp[i] = Math.max(dp[i], dp[j] + box[i - 1][2]);
                    }
                }
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}