package chapter9_heap;

import java.util.PriorityQueue;

/**
 * @author koujn
 * @date 2021/11/24 11:05
 */

/**
 * 题目：请设计一个类型KthLargest,它每次从一个数据流中读取一个数字,并得出数据流已经读取的数字中第k(k>=1)大的数字。
 * 该类型的构造函数有两个参数:一个是整数k,另一个是包含数据流中最开始数字的整数数组nums(假设数组nums的长度大于k)。
 * 该类型还有一个函数add,用来添加数据流中的新数字并返回数据流中已经读取的数字的第k大数字。
 */
public class Questions_59 {

    class KthLargest {
        private PriorityQueue<Integer> minHeap;
        private int size;

        public KthLargest(int k, int[] nums) {
            size = k;
            minHeap = new PriorityQueue<>();
            for (int num:nums) {
                add(num);
            }
        }

        private int add(int val) {
            if(minHeap.size() < size)
                minHeap.offer(val);
            else if(val >  minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(val);
            }
            return minHeap.peek();
        }
    }

}
