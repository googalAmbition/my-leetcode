//给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。 
//
// 返回所有可能的结果。答案可以按 任意顺序 返回。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()())()"
//输出：["(())()","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：s = "(a)())()"
//输出：["(a())()","(a)()()"]
// 
//
// 示例 3： 
//
// 
//输入：s = ")("
//输出：[""]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 25 
// s 由小写英文字母以及括号 '(' 和 ')' 组成 
// s 中至多含 20 个括号 
// 
//
// Related Topics 广度优先搜索 字符串 回溯 👍 970 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParentheses {
    public static void main(String[] args) {
        Solution solution = new RemoveInvalidParentheses().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Set<String> set = new HashSet<>();
        int maxRemL, maxRemR, maxPair;//分别是最多移除左括号数量、最多移除右括号数量、最大合法括号对数

        public List<String> removeInvalidParentheses(String s) {

            //确定删除最少的合法括号对数
            int l = 0, r = 0;
            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) == '(') {
                    ++l;
                } else if (s.charAt(i) == ')') {
                    if (r < l) {
                        ++r;
                    } else {
                        maxRemR++;//最多移除右括号数量
                    }
                }
            }
            //最大合法括号对数
            maxPair = Math.min(l, r);
            //最多移除左括号数量
            maxRemL = l > maxPair ? l - maxPair : 0;

            dfs(s, 0, 0, 0, 0, 0, new StringBuilder());
            return new ArrayList<>(set);
        }

        //对每个位置字符，考虑加入和删除两种情况，记录当前位置左右括号对数，删除的括号对数
        //以下几种情况可以剪枝
        //1.非法 r>l
        //2.放入的括号数量>最大对数 l > maxPair || r > maxPair
        //3.删除的括号数量>最大删除数量 remL > maxRemL || remR > maxRemR
        private void dfs(String s, int idx, int l, int r, int remL, int remR, StringBuilder sb) {
            if (r > l || l > maxPair || r > maxPair || remL > maxRemL || remR > maxRemR) {
                return;
            }
            if (idx == s.length()) {
                set.add(sb.toString());
                return;
            }
            char cur = s.charAt(idx);
            if (cur == '(') {
                //放入
                sb.append(cur);
                dfs(s, idx + 1, l + 1, r, remL, remR, sb);
                sb.deleteCharAt(sb.length() - 1);
                //删除
                dfs(s, idx + 1, l, r, remL + 1, remR, sb);
            } else if (cur == ')') {
                //放入
                sb.append(cur);
                dfs(s, idx + 1, l, r + 1, remL, remR, sb);
                sb.deleteCharAt(sb.length() - 1);
                //删除
                dfs(s, idx + 1, l, r, remL, remR + 1, sb);
            } else {
                //放入
                sb.append(cur);
                dfs(s, idx + 1, l, r, remL, remR, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

} 
