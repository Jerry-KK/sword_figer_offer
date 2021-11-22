package chapter8_tree;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author lethe
 * @date 2021/11/22 23:18
 */

/**
 * 题目:给定一个整数数组nums和两个正数k、t，请判断是否存在两个不同的下标i和j满足i和j之差的绝对值不大于给定的k,并且两个数值nums[i]和
 * nums[j]的差的绝对值不大于给定的t。
 */
public class Questions_57 {

    public static void main(String[] args) {
        Questions_57 body = new Questions_57();
        int[] nums = {1,5,9,1,5,9};
        boolean b = body.containsNearbyAlmostDuplicate(nums, 2, 3);
        System.out.println(b);
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        int i = 0;
        for (; i < k; i++) {
            treeSet.add(nums[i]);
        }
        for (; i < nums.length; i++) {
            Integer lower = treeSet.floor(nums[i]);
            if(lower != null && nums[i] - lower <= t)
                return true;
            Integer high = treeSet.ceiling(nums[i]);
            if(high != null && high - nums[i] <= t)
                return true;
            treeSet.remove(nums[i-k]);
            treeSet.add(nums[i]);
        }
        return false;
    }


    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Integer lower = treeSet.floor(nums[i]);
            if(lower != null && nums[i] - lower <= t)
                return true;
            Integer high = treeSet.ceiling(nums[i]);
            if(high != null && high - nums[i] <= t)
                return true;
            treeSet.add(nums[i]);
            if(i >= k)
                treeSet.remove(i-k);
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate3(int[] nums, int k, int t) {
        Map<Integer,Integer> buckets = new HashMap<>();
        int bucketSize = t + 1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int id = getBucketID(num,bucketSize);
            if(buckets.containsKey(id)
            || buckets.containsKey(id-1) && num - buckets.get(id-1) <= t
            || buckets.containsKey(id+1) && buckets.get(id+1) - num <= t)
                return true;
            buckets.put(id,num);
            if( i >= k ) {
                buckets.remove(getBucketID(nums[i-k],bucketSize));
            }
        }
        return false;
    }

    private int getBucketID(int num, int bucketSize) {
        return num >= 0 ? num / bucketSize : (num+1) / bucketSize - 1;
    }
}
