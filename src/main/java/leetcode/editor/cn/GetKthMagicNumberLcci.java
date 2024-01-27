//有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，
//5，7，9，15，21。 
//
// 示例 1: 
//
// 输入: k = 5
//
//输出: 9
// 
// Related Topics 哈希表 数学 动态规划 堆（优先队列） 
// 👍 69 👎 0

// 第 k 个数
package leetcode.editor.cn;

public class GetKthMagicNumberLcci {

    public static void main(String[] args) {
        Solution solution = new GetKthMagicNumberLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int getKthMagicNumber(int k) {
            int[] dp = new int[k];
            int p1 = 0, p2 = 0, p3 = 0;
            dp[0] = 1;
            for (int i = 1; i < k; i++) {
                int v1 = dp[p1] * 3, v2 = dp[p2] * 5, v3 = dp[p3] * 7;
                dp[i] = Math.min(v1, Math.min(v2, v3));
                if (dp[i] == v1) {
                    p1++;
                }
                if (dp[i] == v2) {
                    p2++;
                }
                if (dp[i] == v3) {
                    p3++;//步进+去重
                }
            }
            return dp[k - 1];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}