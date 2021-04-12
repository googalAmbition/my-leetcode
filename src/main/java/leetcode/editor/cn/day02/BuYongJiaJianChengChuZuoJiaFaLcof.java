//写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。 
//
// 
//
// 示例: 
//
// 输入: a = 1, b = 1
//输出: 2 
//
// 
//
// 提示： 
//
// 
// a, b 均可能是负数或 0 
// 结果不会溢出 32 位整数 
// 
// 👍 139 👎 0

// 不用加减乘除做加法
package leetcode.editor.cn.day02;

public class BuYongJiaJianChengChuZuoJiaFaLcof {

    public static void main(String[] args) {
        Solution solution = new BuYongJiaJianChengChuZuoJiaFaLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int add(int a, int b) {
            // a看作sum，b看作carry
            while (b != 0) {
                // 数电的全加器，result = 不进位加法的和(亦或) + 进位。当进位为0，result返回
                int carry = (a & b) << 1;
                a = a ^ b;
                b = carry;
            }
            return a;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}