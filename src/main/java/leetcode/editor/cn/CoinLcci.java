//硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007) 
//
// 示例1: 
//
// 
// 输入: n = 5
// 输出：2
// 解释: 有两种方式可以凑成总金额:
//5=5
//5=1+1+1+1+1
// 
//
// 示例2: 
//
// 
// 输入: n = 10
// 输出：4
// 解释: 有四种方式可以凑成总金额:
//10=10
//10=5+5
//10=5+1+1+1+1+1
//10=1+1+1+1+1+1+1+1+1+1
// 
//
// 说明： 
//
// 注意: 
//
// 你可以假设： 
//
// 
// 0 <= n (总金额) <= 1000000 
// 
// Related Topics 数组 数学 动态规划 
// 👍 215 👎 0

// 硬币
package leetcode.editor.cn;

public class CoinLcci {

    public static void main(String[] args) {
        Solution solution = new CoinLcci().new Solution();
        solution.waysToChange(100);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private static final int MOD = 1000000007;
        private final int[] coins = {25, 10, 5, 1};

        public int waysToChange(int n) {
            int[] f = new int[n + 1];
            f[0] = 1;
            for (int c = 0; c < 4; ++c) {
                int coin = coins[c];
                for (int i = coin; i <= n; ++i) {
                    f[i] = (f[i] + f[i - coin]) % MOD;
                }
            }
            return f[n];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}