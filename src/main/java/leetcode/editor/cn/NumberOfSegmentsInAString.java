//统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。 
//
// 请注意，你可以假定字符串里不包括任何不可打印的字符。 
//
// 示例: 
//
// 输入: "Hello, my name is John"
//输出: 5
//解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。
// 
// Related Topics 字符串 👍 173 👎 0

// 字符串中的单词数
package leetcode.editor.cn;

public class NumberOfSegmentsInAString {

    public static void main(String[] args) {
        Solution solution = new NumberOfSegmentsInAString().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int countSegments(String s) {
            int segmentCount = 0;

            for (int i = 0; i < s.length(); i++) {
                if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                    segmentCount++;
                }
            }
            return segmentCount;

        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}