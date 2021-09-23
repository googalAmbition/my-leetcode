//你有两个字符串，即pattern和value。 pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式。例如，字符串"catcatgocatg
//o"匹配模式"aabab"（其中"cat"是"a"，"go"是"b"），该字符串也匹配像"a"、"ab"和"b"这样的模式。但需注意"a"和"b"不能同时表示相
//同的字符串。编写一个方法判断value字符串是否匹配pattern字符串。 
//
// 示例 1： 
//
// 输入： pattern = "abba", value = "dogcatcatdog"
//输出： true
// 
//
// 示例 2： 
//
// 输入： pattern = "abba", value = "dogcatcatfish"
//输出： false
// 
//
// 示例 3： 
//
// 输入： pattern = "aaaa", value = "dogcatcatdog"
//输出： false
// 
//
// 示例 4： 
//
// 输入： pattern = "abba", value = "dogdogdogdog"
//输出： true
//解释： "a"="dogdog",b=""，反之也符合规则
// 
//
// 提示： 
//
// 
// 1 <= len(pattern) <= 1000 
// 0 <= len(value) <= 1000 
// 你可以假设pattern只包含字母"a"和"b"，value仅包含小写字母。 
// 
// Related Topics 数学 字符串 回溯 枚举 
// 👍 116 👎 0

// 模式匹配
package leetcode.editor.cn.day05;

public class PatternMatchingLcci {

    public static void main(String[] args) {
        Solution solution = new PatternMatchingLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean patternMatching(String pattern, String value) {
            if (pattern.length() == 1) {
                return true;
            }
            if (pattern.isEmpty() || value.isEmpty()) {
                return false;
            }
            int[][] map = new int[26][1002];
            for (int i = 0; i < value.length(); i++) {
                int idx = value.charAt(i) - 'a';
                map[idx][(map[idx][0]++) + 1] = i;
            }
            int[] total = new int[2];
            for (int i = 0; i < pattern.length(); i++) {
                total[pattern.charAt(i) - 'a']++;
            }
            if (total[0] == 1 || total[1] == 1) {
                return true;
            } else if (total[0] == 0 || total[1] == 0) {
                return isMatch(total[0] == 0 ? total[1] : total[0], value, map);
            } else {
                int min = Math.min(total[1], total[0]), max = Math.max(total[1], total[0]);
                for (int i = 0; i < 26; i++) {
                    if (map[i][0] != 0 && map[i][0] < min) {
                        return false;
                    }
                }
                if (isMatch(min, value, map) || isMatch(max, value, map)) {
                    return true;
                }
                int first = pattern.charAt(0) == 'a' ? total[0] : total[1];
                int second = first == total[0] ? total[1] : total[0];
                for (int end = 1; end * first <= value.length(); end++) {
                    if (isMatch(end, pattern, value, first, second, map)) {
                        return true;
                    }
                }
                return false;
            }
        }

        private boolean isMatch(int count, String pattern, String value, int first, int second, int[][] map) {
            String strFirst = value.substring(0, count);
            int secondTotalLen = value.length() - count * first;
            if (secondTotalLen == 0 || secondTotalLen % second != 0) {
                return false;
            }
            int secLen = secondTotalLen / second;
            char ch = pattern.charAt(0);
            String strSecond = "";
            for (int i = 1, cnt = count; i < pattern.length(); i++) {
                if (pattern.charAt(i) == ch) {
                    if (cnt + count > value.length()) {
                        return false;
                    }
                    if (!value.substring(cnt, cnt + count).equals(strFirst)) {
                        return false;
                    }
                    cnt += count;
                } else {
                    if (cnt + secLen > value.length()) {
                        return false;
                    }
                    String strTemp = value.substring(cnt, cnt + secLen);
                    if (strSecond.isEmpty()) {
                        strSecond = strTemp;
                    } else if (!strTemp.equals(strSecond)) {
                        return false;
                    }
                    cnt += secLen;
                }
            }
            return true;
        }

        private boolean isMatch(int count, String value, int[][] map) {
            if (value.length() % count != 0) {
                return false;
            }
            for (int i = 0; i < 26; i++) {
                if (map[i][0] != 0 && (map[i][0] < count || map[i][0] % count != 0)) {
                    return false;
                }
            }
            boolean[] visit = new boolean[value.length()];
            int length = 0;
            for (int i = 0; i < value.length(); i++) {
                if (visit[i]) {
                    continue;
                }
                char ch = value.charAt(i);
                visit[i] = true;
                length++;
                for (int j = i + count; j < value.length(); j += count) {
                    if (value.charAt(j) == ch) {
                        visit[j] = true;
                        length++;
                    } else {
                        return false;
                    }
                }
            }
            return length == value.length();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}