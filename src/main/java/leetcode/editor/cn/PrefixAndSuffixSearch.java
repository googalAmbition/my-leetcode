//设计一个包含一些单词的特殊词典，并能够通过前缀和后缀来检索单词。 
//
// 实现 WordFilter 类： 
//
// 
// WordFilter(string[] words) 使用词典中的单词 words 初始化对象。 
// f(string prefix, string suffix) 返回词典中具有前缀 prefix 和后缀suffix 的单词的下标。如果存在不止一个满足要
//求的下标，返回其中 最大的下标 。如果不存在这样的单词，返回 -1 。 
// 
//
// 
//
// 示例 
//
// 
//输入：
//["WordFilter", "f"]
//[[["apple"]], ["a", "e"]]
//输出：
//[null, 0]
//
//解释：
//WordFilter wordFilter = new WordFilter(["apple"]);
//wordFilter.f("a", "e"); // 返回 0 ，因为下标为 0 的单词的 prefix = "a" 且 suffix = 'e" 。
// 
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 15000 
// 1 <= words[i].length <= 10 
// 1 <= prefix.length, suffix.length <= 10 
// words[i]、prefix 和 suffix 仅由小写英文字母组成 
// 最多对函数 f 进行 15000 次调用 
// 
// Related Topics 设计 字典树 字符串 👍 88 👎 0

// 前缀和后缀搜索
package leetcode.editor.cn;

public class PrefixAndSuffixSearch {

    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class WordFilter {

        public WordFilter(String[] words) {

        }

        public int f(String prefix, String suffix) {
            return 0;
        }
    }

    /**
     * Your WordFilter object will be instantiated and called as such:
     * WordFilter obj = new WordFilter(words);
     * int param_1 = obj.f(prefix,suffix);
     */
    //leetcode submit region end(Prohibit modification and deletion)
}