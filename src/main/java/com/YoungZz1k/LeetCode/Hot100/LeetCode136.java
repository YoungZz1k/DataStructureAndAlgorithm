package com.YoungZz1k.LeetCode.Hot100;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 只出现一次的数字
 */
public class LeetCode136 {

    // 自己想的 hashmap
    public int singleNumber1(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer count = map.getOrDefault(num, 0);
            count++;
            map.put(num,count);
        }
        AtomicInteger k = new AtomicInteger();
        map.forEach((key,value)->{
            if (value == 1){
                k.set(key);
            }
        });
        return k.get();
    }

    // 力扣题解 使用异或
    public int singleNumber2(int[] nums) {
        int ans = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                // 4 1 2 1 2 相当于 4 ^ 1 ^ 2 ^ 1 ^ 2 = 1 ^ 1 ^ 2 ^ 2 ^ 4
                //                                       0   ^   0   ^ 4
                //                                             0^4 = 4
                ans = ans ^ nums[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        LeetCode136 leetCode136 = new LeetCode136();
        System.out.println(leetCode136.singleNumber1(nums));
    }
}
