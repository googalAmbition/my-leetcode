//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s 和 p 仅包含小写字母 
// 
//
// 👍 1383 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        Solution solution = new FindAllAnagramsInAString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            Map<Character, Integer> need = new HashMap<>();
            for (char c : p.toCharArray()) {
                need.put(c, need.getOrDefault(c, 0) + 1);
            }
            Map<Character, Integer> window = new HashMap<>();

            List<Integer> ans = new ArrayList<>();
            int left = 0, right = 0, valid = 0;
            while (right < s.length()) {
                char r = s.charAt(right);
                right++;
                if (need.containsKey(r)) {
                    window.put(r, window.getOrDefault(r, 0) + 1);
                    if (need.get(r).equals(window.get(r))) {
                        valid++;
                    }
                }
                if (right - left > p.length()) {
                    char l = s.charAt(left);
                    left++;
                    if (need.containsKey(l)) {
                        if (need.get(l).equals(window.get(l))) {
                            valid--;
                        }
                        window.put(l, window.get(l) - 1);
                    }
                }
                if (valid == need.size()) {
                    ans.add(left);
                }

            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

} 
