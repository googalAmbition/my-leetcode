//二进制数转字符串。给定一个介于0和1之间的实数（如0.72），类型为double，打印它的二进制表达式。如果该数字无法精确地用32位以内的二进制表示，则打印
//“ERROR”。 
//
// 示例1: 
//
// 
// 输入：0.625
// 输出："0.101"
// 
//
// 示例2: 
//
// 
// 输入：0.1
// 输出："ERROR"
// 提示：0.1无法被二进制准确表示
// 
//
// 提示： 
//
// 
// 32位包括输出中的"0."这两位。 
// 
// Related Topics 位运算 数学 字符串 
// 👍 24 👎 0

// 二进制数转字符串
package leetcode.editor.cn.day05;

public class BianryNumberToStringLcci {

    public static void main(String[] args) {
        Solution solution = new BianryNumberToStringLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String printBin(double num) {
            StringBuilder sb = new StringBuilder("0.");
            double cur = 1;
            for (int i = 0; i < 32 && num > 0; i++) {
                cur /= 2;
                if (num >= cur) {
                    num -= cur;
                    sb.append(1);
                }// 对应位添加1
                else { sb.append(0); }// 对应位添加0
            }
            // 只有当num == 0的时候才说明表示成功了
            return num == 0 ? sb.toString() : "ERROR";
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}