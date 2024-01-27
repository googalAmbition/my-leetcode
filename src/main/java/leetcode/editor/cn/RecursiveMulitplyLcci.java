//递归乘法。 写一个递归函数，不使用 * 运算符， 实现两个正整数的相乘。可以使用加号、减号、位移，但要吝啬一些。 
//
// 示例1: 
//
// 
// 输入：A = 1, B = 10
// 输出：10
// 
//
// 示例2: 
//
// 
// 输入：A = 3, B = 4
// 输出：12
// 
//
// 提示: 
//
// 
// 保证乘法范围不会溢出 
// 
// Related Topics 位运算 递归 数学 
// 👍 44 👎 0

// 递归乘法
package leetcode.editor.cn;

public class RecursiveMulitplyLcci {

    public static void main(String[] args) {
        Solution solution = new RecursiveMulitplyLcci().new Solution();
        System.out.println(solution.multiply(3, 5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int multiply(int A, int B) {
            if (A == 0 || B == 0) {
                return 0;
            }
            int re = 0;
            int i = 0;
            while (B > 0) {
                if ((B & 1) == 1) {
                    re = re + (A << i);
                }
                B >>= 1;
                i++;
            }
            return re;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}