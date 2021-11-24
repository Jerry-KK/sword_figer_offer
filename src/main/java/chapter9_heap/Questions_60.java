package chapter9_heap;

import java.util.*;

/**
 * @author koujn
 * @date 2021/11/24 11:50
 */

/**
 * 题目：请找出数组中出现频率最高的k个数字。
 * 例如，当k等于2时，输入数组[1,2,2,1,3,1]，由于数字1出现3次，数字2出现了2次，数字3出现了1次，因此出现频率最高的2个数字是1和2.
 */
public class Questions_60 {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> numToCount = new HashMap<>();
        for (int num:nums) {
            numToCount.put(num,numToCount.getOrDefault(num,0)+1);
        }
        Queue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<>(
                (e1,e2)->e1.getValue() - e2.getValue()
        );
        for (Map.Entry<Integer,Integer> entry: numToCount.entrySet()) {
            if(minHeap.size() < k)
                minHeap.offer(entry);
            else if(entry.getValue() > minHeap.peek().getValue()) {
                minHeap.poll();
                minHeap.offer(entry);
            }
        }
        List<Integer> result = new LinkedList<>();
        for (Map.Entry<Integer,Integer> entry: minHeap)
            result.add(entry.getKey());
        return result;
    }

}
