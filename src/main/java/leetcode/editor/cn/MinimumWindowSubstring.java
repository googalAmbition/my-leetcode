//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 105 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 1109 👎 0

// 最小覆盖子串
package leetcode.editor.cn;

import java.util.HashMap;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public String minWindow(String s, String t) {
            HashMap<Character, Integer> need = new HashMap<>();
            HashMap<Character, Integer> window = new HashMap<>();
            int tLen = t.length();//目标字符串
            int sLen = s.length();
            if (tLen == 0 || sLen == 0) {
                return "";
            }

            //先把t中的字符放到need表中，计数
            for (int i = 0; i < tLen; i++) {
                char c = t.charAt(i);
                need.put(c, need.getOrDefault(c, 0) + 1);
            }

            int len = Integer.MAX_VALUE, start = 0;
            int valid = 0; //已经匹配成功的字符种类数（非字符个数）

            int left = 0, right = 0;
            //当右指针去到字符串末尾前
            while (right < sLen) {
                char c = s.charAt(right);
                right++;//右指针向右滑

                //如果右指针现在滑到的字符是目标字符串的一个，那么更新窗口中的数据
                if (need.containsKey(c)) {

                    window.put(c, window.getOrDefault(c, 0) + 1);
                    if (window.get(c).equals(need.get(c))) {
                        valid++;
                    }
                }

                //窗口开始从左边收缩
                while (valid == need.size()) {
                    if (right - left < len) {
                        start = left;
                        len = right - left;
                    }

                    char d = s.charAt(left);
                    left++;

                    if (need.containsKey(d)) {
                        if (window.get(d).equals(need.get(d))) {
                            valid--;
                        }
                        window.put(d, window.getOrDefault(d, 0) - 1);
                    }
                }
            }
            return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}