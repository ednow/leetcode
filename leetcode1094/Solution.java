package leetcode1094;

import java.security.cert.TrustAnchor;
import java.util.HashMap;
import java.util.Set;

public class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // 所有的上车点
        HashMap<Integer, Integer> stop = new HashMap<>();
        for (int i = 0; i < trips.length; i++) {
            stop.put(trips[i][0], i);
        }
        // 车子开动
        for (int i = trips[0][0]; i < trips[trips.length-1][1]; i++) {
            if (stop.containsKey(i)) {

            }
        }
        return true;
    }
}
