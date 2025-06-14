//对于一个 正整数，如果它和除了它自身以外的所有 正因子 之和相等，我们称它为 「完美数」。 
//
// 给定一个 整数 n， 如果是完美数，返回 true；否则返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：num = 28
//输出：true
//解释：28 = 1 + 2 + 4 + 7 + 14
//1, 2, 4, 7, 和 14 是 28 的所有正因子。 
//
// 示例 2： 
//
// 
//输入：num = 7
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num <= 10⁸ 
// 
//
// Related Topics 数学 👍 181 👎 0

// 完美数
package leetcode.editor.cn;

public class PerfectNumber {

    public static void main(String[] args) {
        Solution solution = new PerfectNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean checkPerfectNumber(int num) {
            if (num == 1) {
                return false;
            }
            int sum = 0;
            for (int i = 1; i <= num / 2; i++) {
                if (num % i == 0) {
                    sum += i;
                }
            }
            return sum == num;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}