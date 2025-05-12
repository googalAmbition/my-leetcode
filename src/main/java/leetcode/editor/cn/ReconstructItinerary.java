//给你一份航线列表 tickets ，其中 tickets[i] = [fromi, toi] 表示飞机出发和降落的机场地点。请你对该行程进行重新规划排序。 
//
//
// 所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。如果存在多种有效的行程，请你按字典排序返回最小的行程组合。 
//
//
// 
// 例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前。 
// 
//
// 假定所有机票至少存在一种合理的行程。且所有的机票 必须都用一次 且 只能用一次。 
//
// 
//
// 示例 1： 
// 
// 
//输入：tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
//输出：["JFK","MUC","LHR","SFO","SJC"]
// 
//
// 示例 2： 
// 
// 
//输入：tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL",
//"SFO"]]
//输出：["JFK","ATL","JFK","SFO","ATL","SFO"]
//解释：另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"] ，但是它字典排序更大更靠后。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= tickets.length <= 300 
// tickets[i].length == 2 
// fromi.length == 3 
// toi.length == 3 
// fromi 和 toi 由大写英文字母组成 
// fromi != toi 
// 
//
// 👍 905 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class ReconstructItinerary {
    public static void main(String[] args) {
        Solution solution = new ReconstructItinerary().new Solution();

        String[][] ti = new String[][] {{"JFK", "SFO"}, {"JFK", "ATL"}, {"SFO", "ATL"}, {"ATL", "JFK"}, {"ATL",
                "SFO"}};

        List<List<String>> collect = Arrays.stream(ti).map(x -> Arrays.asList(x[0], x[1])).collect(Collectors.toList());

        System.out.println(solution.findItinerary(collect));
        System.out.println(solution.res);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        Map<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
        List<String> itinerary = new LinkedList<String>();

        public List<String> findItinerary(List<List<String>> tickets) {
            for (List<String> ticket : tickets) {
                String src = ticket.get(0), dst = ticket.get(1);
                if (!map.containsKey(src)) {
                    map.put(src, new PriorityQueue<String>());
                }
                map.get(src).offer(dst);
            }
            dfs("JFK");
            Collections.reverse(itinerary);
            return itinerary;
        }

        public void dfs(String curr) {
            while (map.containsKey(curr) && map.get(curr).size() > 0) {
                String tmp = map.get(curr).poll();
                dfs(tmp);
            }
            itinerary.add(curr);
        }

        List<String> ans = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        int min = Integer.MAX_VALUE;

        public List<String> findItinerary1(List<List<String>> tickets) {
            ArrayList<String> path = new ArrayList<>();
            Map<String,PriorityQueue<String>> map = new HashMap<>();
            path.add("JFK");
            dfs(tickets, path, 0, new boolean[tickets.size()], "JFK");

            return ans;

        }

        void dfs(List<List<String>> tickets, List<String> path, int sum, boolean[] flag, String start) {
            if (path.size() == tickets.size() + 1) {
                System.out.println(sum);
                min = sum;
                ArrayList<String> ans = new ArrayList<>(path);
                this.ans = ans;
                res.add(ans);
                return;
            }
            for (int i = 0; i < tickets.size(); i++) {
                List<String> s = tickets.get(i);
                if (flag[i] || !s.get(0).equals(start)) {
                    continue;
                }
                System.out.println(s);
                String dis = s.get(1);
                path.add(dis);
                flag[i] = true;
                int code = 0;
                for (int j = 0; j < dis.length(); j++) {
                    code += code*j+dis.charAt(i);
                }
                sum += i;
                dfs(tickets, path, sum, flag, dis);
                sum -= i;
                flag[i] = false;
                path.remove(path.size() - 1);

            }
        }


    }

    //leetcode submit region end(Prohibit modification and deletion)
    Map<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
    List<String> itinerary = new LinkedList<String>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String src = ticket.get(0), dst = ticket.get(1);
            if (!map.containsKey(src)) {
                map.put(src, new PriorityQueue<String>());
            }
            map.get(src).offer(dst);
        }
        dfs("JFK");
        Collections.reverse(itinerary);
        return itinerary;
    }

    public void dfs(String curr) {
        while (map.containsKey(curr) && map.get(curr).size() > 0) {
            String tmp = map.get(curr).poll();
            dfs(tmp);
        }
        itinerary.add(curr);
    }


}
