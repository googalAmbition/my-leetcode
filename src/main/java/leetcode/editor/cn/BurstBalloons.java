//有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。 
//
// 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。 这里的 i -
// 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。 
//
// 求所能获得硬币的最大数量。 
//
// 
//示例 1：
//
// 
//输入：nums = [3,1,5,8]
//输出：167
//解释：
//nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
//coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167 
//
// 示例 2： 
//
// 
//输入：nums = [1,5]
//输出：10
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 300 
// 0 <= nums[i] <= 100 
// 
//
// Related Topics 数组 动态规划 👍 1439 👎 0

package leetcode.editor.cn;

import java.util.Arrays;

public class BurstBalloons {
    public static void main(String[] args) {
        Solution solution = new BurstBalloons().new Solution();
    }


    /**
     * dp版本代码，最外层的循环，i为什么是n-1 -> 0，而不能反过来？
     * (i,j) 0 1  2   3   4   ...   n-2   n-1   n   n+1
     * 0     0 1  2   3   4   ...                   n+1
     * 1       1  2   3   4   ...                   n+1
     * 2          2   3   4   ...                   n+1
     * 3              3   4   ...                   n+1
     * 4                  4                         n+1
     * .                      .                     .
     * .                         .                  .
     * n-2                          n-2   n-1   n   n+1
     * n-1                                n-1   n   n+1
     * n+1
     *
     * 须从下往上算，即先算dp[n-1][n+1]：
     * 根据递推关系，算dp[i][j]时依赖的dp[i][k]和dp[k][j]，其中i<k<j。
     * 1、如果从上往下计算，依赖的dp[k][j]根本就还未算出（k比i大），比如算dp[0][3]时，依赖的dp[1][3]还是个未知数。
     * 2、从下往上就不一样，算dp[i][j]时，依赖的dp[i][k]，位于同一行左侧，已计算过；
     *                                    依赖的dp[k][j]，因为k>i，位于更下面的行，也已计算过。
     */

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public int[][] rec;
        public int[] val;

        // 记忆搜索
        public int maxCoins(int[] nums) {
            int n = nums.length;
            val = new int[n + 2];
            for (int i = 1; i <= n; i++) {
                val[i] = nums[i - 1];
            }
            val[0] = val[n + 1] = 1;
            rec = new int[n + 2][n + 2];
            for (int i = 0; i <= n + 1; i++) {
                Arrays.fill(rec[i], -1);
            }
            return solve(0, n + 1);
        }

        public int solve(int left, int right) {
            if (left >= right - 1) {
                return 0;
            }
            if (rec[left][right] != -1) {
                return rec[left][right];
            }
            for (int i = left + 1; i < right; i++) {
                int sum = val[left] * val[i] * val[right];
                sum += solve(left, i) + solve(i, right);
                rec[left][right] = Math.max(rec[left][right], sum);
            }
            return rec[left][right];
        }


        // 动态规划


        public int maxCoins1(int[] nums) {

            int n = nums.length;
            int[][] rec = new int[n + 2][n + 2];

            int[] val = new int[n + 2];
            val[0] = val[n + 1] = 1;

            for (int i = 1; i <= n; i++) {
                val[i] = nums[i - 1];
            }

            for (int row = n - 1; row >= 0; row--) {
                for (int col = row + 2; col <= n + 1; col++) {
                    for (int vIndex = row + 1; vIndex < col; vIndex++) {
                        int sum = val[row] * val[vIndex] * val[col];
                        sum += rec[row][vIndex] + rec[vIndex][col];
                        rec[row][col] = Math.max(rec[row][col], sum);
                    }
                }
            }
            return rec[0][n + 1];
        }


    }
    //leetcode submit region end(Prohibit modification and deletion)

} 
