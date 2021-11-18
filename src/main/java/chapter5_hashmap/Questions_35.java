package chapter5_hashmap;

import java.util.List;

/**
 * @author koujn
 * @date 2021/11/18 15:27
 */

/**
 * 题目：给定一组范围在00:00至23：59的时间，求任意两个时间之间的最小时间差。
 * 例如，输入时间数组["23:50","23:59","00:00"],"23:59"和"00:00"之间只有1分钟的间隔，是最小的时间差。
 */
public class Questions_35 {

    public int findMinDifference(List<String> timePoints) {
        if(timePoints.size() > 1440)
            return 0;
        boolean[] minuteFlags = new boolean[1440];
        for (String time:timePoints) {
            String[] t = time.split(":");
            int min = Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
            if(minuteFlags[min])
                return 0;
            minuteFlags[min] = true;
        }
        return helper(minuteFlags);
    }

    private int helper(boolean[] minuteFlags) {
        int minDiff = minuteFlags.length - 1;
        int prev = -1;
        int first = minuteFlags.length - 1;
        int last = -1;
        for (int i = 0; i < minuteFlags.length; ++i) {
            if(minuteFlags[i]) {
                if(prev >= 0) {
                    minDiff = Math.min(i - prev,minDiff);
                }
                prev = i;
                first = Math.min(i,first);
                last = Math.max(i,last);
            }
        }
        minDiff = Math.min(first + minuteFlags.length - last , minDiff);
        return minDiff;
    }

}
