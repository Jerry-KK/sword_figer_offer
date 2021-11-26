package chapter11_binary_search;

import java.util.Random;

/**
 * @author koujn
 * @date 2021/11/26 16:45
 */
public class Solution {

    private int[] sums;
    private int total;

    public Solution(int[] w) {
        sums = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            total+=w[i];
            sums[i] = total;
        }
    }

    public int pickIndex() {
        Random random = new Random();
        int p = random.nextInt(total);
        int left = 0;
        int right = sums.length-1;
        while (left <= right) {
            int mid = ((right-left)>>1) + left;
            if(sums[mid] > p) {
                if(mid == 0 || (sums[mid-1] <= p))
                    return mid;
                right = mid - 1;
            } else
                left = mid + 1;
        }
        return -1;
    }

}
