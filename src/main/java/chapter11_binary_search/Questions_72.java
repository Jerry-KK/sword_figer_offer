package chapter11_binary_search;

/**
 * @author lethe
 * @date 2021/11/28 23:29
 */
/**
 * 题目：输入一个非负整数，请计算它的平方根。正数的平方根有两个，只输出其中的正数平方根。如果平方根不是整数，那么只输出它的整数部分。
 * 例如，如果输入4则输出2；如果输入18则输出4.
 */
public class Questions_72 {
    public int mySqrt(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = ((right - left) >>1) + left;
            if(mid * mid > n) {
                right = mid-1;
            }else {
                if((mid+1) * (mid+1) > n) {
                    return mid;
                }
                left = mid + 1;
            }
        }
        return 0;
    }
}
