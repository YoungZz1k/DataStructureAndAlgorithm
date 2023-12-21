package com.YoungZz1k.LeetCode.Hot100;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 合并区间
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 */
public class LeetCode56 {
    public int[][] merge(int[][] intervals) {
        // 按照左端点进行排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> ans = new ArrayList<>();
        // 先将第一个加入结果数组
        ans.add(intervals[0]);
        for (int i = 1; i < intervals.length; ++i) {
            // 左端点                 右端点
            int s = intervals[i][0], e = intervals[i][1];
            // 如果最后一个结果右端点小于当前左端点
            if (ans.get(ans.size() - 1)[1] < s) {
                // 加入结果集
                ans.add(intervals[i]);
            } else {
                // 否则右端点取两者较大值
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], e);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String[] args) {
        int[][] a = {{1, 2}, {3, 4}};
        LeetCode56 leetCode56 = new LeetCode56();
        System.out.println(Arrays.deepToString(leetCode56.merge(a)));
    }
}
