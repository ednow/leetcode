package leetcode169;


import java.util.*;

public class Solution {
    public int majorityElement(int[] nums) {
        TreeMap<Integer, Integer> frequency = new TreeMap<>();
        // 统计次数
        for (int num:
             nums) {
            if (frequency.containsKey(num)) {
                frequency.put(num, frequency.get(num) + 1);
            } else {
                frequency.put(num, 1);
            }
        }
        // 排序找数量
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(frequency.entrySet());
        // 升序
//        list.sort((Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) -> (a.getValue() - b.getValue()));

//        list.sort(Comparator.comparingInt(Map.Entry::getValue));
//
//        return list.get(list.size()-1).getKey();

        // 逆序
//        list.sort(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()));
        list.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        return list.get(0).getKey();
    }
}
