package com.company.leetcodesolutions.sorting;


import java.util.*;
import java.util.stream.Collectors;

public class SortingSolutions {
    public static int getKth(int lo, int hi, int k) {
        int size = hi - lo;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= size; i++) {
            map.put(lo, power(lo));
            lo++;
        }
        Map<Integer, Integer> result = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        List<Integer> res = new ArrayList<>(result.keySet());

        return res.get(k - 1);
    }

    public static int power(int x) {
        int res = 0;
        while (x != 1) {
            if (x % 2 == 1) x = x * 3 + 1;
            else x >>= 1;
            res++;
        }
        return res;
    }

    public int[] topKFrequent(int[] nums, int k) {
        //Here we count how many times element appears in array
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // Create a Priority Queue
        // to sort based on the
        // count or on the key if the
        // count is same
        PriorityQueue<Map.Entry<Integer, Integer>> queue =
                new PriorityQueue<>((a, b) -> a.getValue().equals(b.getValue())
                        ? Integer.compare(b.getKey(), a.getKey())
                        : Integer.compare(b.getValue(), a.getValue()));

        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            queue.offer(entry);

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = Objects.requireNonNull(queue.poll()).getKey();
        }
        return res;
    }

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
