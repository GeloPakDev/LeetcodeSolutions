package com.company.leetcodesolutions.binarysearch;

public class BinarySearchSolutions {
    //log n?
    public int search(int[] nums, int target) {
        //The main problem of this question is that it is rotated
        if (nums == null && nums.length == 0) return -1;

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int midpoint = left + (right - left) / 2;
            if (nums[midpoint] > nums[right]) {
                left = midpoint + 1;
            } else {
                right = midpoint;
            }
        }

        int start = left;
        left = 0;
        right = nums.length - 1;

        if (target >= nums[start] && target <= nums[right]) {
            left = start;
        } else {
            right = start;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = findRightMostIndex(nums, target);
        res[1] = findLeftMostIndex(nums, target);
        return res;
    }

    private int findLeftMostIndex(int[] nums, int target) {
        int index = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
            if (nums[mid] == target) index = mid;
        }
        return index;
    }

    private int findRightMostIndex(int[] nums, int target) {
        int index = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            if (nums[mid] == target) index = mid;
        }
        return index;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        boolean result = false;
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                if (anInt == target) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    public int findMin(int[] nums) {
        /*
         * Arrays.sort(nums);
         * return nums[0];
         */
        if (nums.length == 1) {
            return nums[0];
        }

        int left = 0;
        int right = nums.length - 1;

        if (nums[right] > nums[0]) {
            return nums[0];
        }

        while (right >= left) {
            int mid = left + (right - left) / 2;
            //it means that next element is the start of the array
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            //middle element here is the start of our array
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            if (nums[mid] > nums[0]) {
                //All elements to the left are less than mid
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    //The main problem - duplicates , work on it later
    public int findMin2(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            if (nums[mid] > nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] array, int value) {
        int start = 0;
        int end = array.length;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (array[mid] == value) {
                return mid;
                //If the element of the array is greater than the mid we should look for element in the right partition of the array
            } else if (array[mid] < value) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return -1;
    }

    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1])
                return i;
        }
        return nums.length - 1;
    }
}
