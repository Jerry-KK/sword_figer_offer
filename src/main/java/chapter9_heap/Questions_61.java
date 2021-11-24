package chapter9_heap;

import com.sun.org.apache.regexp.internal.RE;

import java.util.*;

/**
 * @author koujn
 * @date 2021/11/24 13:45
 */
public class Questions_61 {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (p1,p2) -> p2[0] + p2[1] - p1[0] - p1[1]
        );
        for (int i = 0; i < Math.min(nums1.length,k); i++) {
            for (int j = 0; j < Math.min(nums2.length, k); j++) {
                if (maxHeap.size() >= k) {
                    int[] root = maxHeap.peek();
                    if(nums1[i] + nums2[j] < root[0] + root[1]){
                        maxHeap.poll();
                        maxHeap.offer(new int[]{nums1[i],nums2[j]});
                    }else {
                        break;
                    }
                } else {
                    maxHeap.offer(new int[]{nums1[i],nums2[j]});
                }
            }
        }
        List<List<Integer>> result = new LinkedList<>();
        while (!maxHeap.isEmpty()) {
            int[] vals = maxHeap.poll();
            result.add(Arrays.asList(vals[0],vals[1]));
        }
        return result;
    }

    public List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (p1,p2)->nums1[p1[0]]+nums1[p1[1]]-nums2[p2[0]]-nums2[p2[1]]
        );
        if(nums2.length>0) {
            for (int i = 0; i < Math.min(k,nums1.length); i++) {
                minHeap.offer(new int[]{i,0});
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        while ( k-- > 0 && !minHeap.isEmpty()) {
            int[] ids = minHeap.poll();
            result.add(Arrays.asList(nums1[ids[0]],nums2[ids[1]]));
            if(ids[1] < nums2.length - 1){
                minHeap.offer(new int[]{ids[0],ids[1]+1});
            }
        }
        return result;
    }

}
