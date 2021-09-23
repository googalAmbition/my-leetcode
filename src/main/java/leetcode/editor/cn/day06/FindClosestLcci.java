//有个内含单词的超大文本文件，给定任意两个单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，
//你能对此优化吗? 
//
// 示例： 
//
// 输入：words = ["I","am","a","student","from","a","university","in","a","city"], 
//word1 = "a", word2 = "student"
//输出：1 
//
// 提示： 
//
// 
// words.length <= 100000 
// 
// Related Topics 数组 字符串 
// 👍 30 👎 0

// 单词距离
package leetcode.editor.cn.day06;

public class FindClosestLcci {

    public static void main(String[] args) {
        Solution solution = new FindClosestLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int findClosest(String[] words, String word1, String word2) {
            int a = -1, b = -1, dis = Integer.MAX_VALUE;

            for (int i = 0; i < words.length; i++) {
                if (!words[i].equals(word1) && !words[i].equals(word2)) {
                    continue;
                }
                if (words[i].equals(word1)) {
                    a = i;
                } else {
                    b = i;
                }
                if (a != -1 && b != -1) {
                    int abs = Math.abs(a - b);
                    if (abs == 1) {
                        return 1;
                    } else {
                        dis = Math.min(dis, abs);
                    }
                }
            }
            return dis;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}