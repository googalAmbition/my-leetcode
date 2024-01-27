//给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aaabb", k = 3
//输出：3
//解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
// 
//
// 示例 2： 
//
// 
//输入：s = "ababbc", k = 2
//输出：5
//解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由小写英文字母组成 
// 1 <= k <= 105 
// 
// Related Topics 递归 分治算法 Sliding Window 
// 👍 464 👎 0

// 至少有 K 个重复字符的最长子串
package leetcode.editor.cn;

public class LongestSubstringWithAtLeastKRepeatingCharacters {

    public static void main(String[] args) {
        Solution solution = new LongestSubstringWithAtLeastKRepeatingCharacters().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 分支算法
     */
    class Solution {

        public int longestSubstring(String s, int k) {
            int n = s.length();
            return dfs(s, 0, n - 1, k);
        }

        public int dfs(String s, int l, int r, int k) {
            int[] cnt = new int[26];
            for (int i = l; i <= r; i++) {
                cnt[s.charAt(i) - 'a']++;
            }

            char split = 0;
            for (int i = 0; i < 26; i++) {
                if (cnt[i] > 0 && cnt[i] < k) {
                    split = (char) (i + 'a');
                    break;
                }
            }
            if (split == 0) {
                return r - l + 1;
            }

            int i = l;
            int ret = 0;
            while (i <= r) {
                while (i <= r && s.charAt(i) == split) {
                    i++;
                }
                if (i > r) {
                    break;
                }
                int start = i;
                while (i <= r && s.charAt(i) != split) {
                    i++;
                }

                int length = dfs(s, start, i - 1, k);
                ret = Math.max(ret, length);
            }
            return ret;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    /**
     * 滑动窗口
     */
    public int longestSubstring(String s, int k) {
        int ret = 0;
        int n = s.length();
        for (int t = 1; t <= 26; t++) {
            int l = 0, r = 0;
            int[] cnt = new int[26];
            int tot = 0;
            int less = 0;
            while (r < n) {
                cnt[s.charAt(r) - 'a']++;
                if (cnt[s.charAt(r) - 'a'] == 1) {
                    tot++;
                    less++;
                }
                if (cnt[s.charAt(r) - 'a'] == k) {
                    less--;
                }

                while (tot > t) {
                    cnt[s.charAt(l) - 'a']--;
                    if (cnt[s.charAt(l) - 'a'] == k - 1) {
                        less++;
                    }
                    if (cnt[s.charAt(l) - 'a'] == 0) {
                        tot--;
                        less--;
                    }
                    l++;
                }
                if (less == 0) {
                    ret = Math.max(ret, r - l + 1);
                }
                r++;
            }
        }
        return ret;
    }
}