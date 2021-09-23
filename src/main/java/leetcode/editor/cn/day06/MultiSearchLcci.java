//给定一个较长字符串big和一个包含较短字符串的数组smalls，设计一个方法，根据smalls中的每一个较短字符串，对big进行搜索。输出smalls中的字
//符串在big里出现的所有位置positions，其中positions[i]为smalls[i]出现的所有位置。 
//
// 示例： 
//
// 输入：
//big = "mississippi"
//smalls = ["is","ppi","hi","sis","i","ssippi"]
//输出： [[1,4],[8],[],[3],[1,4,7,10],[5]]
// 
//
// 提示： 
//
// 
// 0 <= len(big) <= 1000 
// 0 <= len(smalls[i]) <= 1000 
// smalls的总字符数不会超过 100000。 
// 你可以认为smalls中没有重复字符串。 
// 所有出现的字符均为英文小写字母。 
// 
// Related Topics 字典树 数组 哈希表 字符串 字符串匹配 滑动窗口 
// 👍 28 👎 0

// 多次搜索
package leetcode.editor.cn.day06;

import java.util.ArrayList;
import java.util.List;

public class MultiSearchLcci {

    public static void main(String[] args) {
        Solution solution = new MultiSearchLcci().new Solution();
        solution.multiSearch("mississippi",new String[]{"is","ppi","hi","sis","i","ssippi"});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[][] multiSearch(String big, String[] smalls) {
            List<List<Integer>> list = new ArrayList<>();
            for (int i = 0; i < smalls.length; i++) {
                if (smalls[i].isEmpty()) {
                    continue;
                }
                List<Integer> childList = new ArrayList<>();
                for (int j = 0, k = 0; j < big.length(); j = k + 1) {
                    k = big.indexOf(smalls[i], j);
                    if (k != -1) {
                        childList.add(k);
                    } else {
                        break;
                    }
                }
                list.add(childList);
            }
            int[][] ret = new int[list.size()][];
            for (int i = 0; i < list.size(); i++) {
                List<Integer> childList = list.get(i);
                ret[i] = new int[childList.size()];
                for (int j = 0, n = childList.size(); j < n; j++) {
                    ret[i][j] = childList.get(j);
                }
            }
            return list.isEmpty() ? new int[1][0] : ret;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}