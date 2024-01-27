//给定字典中的两个词，长度相等。写一个方法，把一个词转换成另一个词， 但是一次只能改变一个字符。每一步得到的新词都必须能在字典中找到。 
//
// 编写一个程序，返回一个可能的转换序列。如有多个可能的转换序列，你可以返回任何一个。 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出:
//["hit","hot","dot","lot","log","cog"]
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: []
//
//解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。 
// Related Topics 广度优先搜索 哈希表 字符串 回溯
// 👍 47 👎 0

// 单词转换
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class WordTransformerLcci {

    public static void main(String[] args) {
        Solution solution = new WordTransformerLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<String> findLadders(String beginWord, String endWord, List<String> wordList) {
            List<String> list = new ArrayList<String>();
            boolean flag = false;
            for (String word: wordList) {
                if (word.equals(endWord)) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return list;
            }
            boolean[] visit = new boolean[wordList.size()];
            int MAX = wordList.size() * 100;
            String[] queue = new String[MAX];
            int[] queueParent = new int[MAX];
            int step = 0, end = 1;
            queueParent[0] = -1;
            String[] wdList = wordList.toArray(new String[0]);
            queue[0] = beginWord;
            flag = false;
            LAB:
            while (step != end) {
                String curWord = queue[step];
                for (int i = 0; i < wdList.length; i++) {
                    if (visit[i] || !compare(curWord, wdList[i]))
                        continue;
                    queue[end] = wdList[i];
                    queueParent[end] = step;
                    visit[i] = true;
                    if (wdList[i].equals(endWord)) {
                        flag = true;
                        break LAB;
                    }
                    end++;
                    end %= MAX;
                }
                step++;
                step %= MAX;
            }
            if (flag)
                for (int pathIdx = end; pathIdx != -1; pathIdx = queueParent[pathIdx])
                    list.add(0, queue[pathIdx]);
            return list;
        }

        private boolean compare(String str1, String str2) {
            if (str1.length() != str2.length()) {
                return false;
            }
            int cnt = 0;
            for (int i = 0; i < str1.length(); i++) {
                if (str1.charAt(i) != str2.charAt(i)) {
                    cnt++;
                    if (cnt == 2) {
                        return false;
                    }
                }
            }
            return cnt == 1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}