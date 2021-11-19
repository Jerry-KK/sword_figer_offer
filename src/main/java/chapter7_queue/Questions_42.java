package chapter7_queue;

/**
 * @author koujn
 * @date 2021/11/19 10:47
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * 请实现如下类型RecentCounter，它是统计过去3000ms内的请求次数的计数器。该类型的构造函数RecentCounter初始化计数器，请求数初始化为0；
 * 函数ping(int i)在时间t添加一个新请求(t表示以毫秒为单位的时间)，并返回过去3000ms内(时间范围为[t-3000,t])发生的所有请求数。
 * 假设每次调用函数ping的参数t都比之前调用的参数值大。
 */
public class Questions_42 {

    class RecentCounter {

        private Queue<Integer> queue;

        public RecentCounter() {
            queue = new LinkedList<>();
        }

        public int ping(int t) {
            queue.offer(t);
            while (t-3000 > queue.peek())
                queue.poll();
            return queue.size();
        }

    }

}
