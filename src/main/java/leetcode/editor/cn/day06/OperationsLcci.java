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
// 👍 16 👎 0

// 运算
package leetcode.editor.cn.day06;

public class OperationsLcci {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Operations {

        int[] postiveBit; //二进制值数组 正值
        int[] negBit; //二进制数组 负值

        public Operations() {
            int sum = 0;
            int sum2 = 0;
            postiveBit = new int[31];
            negBit = new int[31];
            for (int i = 0; i < 31; i++) {
                postiveBit[i] = sum + 1;
                sum += postiveBit[i];
                negBit[i] = sum2 + 0xFFFFFFFF;
                sum2 += negBit[i];
            }
        }

        public int minus(int a, int b) {
            long tmpB = Math.abs(b);
            long ans = a;
            for (int i = 30; i >= 0 && tmpB != 0; i = i + 0xFFFFFFFF) { //这里不能用 i-- 呜呜呜
                if (tmpB >= postiveBit[i]) {
                    tmpB += negBit[i];
                    if (b > 0) {
                        ans += negBit[i];
                    } else {
                        ans += postiveBit[i];
                    }
                }
            }
            return (int) ans;
        }

        public int multiply(int a, int b) {
            long ans = 0;
            int tmpA = Math.abs(a);
            boolean[] arr = new boolean[31];
            for (int i = 30; i >= 0 && tmpA != 0; i = i + 0xFFFFFFFF) {
                if (tmpA >= postiveBit[i]) {
                    tmpA += negBit[i];
                    arr[i] = true;
                }
            }
            long sum = b;
            for (int i = 0; i < 31; i++) {
                if (arr[i]) {
                    ans += sum;
                }
                sum += sum;
            }
            return a > 0 ? (int) ans : minus(0, (int) ans);
        }

        public int divide(int a, int b) {
            if (b == 1) {
                return a;
            }
            boolean op = false;
            if (a > 0 && b > 0 || a < 0 && b < 0) {
                op = true;
            }
            long tmpA = Math.abs(a);
            long tmpB = Math.abs(b);
            long ans = 0;
            for (int i = 30; i >= 0 && tmpA >= tmpB; i = i + 0xFFFFFFFF) {
                if (tmpA >= tmpB * postiveBit[i]) {
                    tmpA += tmpB * negBit[i];
                    ans += postiveBit[i];
                }
            }
            return op ? (int) ans : minus(0, (int) ans);
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