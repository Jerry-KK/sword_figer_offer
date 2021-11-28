package chapter11_binary_search;

/**
 * @author lethe
 * @date 2021/11/28 23:33
 */

/**
 * 题目：狒狒很喜欢吃香蕉。一天它发现了n堆香蕉，第i堆有piles[i]根香蕉。门卫刚好走开，H小时后回来。狒狒吃香蕉喜欢细嚼慢咽，但又想在门卫回来之前
 * 吃完所有香蕉。请问狒狒每小时至少吃多少根香蕉?
 * 如果狒狒决定每小时吃k根香蕉，而它在吃的某一堆剩余的香蕉的数目少于k，那么它只会将这堆香蕉吃完，下一个小时才会开始吃另一堆香蕉。
 */
public class Questions_73 {

    public int minEatingSpeed(int[] piles,int H) {
        int max = Integer.MAX_VALUE;
        for (int pile:piles) {
            max = Math.max(max,pile);
        }
        int left = 1;
        int right = max;
        while (left <= right) {
            int mid = ((right-left)>>1) + left;
            int hours = getHours(piles,mid);
            if(hours <= H) {
                if(mid == 1 || getHours(piles,mid-1) > H) {
                    return mid;
                }
                right = mid -1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private int getHours(int[] piles,int speed) {
        int hours = 0;
        for (int pile:piles) {
            hours += (pile + speed - 1) / speed;
        }
        return hours;
    }
}
