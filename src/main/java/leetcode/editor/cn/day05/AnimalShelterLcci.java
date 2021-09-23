//动物收容所。有家动物收容所只收容狗与猫，且严格遵守“先进先出”的原则。在收养该收容所的动物时，收养人只能收养所有动物中“最老”（由其进入收容所的时间长短而定
//）的动物，或者可以挑选猫或狗（同时必须收养此类动物中“最老”的）。换言之，收养人不能自由挑选想收养的对象。请创建适用于这个系统的数据结构，实现各种操作方法，比如
//enqueue、dequeueAny、dequeueDog和dequeueCat。允许使用Java内置的LinkedList数据结构。 
//
// enqueue方法有一个animal参数，animal[0]代表动物编号，animal[1]代表动物种类，其中 0 代表猫，1 代表狗。 
//
// dequeue*方法返回一个列表[动物编号, 动物种类]，若没有可以收养的动物，则返回[-1,-1]。 
//
// 示例1: 
//
//  输入：
//["AnimalShelf", "enqueue", "enqueue", "dequeueCat", "dequeueDog", "dequeueAny"
//]
//[[], [[0, 0]], [[1, 0]], [], [], []]
// 输出：
//[null,null,null,[0,0],[-1,-1],[1,0]]
// 
//
// 示例2: 
//
//  输入：
//["AnimalShelf", "enqueue", "enqueue", "enqueue", "dequeueDog", "dequeueCat", "
//dequeueAny"]
//[[], [[0, 0]], [[1, 0]], [[2, 1]], [], [], []]
// 输出：
//[null,null,null,null,[2,1],[0,0],[1,0]]
// 
//
// 说明: 
//
// 
// 收纳所的最大容量为20000 
// 
// Related Topics 设计 队列 
// 👍 25 👎 0

// 动物收容所
package leetcode.editor.cn.day05;

import java.util.LinkedList;
import java.util.Queue;

public class AnimalShelterLcci {

    //leetcode submit region begin(Prohibit modification and deletion)
    class AnimalShelf {

        private final Queue<Integer> cat = new LinkedList<>();
        private final Queue<Integer> dog = new LinkedList<>();

        public AnimalShelf() {

        }

        public void enqueue(int[] animal) {
            if (animal[1] == 1) {
                dog.offer(animal[0]);
            } else {
                cat.offer(animal[0]);
            }
        }

        public int[] dequeueAny() {
            if (cat.isEmpty() && dog.isEmpty()) {
                return new int[] {-1, -1};
            } else if (!cat.isEmpty() && !dog.isEmpty()) {
                int dogNum = dog.peek();
                int catNum = cat.peek();
                if (dogNum > catNum) {
                    cat.poll();
                } else {
                    dog.poll();
                }
                return new int[] {Math.min(catNum, dogNum), catNum > dogNum ? 1 : 0};
            } else if (cat.isEmpty()) {
                return new int[] {dog.poll(), 1};
            } else {
                return new int[] {cat.poll(), 0};
            }
        }

        public int[] dequeueDog() {
            int num = -1;
            int type = -1;
            if (!dog.isEmpty()) {
                num = dog.poll();
                type = 1;
            }
            return new int[] {num, type};
        }

        public int[] dequeueCat() {
            int num = -1;
            int type = -1;
            if (!cat.isEmpty()) {
                num = cat.poll();
                type = 0;
            }
            return new int[] {num, type};
        }
    }

    /**
     * Your AnimalShelf object will be instantiated and called as such:
     * AnimalShelf obj = new AnimalShelf();
     * obj.enqueue(animal);
     * int[] param_2 = obj.dequeueAny();
     * int[] param_3 = obj.dequeueDog();
     * int[] param_4 = obj.dequeueCat();
     */
    //leetcode submit region end(Prohibit modification and deletion)
}