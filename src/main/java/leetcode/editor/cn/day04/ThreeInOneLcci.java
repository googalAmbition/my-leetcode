//三合一。描述如何只用一个数组来实现三个栈。 
//
// 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。s
//tackNum表示栈下标，value表示压入的值。 
//
// 构造函数会传入一个stackSize参数，代表每个栈的大小。 
//
// 示例1: 
//
//  输入：
//["TripleInOne", "push", "push", "pop", "pop", "pop", "isEmpty"]
//[[1], [0, 1], [0, 2], [0], [0], [0], [0]]
// 输出：
//[null, null, null, 1, -1, -1, true]
//说明：当栈为空时`pop, peek`返回-1，当栈满时`push`不压入元素。
// 
//
// 示例2: 
//
//  输入：
//["TripleInOne", "push", "push", "push", "pop", "pop", "pop", "peek"]
//[[2], [0, 1], [0, 2], [0, 3], [0], [0], [0], [0]]
// 输出：
//[null, null, null, null, 2, 1, -1, -1]
// 
// Related Topics 栈 设计 数组 
// 👍 35 👎 0

// 三合一
package leetcode.editor.cn.day04;

public class ThreeInOneLcci {

    //leetcode submit region begin(Prohibit modification and deletion)
    class TripleInOne {

        //维护三个数组,三个int记录数组的长度
        int stackSize;
        int[] stack0;
        int[] stack1;
        int[] stack2;
        int size0;
        int size1;
        int size2;

        public TripleInOne(int stackSize) {
            this.stackSize = stackSize;
            stack0 = new int[stackSize];
            stack1 = new int[stackSize];
            stack2 = new int[stackSize];
            size0 = 0;
            size1 = 0;
            size2 = 0;
        }

        public void push(int stackNum, int value) {
            //判断三个数组中的哪一个,当size == 规定的size时就不能再加了
            if (stackNum == 0 && size0 < stackSize) {
                stack0[size0] = value;
                if (size0 < stackSize) {
                    size0++;
                }
            } else if (stackNum == 1 && size1 < stackSize) {
                stack1[size1] = value;
                if (size1 < stackSize) {
                    size1++;
                }
            } else if (stackNum == 2 && size2 < stackSize) {
                stack2[size2] = value;
                if (size2 < stackSize) {
                    size2++;
                }
            }
        }

        public int pop(int stackNum) {
            if (stackNum == 0) {
                //栈空时就返回-1(题目规定)
                if (size0 == 0) {
                    return -1;
                } else {
                    //最后一个元素相当于栈顶,下标为当前size - 1
                    return stack0[--size0];
                }
            } else if (stackNum == 1) {
                if (size1 == 0) {
                    return -1;
                } else {
                    return stack1[--size1];
                }
            } else {
                if (size2 == 0) {
                    return -1;
                } else {
                    return stack2[--size2];
                }
            }
        }

        public int peek(int stackNum) {
            if (stackNum == 0) {
                if (size0 == 0) {
                    return -1;
                } else {
                    //直接返回size - 1即可
                    return stack0[size0 - 1];
                }
            } else if (stackNum == 1) {
                if (size1 == 0) {
                    return -1;
                } else {
                    return stack1[size1 - 1];
                }
            } else {
                if (size2 == 0) {
                    return -1;
                } else {
                    return stack2[size2 - 1];
                }
            }
        }

        public boolean isEmpty(int stackNum) {
            if (stackNum == 0) {
                return size0 == 0;
            } else if (stackNum == 1) {
                return size1 == 0;
            } else {
                return size2 == 0;
            }
        }
    }

    /**
     * Your TripleInOne object will be instantiated and called as such:
     * TripleInOne obj = new TripleInOne(stackSize);
     * obj.push(stackNum,value);
     * int param_2 = obj.pop(stackNum);
     * int param_3 = obj.peek(stackNum);
     * boolean param_4 = obj.isEmpty(stackNum);
     */
    //leetcode submit region end(Prohibit modification and deletion)

    class Demo {

        private int[] data;
        private int[] index = new int[3];
        private int size;

        public Demo(int stackSize) {
            data = new int[stackSize * 3];
            size = stackSize;
        }

        public void push(int stackNum, int value) {

            if (index[stackNum] == size) {
                return;
            }
            data[stackNum * 3 + index[stackNum]] = value;
            index[stackNum]++;
        }

        public int pop(int stackNum) {
            if (index[stackNum] == 0) {
                return -1;
            }
            index[stackNum]--;
            return data[stackNum * 3 + index[stackNum]];
        }

        public int peek(int stackNum) {
            if (index[stackNum] == 0) {
                return -1;
            }
            return data[stackNum * 3 + index[stackNum] - 1];
        }

        public boolean isEmpty(int stackNum) {
            return index[stackNum] == 0;
        }
    }
}