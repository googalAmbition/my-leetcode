//编写一个方法，计算从 0 到 n (含 n) 中数字 2 出现的次数。 
//
// 示例: 
//
// 输入: 25
//输出: 9
//解释: (2, 12, 20, 21, 22, 23, 24, 25)(注意 22 应该算作两次) 
//
// 提示： 
//
// 
// n <= 10^9 
// 
// Related Topics 递归 数学 动态规划 
// 👍 40 👎 0

// 2出现的次数
package leetcode.editor.cn.day06;

public class NumberOf2sInRangeLcci {

    public static void main(String[] args) {
        Solution solution = new NumberOf2sInRangeLcci().new Solution();
        System.out.println(solution.numberOf2sInRange(25));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int numberOf2sInRange(int n) {
            int sum = 0, base = 1, left = 0;
            while (n != 0) {
                // 位置的值
                int val = n % 10;
                // 多少个位置
                n /= 10;
                //
                sum += base * n;
                if (val == 2) {
                    sum += left + 1;
                } else if (val > 2) {
                    sum += base;
                }
                left += base * val;
                base *= 10;
            }
            return sum;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}