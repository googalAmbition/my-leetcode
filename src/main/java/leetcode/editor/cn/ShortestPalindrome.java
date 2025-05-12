//给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aacecaaa"
//输出："aaacecaaa"
// 
//
// 示例 2： 
//
// 
//输入：s = "abcd"
//输出："dcbabcd"
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 仅由小写英文字母组成 
// 
//
// Related Topics 字符串 字符串匹配 哈希函数 滚动哈希 👍 621 👎 0

package leetcode.editor.cn;

public class ShortestPalindrome {
    public static void main(String[] args) {
        Solution solution = new ShortestPalindrome().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String shortestPalindrome(String s) {
            int n = s.length();
            int base = 131, mod = 1000000007;
            int left = 0, right = 0, mul = 1;
            int best = -1;
            for (int i = 0; i < n; ++i) {
                left = (int) (((long) left * base + s.charAt(i)) % mod);
                right = (int) ((right + (long) mul * s.charAt(i)) % mod);
                if (left == right) {
                    best = i;
                }
                mul = (int) ((long) mul * base % mod);
            }
            String add = (best == n - 1 ? "" : s.substring(best + 1));
            StringBuffer ans = new StringBuffer(add).reverse();
            ans.append(s);
            return ans.toString();


        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

} 
