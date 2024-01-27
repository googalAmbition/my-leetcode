//请实现整数数字的乘法、减法和除法运算，运算结果均为整数数字，程序中只允许使用加法运算符和逻辑运算符，允许程序中出现正负常数，不允许使用位运算。 
// 你的实现应该支持如下操作： 
// 
// Operations() 构造函数 
// minus(a, b) 减法，返回a - b 
// multiply(a, b) 乘法，返回a * b 
// divide(a, b) 除法，返回a / b 
// 
// 示例： 
// Operations operations = new Operations();
//operations.minus(1, 2); //返回-1
//operations.multiply(3, 4); //返回12
//operations.divide(5, -2); //返回-2
// 
// 提示： 
// 
// 你可以假设函数输入一定是有效的，例如不会出现除法分母为0的情况 
// 单个用例的函数调用次数不会超过1000次 
// 
// Related Topics 设计 数学 
// 👍 15 👎 0

// 运算
package leetcode.editor.cn;

public class OperationsLcci {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Operations {

        public Operations() {

        }

        public int minus(int a, int b) {
            return a + (~b) + 1;
        }

        private boolean shouldSwap(int a, int b) {
            return abs(a) < abs(b);
        }

        private int abs(int a) {
            return a < 0 ? minus(0, a) : a;
        }

        public int multiply(int a, int b) {
            if (shouldSwap(a, b)) {
                int t = a;
                a = b;
                b = t;
            }
            if (b < 0) {
                a = minus(0, a);
                b = minus(0, b);
            }
            int t = 0;
            int sum = 0;
            int bit = 1;
            while (b >= bit && bit > 0) {
                if ((b & bit) > 0) {
                    sum += a;
                }
                a += a;
                bit += bit;
            }
            return sum;
        }

        public int divide(int a, int b) {
            if (a == 0x80000000) {
                return a;
            }
            boolean positvie = true;
            if (a < 0) {
                a = minus(0, a);
                positvie = !positvie;
            }
            if (b < 0) {
                b = minus(0, b);
                positvie = !positvie;
            }

            int id = 0;
            int[] t = new int[32];
            int[] bit = new int[32];
            t[0] = b;
            bit[0] = 1;
            for (int i = 1; i < t.length; i++) {
                if (t[i - 1] + t[i - 1] > a || t[i - 1] + t[i - 1] < 0)
                    break;
                t[i] = t[i - 1] + t[i - 1];
                bit[i] = bit[i - 1] + bit[i - 1];
                id++;
            }
            int div = 0;
            for (int i = id; i >= 0; i--) {
                if (a >= t[i]) {
                    a = minus(a, t[i]);
                    div += bit[i];
                }
            }
            return positvie ? div : minus(0, div);
        }
    }

    /**
     * Your Operations object will be instantiated and called as such:
     * Operations obj = new Operations();
     * int param_1 = obj.minus(a,b);
     * int param_2 = obj.multiply(a,b);
     * int param_3 = obj.divide(a,b);
     */
    //leetcode submit region end(Prohibit modification and deletion)
}