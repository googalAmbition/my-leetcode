//给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。 
//
// 回文字符串 是正着读和倒过来读一样的字符串。 
//
// 子字符串 是字符串中的由连续字符组成的一个序列。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 
//输入：s = "aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由小写英文字母组成 
// 
//
// 👍 1296 👎 0

package leetcode.editor.cn;

public class PalindromicSubstrings {
    public static void main(String[] args) {
        Solution solution = new PalindromicSubstrings().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countSubstrings2(String s) {
            int ans = 0;
            int n = s.length();
            boolean[][] dp = new boolean[n][n];
            for (int j = 0; j < n; j++) {
                for (int i = 0; i <= j; i++) {
                    if (s.charAt(j) == s.charAt(i) && (j - i < 2 || dp[i + 1][j - 1])) {
                        dp[i][j] = true;
                        ans++;
                    }
                }
            }
            return ans;

        }

        public int countSubstrings(String s) {
            int max = 0;
            for (int i = 0; i < s.length(); i++) {
                max = Math.max(sub(s, i, i), max);
                max = Math.max(sub(s, i, i + 1), max);
            }
            return max;
        }

        int sub(String s, int start, int end) {
            while (start >= 0 && end < s.length()) {
                if (s.charAt(start) == s.charAt(end)) {
                    start--;
                    end++;
                } else {
                    break;
                }
            }
            return end - start + 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

} 
