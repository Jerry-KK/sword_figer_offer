package chapter8_tree;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author lethe
 * @date 2021/11/22 23:59
 */

/**
 * 题目：请实现一个类型MyCalendar用来记录自己的日程安排，该类型用方法book(int start, int end)在日程表中添加一个时间区域为[start,end)的
 * 事项(这是一个半开半闭区间)。如果[start,end)中之前没有安排其他事项，则成功添加该事项并返回true;否则，不能添加该事项，并返回false。
 */
public class Questions_58 {

    class MyCalendar {

        private TreeMap<Integer,Integer> events;

        public MyCalendar(){
            events = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            Map.Entry<Integer, Integer> event = events.floorEntry(start);
            if(event != null && event.getValue() >= start) {
                return false;
            }
            event = events.ceilingEntry(start);
            if(event != null && event.getKey() < end) {
                return false;
            }
            events.put(start,end);
            return true;
        }
    }
}
