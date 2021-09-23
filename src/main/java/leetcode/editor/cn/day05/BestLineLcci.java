//给定一个二维平面及平面上的 N 个点列表Points，其中第i个点的坐标为Points[i]=[Xi,Yi]。请找出一条直线，其通过的点的数目最多。 
// 设穿过最多点的直线所穿过的全部点编号从小到大排序的列表为S，你仅需返回[S[0],S[1]]作为答案，若有多条直线穿过了相同数量的点，则选择S[0]值较小
//的直线返回，S[0]相同则选择S[1]值较小的直线返回。 
// 示例： 
// 输入： [[0,0],[1,1],[1,0],[2,0]]
//输出： [0,2]
//解释： 所求直线穿过的3个点的编号为[0,2,3]
// 
// 提示： 
// 
// 2 <= len(Points) <= 300 
// len(Points[i]) = 2 
// 
// Related Topics 几何 数组 哈希表 数学 
// 👍 16 👎 0

// 最佳直线
package leetcode.editor.cn.day05;

import java.util.HashMap;

public class BestLineLcci {

    public static void main(String[] args) {
        Solution solution = new BestLineLcci().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] bestLine(int[][] points) {
            if (points.length == 2) {
                return new int[] {0, 1};
            }
            int[] res = new int[2];
            int maxNum = 0; // 记录“最佳直线”穿过点的数量

            // 枚举第一个点
            for (int i = 0; i < points.length - 1; i++) {
                int max = 0; // 保存可以和points[i]共线的点的最大数量
                int maxJ = -1; // 保存确定直线的另一个点的索引
                // key: 斜率「分子+"@"+"分母"」作为 key。
                // value: value[0]在对应斜率上和points[i]共线的点的数量
                //        value[1]记录第一次计算出对应斜率的points[j]的索引j
                HashMap<String, int[]> map = new HashMap<>();
                // 枚举第二个点
                for (int j = i + 1; j < points.length; j++) {
                    int delta_x = points[j][0] - points[i][0];
                    int delta_y = points[j][1] - points[i][1];
                    // 对delta_x和delta_y进行约分，用斜率的「分子+"@"+"分母"」作为斜率表示
                    int gcd = gcd(delta_x, delta_y);
                    delta_x = delta_x / gcd;
                    delta_y = delta_y / gcd;
                    String key = delta_x + "@" + delta_y; // 两点确定直线的斜率
                    int[] record = map.getOrDefault(key, new int[] {0, -1});
                    if (record[1] == -1) {
                        record[0] += 1;
                        record[1] = j;
                        map.put(key, record);
                    } else {
                        record[0] += 1;
                    }
                    if (map.get(key)[0] > max) {
                        max = map.get(key)[0];
                        maxJ = map.get(key)[1];
                    }
                }
                if (max > maxNum) {
                    maxNum = max;
                    res[0] = i;
                    res[1] = maxJ;
                }
            }
            return res;
        }

        private int gcd(int a, int b) {
            while (b != 0) {
                int temp = a % b;
                a = b;
                b = temp;
            }
            return a;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}