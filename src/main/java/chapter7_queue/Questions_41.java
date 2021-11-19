package chapter7_queue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author koujn
 * @date 2021/11/19 10:30
 */

/**
 * 题目：请实现如下类型MovingAverage,计算滑动窗口中所有数字的平均值，该类型构造函数的参数确定滑动窗口的大小，每次调用成员函数next时都会在滑动
 * 窗口中添加一个整数，并返回滑动窗口中所有数字的平均值。
 */
public class Questions_41 {

    class MovingAverage {

        private Queue<Integer> queue;
        private int sum;
        private int capacity;

        public MovingAverage(int size) {
            queue = new ArrayDeque<>(size);
            sum = 0;
            capacity = size;
        }

        public double next(int val) {
            if(capacity == queue.size()) {
                sum -= queue.poll();
            }
            queue.add(val);
            sum += val;
            return sum/queue.size();
        }

    }

}
