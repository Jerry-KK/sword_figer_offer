package chapter8_tree;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author lethe
 * @date 2021/11/22 22:22
 */
public class TreeSetAndTreeMap {

    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        /**
         *  TreeSet实现了Set接口，它内部的平衡二叉树中的每个节点只包含一个值，
         *  根据这个值的查找、添加和删除操作的时间复杂度都是O(logn)
         */
        treeSet.add(1);
        boolean contains = treeSet.contains(1);
        treeSet.remove(1);

        //返回键大于或等于给定值的最小键;如果没有则返回null
        treeSet.ceiling(1);
        //返回键小于或等于给定值的最大值;如果没有则返回null
        treeSet.floor(1);
        //返回键大于给定值的最小键;如果没有则返回null
        treeSet.higher(1);
        //返回键小于给定值的最大键;如果没有则返回null
        treeSet.lower(1);

        /**
         * TreeMap实现了接口Map。和TreeSet不一样,TreeMap内部的平衡二叉搜索树中每个节点都是一个包含键值和值的映射。
         * 可以根据键值实现时间复杂度为O(logn)的查找、添加和删除操作
         */
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        treeMap.put(1,1);
        Integer integer = treeMap.get(1);
        boolean b = treeMap.containsKey(1);
        treeMap.remove(1);
        //返回键大于或等于给定值的最小映射/键;如果没有则返回null
        treeMap.ceilingKey(1);
        treeMap.ceilingEntry(1);
        //返回键小于或等于给定值的最大映射/键;如果没有则返回null
        treeMap.floorKey(1);
        treeMap.floorEntry(1);
        //返回键大于给定值的最小映射/键;如果没有则返回null
        treeMap.higherKey(1);
        treeMap.higherEntry(1);
        //返回键小于给定值的最大映射/键;如果没有则返回null
        treeMap.lowerKey(1);
        treeMap.lowerEntry(1);

        /**
         * 之前介绍过哈希表(HashSet和HashMap)中查找、添加和删除操作的时间复杂度都是O(1),是非常高效的。但它有一个缺点，哈希表只能根据键进行
         * 查找，只能判断该键是否存在。如果需要根据数据的值的大小查找，如查找数据集合中比某个值大的所有数字中的最小的一个，哈希表就无能为力了。
         *
         * 如果在一个排序的动态数组(如Java的ArrayList)中根据数值的大小进行查找，则可以应用二分查找算法实现时间效率为O(logn)的查找。但排序的
         * 动态数组的添加和删除操作的时间复杂度是O(n)。
         *
         * 由于TreeSet和TreeMap能够保证其内部的二叉搜索树是平衡的，因此它们的查找、添加和删除操作的时间复杂度都是O(logn),综合来看他们
         * 比动态数组更高效。
         */
    }

}
