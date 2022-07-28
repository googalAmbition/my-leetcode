//给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。 
//
// 
//
// 示例 1: 
//
// 
//输入: num = 100
//输出: "202"
// 
//
// 示例 2: 
//
// 
//输入: num = -7
//输出: "-10"
// 
//
// 
//
// 提示： 
//
// 
// -10⁷ <= num <= 10⁷ 
// 
//
// Related Topics 数学 👍 186 👎 0

// 七进制数
package leetcode.editor.cn;

public class Base7 {

    public static void main(String[] args) {
        Solution solution = new Base7().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String convertToBase7(int num) {
            if (num==0){
                return "0";
            }
            String flag = num < 0 ? "-" : "";
            num = Math.abs(num);
            StringBuilder sb = new StringBuilder();
            while (num > 0) {
                int d = num%7;
                sb.append(d);
                num/=7;
            }
            sb.append(flag);
            return sb.reverse().toString();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}