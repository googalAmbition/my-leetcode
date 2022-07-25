//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。 
//
// 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。 
//
// 
//
// 示例 1： 
//
// 
//输入：num1 = "11", num2 = "123"
//输出："134"
// 
//
// 示例 2： 
//
// 
//输入：num1 = "456", num2 = "77"
//输出："533"
// 
//
// 示例 3： 
//
// 
//输入：num1 = "0", num2 = "0"
//输出："0"
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 10⁴ 
// num1 和num2 都只包含数字 0-9 
// num1 和num2 都不包含任何前导零 
// 
// Related Topics 数学 字符串 模拟 👍 590 👎 0

// 字符串相加
package leetcode.editor.cn;

public class AddStrings {

    public static void main(String[] args) {
        Solution solution = new AddStrings().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String addStrings(String num1, String num2) {
            StringBuilder sb = new StringBuilder();
            int l1 = num1.length() - 1, l2 = num2.length() - 1;
            int flag = 0;
            while (l1 >= 0 || l2 >= 0) {
                Integer s1 = 0;
                Integer s2 = 0;
                if (l1 >= 0) {
                    s1 = Integer.valueOf(num1.charAt(l1) + "");
                }
                if (l2 >= 0) {
                    s2 = Integer.valueOf(num2.charAt(l2) + "");
                }
                int sum = s1 + s2 + flag;
                if (sum > 9) {
                    flag = 1;
                    sb.append(sum % 10);
                } else {
                    flag = 0;
                    sb.append(sum);
                }
                l1--;
                l2--;
            }
            if (flag == 1) {
                sb.append(1);
            }
            return sb.reverse().toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}