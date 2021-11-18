package chapter5_hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * @author koujn
 * @date 2021/11/18 10:40
 */

/**
 * 题目：设计一个数据结构，使如下3个操作的时间复杂度都是O(1)。
 * 1.insert(value) : 如果数据集中不包含一个数值，则把它添加到数据集中。
 * 2.remove(value) : 如果数据集中包含一个数值，则把它删除。
 * 3.getRandom()   : 随机返回数据集中的一个数值，要求数据集中每个数字被返回的概率都相同。
 */
public class Questions_30 {

    class RandomizedSet {

        private HashMap<Integer,Integer> map;
        private List<Integer> list;

        public RandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>();
        }

        public boolean insert(int val) {
            if(map.get(val) == null){
                map.put(val,list.size());
                list.add(val);
                return true;
            }else {
                return false;
            }
        }

        //这里需要把用list最后一位覆盖删除的位置，避免list删除所有元素前移导致map中存的位置不正确。
        public boolean remove(int val) {
            Integer index = map.get(val);
            if(index != null){
                int lastIndex = list.size() - 1;
                Integer lastVal = map.get(lastIndex);
                map.put(lastVal,index);
                map.remove(val);
                list.set(index,lastVal);
                list.remove(lastIndex);
                return true;
            }else {
                return false;
            }
        }

        public int getRandom() {
            return list.get(new Random().nextInt(list.size()));
        }
    }

}
