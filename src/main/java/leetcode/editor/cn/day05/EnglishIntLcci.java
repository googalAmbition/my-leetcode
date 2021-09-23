//给定一个整数，打印该整数的英文描述。 
//
// 示例 1: 
//
// 
//输入: 123
//输出: "One Hundred Twenty Three"
// 
//
// 示例 2: 
//
// 
//输入: 12345
//输出: "Twelve Thousand Three Hundred Forty Five" 
//
// 示例 3: 
//
// 
//输入: 1234567
//输出: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven" 
//
// 示例 4: 
//
// 
//输入: 1234567891
//输出: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thou
//sand Eight Hundred Ninety One" 
//
// 注意：本题与 273 题相同：https://leetcode-cn.com/problems/integer-to-english-words/ 
// Related Topics 递归 数学 字符串 
// 👍 16 👎 0

// 整数的英语表示
package leetcode.editor.cn.day05;

public class EnglishIntLcci {

    public static void main(String[] args) {
        Solution solution = new EnglishIntLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private final String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
            "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        private final String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty",
            "Sixty", "Seventy", "Eighty", "Ninety"};

        public String numberToWords(int num) {
            //这里的0返回Zero
            if (num == 0) {
                return "Zero";
            }
            StringBuilder sb = new StringBuilder();

            if (num / 1_000_000_000 > 0) {
                sb.append(ones[num / 1_000_000_000]);
                sb.append(" ").append("Billion");
                num %= 1_000_000_000;
            }
            if (num / 1_000_000 > 0) {
                buildThree(num / 1_000_000, sb);
                sb.append(" ").append("Million");
                num %= 1_000_000;
            }
            if (num / 1_000 > 0) {
                buildThree(num / 1_000, sb);
                sb.append(" ").append("Thousand");
                num %= 1_000;
            }
            if (num > 0) {
                // 取个位（百、十、个）
                buildThree(num, sb);
            }

            return sb.toString();
        }

        public void buildThree(int num, StringBuilder sb) {
            if (num / 100 > 0) {
                if (sb.length() > 0) {
                    sb.append(" ");
                }
                sb.append(ones[num / 100]);
                sb.append(" ").append("Hundred");
                //只在三位数对100取余
                num = num % 100;
            }
            //这里的0不返回Zero
            if (num == 0) {
                return;
            }
            //[1, 20)查表
            //[20, 99]拼接
            if (num < 20) {
                if (sb.length() > 0) {
                    sb.append(" ");
                }
                sb.append(ones[num]);
            } else {
                // [20, 99] 的情况，需要十位 + 个位分别转换字符串
                if (sb.length() > 0) {
                    sb.append(" ");
                }
                // 十位转换
                sb.append(tens[num / 10]);
                num = num % 10;
                if (num > 0) {
                    if (sb.length() > 0) {
                        sb.append(" ");
                    }
                    // 个位转换
                    sb.append(ones[num]);
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}