//每年，政府都会公布一万个最常见的婴儿名字和它们出现的频率，也就是同名婴儿的数量。有些名字有多种拼法，例如，John 和 Jon 本质上是相同的名字，但被当成
//了两个名字公布出来。给定两个列表，一个是名字及对应的频率，另一个是本质相同的名字对。设计一个算法打印出每个真实名字的实际频率。注意，如果 John 和 Jon 
//是相同的，并且 Jon 和 Johnny 相同，则 John 与 Johnny 也相同，即它们有传递和对称性。 
//
// 在结果列表中，选择 字典序最小 的名字作为真实名字。 
//
// 
//
// 示例： 
//
// 
//输入：names = ["John(15)","Jon(12)","Chris(13)","Kris(4)","Christopher(19)"], syn
//onyms = ["(Jon,John)","(John,Johnny)","(Chris,Kris)","(Chris,Christopher)"]
//输出：["John(27)","Chris(36)"] 
//
// 
//
// 提示： 
//
// 
// names.length <= 100000 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 哈希表 字符串 计数 
// 👍 47 👎 0

// 婴儿名字
package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BabyNamesLcci {

    public static void main(String[] args) {
        Solution solution = new BabyNamesLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private int N = 0;
        private int[] fa = null;
        private String[] nms = null;
        private int[] count = null;

        private int find(int x) { return fa[x] == x ? x : (fa[x] = find(fa[x])); }

        private void merge(int x1, int y1) {
            int x = find(x1);
            int y = find(y1);
            if (x == y) {
                return;
            }
            if (y < N && nms[x].compareTo(nms[y]) > 0) {
                fa[x] = y;
                count[y] += count[x];
                count[x] = 0;
            } else {
                fa[y] = x;
                count[x] += count[y];
                count[y] = 0;
            }
        }

        private void add(String name, int idx, HashMap<String, Integer> map) {
            fa[idx] = idx;
            nms[idx] = name;
            count[idx] = 0;
            map.put(nms[idx], idx);
        }

        public String[] trulyMostPopular(String[] names, String[] synonyms) {
            N = names.length;
            int M = N + 2 * synonyms.length + 1;
            fa = new int[M];
            nms = new String[M];
            count = new int[M];
            HashMap<String, Integer> map = new HashMap<String, Integer>();
            for (int i = 0; i < N; i++) {
                fa[i] = i;
                int idxL = names[i].lastIndexOf('(');
                nms[i] = names[i].substring(0, idxL);
                count[i] = Integer.parseInt(names[i].substring(idxL + 1, names[i].length() - 1));
                map.put(nms[i], i);
            }
            for (int i = 0, cnt = N; i < synonyms.length; i++) {
                String[] par = synonyms[i].substring(1, synonyms[i].length() - 1).split(",");
                String n1 = par[0].trim();
                String n2 = par[1].trim();
                if (map.containsKey(n1) && map.containsKey(n2)) {
                    merge(map.get(n1), map.get(n2));
                } else {
                    if (map.containsKey(n1) && !map.containsKey(n2)) {
                        add(n2, cnt, map);
                        merge(cnt, map.get(n1));
                    } else if (!map.containsKey(n1) && map.containsKey(n2)) {
                        add(n1, cnt, map);
                        merge(cnt, map.get(n2));
                    } else {
                        add(n1, cnt, map);
                        cnt++;
                        add(n2, cnt, map);
                        merge(cnt, cnt - 1);
                    }
                    cnt++;
                }
            }
            List<String> list = new ArrayList<String>();
            for (int i = 0; i < N; i++) {
                if (fa[i] == i) {
                    list.add(nms[i] + "(" + count[i] + ")");
                }
            }
            return list.toArray(new String[0]);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}