//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。 
//
// 示例: 
//
// s = "abaccdeff"
//返回 "b"
//
//s = "" 
//返回 " "
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
// Related Topics 哈希表 
// 👍 80 👎 0

// 第一个只出现一次的字符
package leetcode.editor.cn.day01;

public class DiYiGeZhiChuXianYiCiDeZiFuLcof {

    public static void main(String[] args) {
        Solution solution = new DiYiGeZhiChuXianYiCiDeZiFuLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public char firstUniqChar(String s) {
            if (s.length() == 0) {
                return ' ';
            }
            int[] appear = new int[256];
            int[] indexArray = new int[256];
            char[] charArray = s.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                char c = charArray[i];
                appear[c]++;
                indexArray[c] = i;
            }
            int minIndex = Integer.MAX_VALUE;
            for (int i = 0; i < appear.length; i++) {
                int times = appear[i];
                if (times == 1) {
                    if (minIndex == Integer.MAX_VALUE) {
                        minIndex = i;
                    }
                    if (indexArray[minIndex] > indexArray[i]) {
                        minIndex = i;
                    }
                }
            }

            return minIndex == Integer.MAX_VALUE ? ' ' : (char) minIndex;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}