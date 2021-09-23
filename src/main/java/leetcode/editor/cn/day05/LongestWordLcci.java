//给定一组单词words，编写一个程序，找出其中的最长单词，且该单词由这组单词中的其他单词组合而成。若有多个长度相同的结果，返回其中字典序最小的一项，若没有符
//合要求的单词则返回空字符串。 
//
// 示例： 
//
// 输入： ["cat","banana","dog","nana","walk","walker","dogwalker"]
//输出： "dogwalker"
//解释： "dogwalker"可由"dog"和"walker"组成。
// 
//
// 提示： 
//
// 
// 0 <= len(words) <= 200 
// 1 <= len(words[i]) <= 100 
// 
// Related Topics 字典树 数组 哈希表 字符串 
// 👍 25 👎 0

// 最长单词
package leetcode.editor.cn.day05;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class LongestWordLcci {

    public static void main(String[] args) {
        Solution solution = new LongestWordLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String longestWord(String[] words) {
            //把words数组存入set中当字典用
            HashSet<String> set = new HashSet<>(Arrays.asList(words));
            //把字符串数组按长度进行排序，如果长度相同按字典序倒序
            Arrays.sort(words, new Comparator<String>() {
                @Override
                public int compare(String s1, String s2) {
                    if (s1.length() == s2.length()) {
                        return s2.compareTo(s1);
                    }
                    return s1.length() - s2.length();
                }
            });
            //从尾部开始遍历
            for (int i = words.length - 1; i >= 0; i--) {
                //防止整个字符串与自身匹配返回true，且后续不会用到直接删除
                set.remove(words[i]);
                if (check(words[i], set)) {
                    return words[i];
                }
            }
            return "";
        }

        public boolean check(String s, HashSet<String> set) {
            //s的长度为0说明整个字符串被匹配完了
            if (s.length() == 0) {
                return true;
            }
            for (int j = 1; j <= s.length(); j++) {
                //从0~j-1位置的字符组成的字符串是否在字典中
                if (set.contains(s.substring(0, j))) {
                    //对子串进行递归
                    if (check(s.substring(j), set)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}