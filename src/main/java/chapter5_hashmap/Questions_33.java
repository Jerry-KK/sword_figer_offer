package chapter5_hashmap;

import java.util.*;

/**
 * @author koujn
 * @date 2021/11/18 14:36
 */

/**
 * 题目：给定一组单次,请将它们按照变位词分组。
 * 例如，输入一组单次["eat","tea","tan","ate","nat","bat"],这组单次可以分成3组,分别是["eat","tea","ate"]、["tan","nat"]和["bat"]。
 * 假设单词中只包含英文小写字母。
 */
public class Questions_33 {

    //把每个英文小写字母映射到一个质数，通过单次中每个字母对应的数字相乘分表字符串
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] hash = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41,
        43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 97, 101};
        Map<Long,List<String>> groups = new HashMap<>();
        for (String str : strs) {
            long key = 1;
            for (char ch : str.toCharArray()) {
                key *= hash[ch-'a'];
            }
            /*groups.compute(key,(k,v)->{
                if(v == null)
                    v = new ArrayList<>();
                v.add(str);
                return v;
            });*/
            groups.putIfAbsent(key,new LinkedList<>());
            groups.get(key).add(str);
        }
        return new ArrayList<>(groups.values());
    }

    //对每个字符串的字符数组做有序化处理
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String,List<String>> groups = new HashMap<>();
        for (String s:strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = Arrays.toString(chars);

            groups.putIfAbsent(key,new LinkedList<>());
            groups.get(key).add(s);
        }
        return new LinkedList<>(groups.values());
    }

    //用int的位代表字母出现过，错误！！！无法计算字符重复出现次数
    public List<List<String>> groupAnagrams3(String[] strs) {
        Map<Integer,List<String>> groups = new HashMap<>();
        for (String s:strs) {
            int key = 0;
            for (char c:s.toCharArray()) {
                int i = 1 << (c-'a');
                if((key & 1) == 0)
                    key+=i;
            }
            groups.putIfAbsent(key,new LinkedList<>());
            groups.get(key).add(s);
        }
        return new LinkedList<>(groups.values());
    }
}
