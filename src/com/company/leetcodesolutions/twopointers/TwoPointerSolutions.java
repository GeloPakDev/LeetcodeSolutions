package com.company.leetcodesolutions.twopointers;

import java.util.Arrays;

public class TwoPointerSolutions {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int area = 0;
        while (start < end) {
            //
            area = Math.max(area, Math.min(height[start], height[end]) * (end - start));
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return area;
    }

    public int[] sortedSquares(int[] A) {
        int[] result = new int[A.length];
        int s = 0;
        int i = 0;
        int j = 0;
        for (int k = 0; k < A.length; k++) {
            if (A[k] < 0) {
                j++;
            }
            A[k] = A[k] * A[k];
        }
        i = j - 1;
        while (i >= 0 && j <= A.length - 1) {
            if (A[i] < A[j]) {
                result[s] = A[i];
                i--;
            } else {
                result[s] = A[j];
                j++;
            }
            s++;
        }
        while (i >= 0) {
            result[s] = A[i];
            i--;
            s++;
        }
        while (j <= A.length - 1) {
            result[s] = A[j];
            j++;
            s++;
        }
        return result;
    }

    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        int maxSum = 0;
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum > maxSum) {
                maxSum = sum;
            }
            start++;
            end--;
        }
        return maxSum;
    }

    public static void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        while (start < end) {
            swap(start, end, s);
            start++;
            end--;
        }

        System.out.println(s);
    }

    private static void swap(int start, int end, char[] input) {
        char ch = input[start];
        input[start] = input[end];
        input[end] = ch;
    }

    public int minSwaps(String s) {
        int size = 0;
        for (char c : s.toCharArray()) {
            if (c == '[') {
                size++;
            } else {
                if (size > 0) {
                    size--;
                }
            }
        }
        return (size + 1) / 2;
    }
}