//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 2.00000, n = 10
//输出：1024.00000
// 
//
// 示例 2： 
//
// 
//输入：x = 2.10000, n = 3
//输出：9.26100 
//
// 示例 3： 
//
// 
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2-2 = 1/22 = 1/4 = 0.25 
//
// 
//
// 提示： 
//
// 
// -100.0 < x < 100.0 
// -231 <= n <= 231-1 
// -104 <= xn <= 104 
// 
//
// 
//
// 注意：本题与主站 50 题相同：https://leetcode-cn.com/problems/powx-n/ 
// Related Topics 递归 
// 👍 139 👎 0

// 数值的整数次方
package leetcode.editor.cn;

public class ShuZhiDeZhengShuCiFangLcof {

    public static void main(String[] args) {
        Solution solution = new ShuZhiDeZhengShuCiFangLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public double myPow(double x, int n) {
            if (x == 0) {
                return 0;
            }
            long b = n;
            double res = 1.0;
            if (b < 0) {
                x = 1 / x;
                b = -b;
            }
            while (b > 0) {
                if ((b & 1) == 1) {
                    res *= x;
                }
                x *= x;
                b >>= 1;
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}