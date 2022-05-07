package com.company.leetcodesolutions.array;


import com.company.leetcodesolutions.util.Strings;

import java.util.*;
import java.util.stream.Collectors;

public class ArraysSolutions {

    public static int[] buildArray(int[] nums) {
        int[] array = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array[i] = nums[nums[i]];
        }
        return array;
    }

    public static int[] getConcatenation(int[] nums) {
        int aLength = nums.length;
        int bLength = nums.length;

        int[] totalArray = new int[nums.length * 2];

        System.arraycopy(nums, 0, totalArray, 0, aLength);
        System.arraycopy(nums, 0, totalArray, aLength, bLength);

        return totalArray;
    }

    public static int finalValueAfterOperations(String[] operations) {
        int counter = 0;
        for (String operation : operations) {
            if (operation.contains("++")) {
                counter++;
            } else if (operation.contains("--")) {
                counter--;
            }
        }
        return counter;
    }

    public static int[] runningSum(int[] nums) {
        int[] array = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                array[i] += nums[j];
            }
        }
        return array;
    }

    public int[] shuffle(int[] nums, int n) {
        int[] array = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                array[i] = nums[i / 2];
            } else {
                array[i] = nums[n + i / 2];
            }
        }
        return array;
    }

    public static int maximumWealth(int[][] accounts) {
        int[] maxArray = new int[accounts.length];
        for (int row = 0; row < accounts.length; row++) {
            for (int column = 0; column < accounts[row].length; column++) {
                maxArray[row] += accounts[row][column];
            }
        }
        Arrays.sort(maxArray);
        return maxArray[maxArray.length - 1];
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int maximum = Arrays.stream(candies).max().getAsInt();
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= maximum) {
                result.add(i, true);
            } else {
                result.add(i, false);
            }
        }
        return result;
    }

    public static int numIdenticalPairs(int[] nums) {
        int[] result = new int[101];
        int tmp = 0;
        int counter = 0;
        for (int i : nums) {
            tmp = i;
            result[tmp]++;
        }
        for (int i : result) {
            if (i >= 2) {
                counter += (i * (i - 1)) / 2;
            }
        }
        return counter;
    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int counter = 0;
            for (int num : nums) {
                if (nums[i] > num) counter++;
            }
            result[i] = counter;
        }
        return result;
    }

    public int[] decompressRLElist(int[] nums) {
        int freq = 0;
        for (int i = 0; i < nums.length; i += 2) {
            freq += nums[i];
        }

        int[] output = new int[freq];
        int currentIndex = 0;
        for (int j = 1; j < nums.length; j += 2) {
            for (int i = 0; i < nums[j - 1]; i++) {
                output[currentIndex] = nums[j];
                currentIndex++;
            }
        }
        return output;
    }

    public static String restoreString(String s, int[] indices) {
        Map<Integer, Character> map = new HashMap<>();
        for (int i = 0; i < indices.length; i++) {
            map.put(indices[i], s.charAt(i));
        }
        StringBuilder mapAsString = new StringBuilder("");
        for (Integer key : map.keySet()) {
            mapAsString.append(map.get(key));
        }
        return mapAsString.toString();
    }

    public static int[] decode(int[] encoded, int first) {
        int size = encoded.length;
        int[] res = new int[size + 1];
        res[0] = size;
        for (int i = 0; i < size; i++) {
            res[i + 1] = res[i] ^ encoded[i];
        }
        return res;
    }

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (map.containsKey(difference)) {
                res[0] = i;
                res[1] = map.get(difference);
                return res;
            }
            map.put(nums[i], i);
        }
        return res;
    }

    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(index[i], nums[i]);
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int counter = 0;
        for (List<String> strings : items) {
            if (ruleKey.equals("type") && ruleValue.equals(strings.get(0))) counter++;
            else if (ruleKey.equals("color") && ruleValue.equals(strings.get(1))) counter++;
            else if (ruleKey.equals("name") && ruleValue.equals(strings.get(2))) counter++;
        }
        return counter;
    }

    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                list.add(i);
            }
        }
        return list;
    }

    public int countKDifference(int[] nums, int k) {
        int counter = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public String firstPalindrome(String[] words) {
        String result = "";
        for (String word : words) {
            if (Strings.checkForPalindrome(word)) {
                result = word;
                break;
            }
        }
        return result;

    }

    public int minMovesToSeat(int[] seats, int[] students) {
        int counter = 0;
        Arrays.sort(seats);
        Arrays.sort(students);
        for (int i = 0; i < students.length; i++) {
            counter += Math.abs(seats[i] - students[i]);
        }
        return counter;
    }

    public int sumOddLengthSubArrays(int[] arr) {
        int sum = 0;
        int l = arr.length;
        for (int i = 0; i < l; i++) {
            sum += (((i + 1) * (l - 1) + 1) / 2) * arr[i];
        }
        return sum;
    }

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        if (word1 == word2) {
            return true;
        }

        if (word1 == null || word2 == null) {
            return false;
        }

        int n = word1.length;
        if (n != word2.length) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            if (!word1[i].equals(word2[i])) {
                return false;
            }
        }

        return true;
    }

    public static int countConsistentStrings(String allowed, String[] words) {
        //Add all characters from the allowed String to set to avoid duplicates
        Set<Character> set = new HashSet<>();
        for (char ch : allowed.toCharArray()) {
            set.add(ch);
        }
        //storing the result
        int result = 0;
        //loop over array of strings
        for (String w : words) {
            boolean match = true;
            for (char ch : w.toCharArray()) {
                //check if letter contains in the string
                if (!set.contains(ch)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                result++;
            }
        }
        return result;
    }

    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int w = nums[0];
        int x = nums[1];
        int y = nums[nums.length - 2];
        int z = nums[nums.length - 1];
        return (y * z) - (w * x);
    }

    public static String truncateSentence(String s, int k) {
        String[] words = s.split("\\s+");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < k; i++) {
            result.append(words[i]).append(" ");
        }
        //trim is used to remove last white space
        return result.toString().trim();
    }

    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (Math.abs(arr[i] - arr[j]) > a) {
                    continue;
                }
                for (int k = j + 1; k < arr.length; k++) {
                    if (
                            (Math.abs(arr[j] - arr[k]) <= b) &&
                                    (Math.abs(arr[i] - arr[k]) <= c)
                    ) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public int[] countPoints(int[][] points, int[][] queries) {
        int[] resultArray = new int[queries.length];
        int i = 0;
        for (int[] q : queries) {
            int pts = 0;
            for (int[] p : points) {
                if ((Math.pow((p[0] - q[0]), 2) + Math.pow((p[1] - q[1]), 2)) <= Math.pow(q[2], 2)) {
                    pts++;
                }
            }
            resultArray[i++] = pts;
        }
        return resultArray;
    }

    public int[] minOperations(String boxes) {
        int[] result = new int[boxes.length()];
        //i is the box in which we will put the items
        for (int i = 0; i < boxes.length(); i++) {
            int counter = 0;
            //j is the other elements on which we will manipulate
            for (int j = 0; j < boxes.length(); j++) {
                if (boxes.charAt(j) == '1') {
                    counter += Math.abs(i - j);
                }
            }
            result[i] = counter;
        }
        return result;
    }

    public int[] minOperations2(String boxes) {
        int n = boxes.length();
        char[] ch = boxes.toCharArray();

        int[] left = new int[n];
        int count = ch[0] - '0';

        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] + count;
            count += ch[i] - '0';
        }

        int[] right = new int[n];
        count = ch[n - 1] - '0';
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] + count;
            count += ch[i] - '0';
        }
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = left[i] + right[i];
        }
        return answer;
    }

    private final String[] CODE = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

    public int uniqueMorseRepresentations(String[] words) {
        return Arrays.stream(words).map(e -> getEncoding(e)).collect(Collectors.toSet()).size();
    }

    private String getEncoding(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(CODE[c - 'a']);
        }
        return sb.toString();
    }

    public int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            int low = 0;
            int high = image[i].length - 1;
            while (low <= high) {
                if (image[i][low] == image[i][high]) {
                    image[i][low] = 1 - image[i][low];
                    image[i][high] = image[i][low];
                }
                low++;
                high--;
            }
        }
        return image;
    }

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int sum = 0;
        int n = grid.length;

        int[] row = new int[n];
        int[] column = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                row[i] = Math.max(row[i], grid[i][j]);
                column[j] = Math.max(column[j], grid[i][j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += Math.min(row[i], column[j]) - grid[i][j];
            }
        }
        return sum;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            //Here we find out the element which we need and them find appropriate pair
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int low = i + 1;
                int high = nums.length - 1;
                int sum = 0 - nums[i];
                while (low < high) {
                    if (nums[low] + nums[high] == sum) {
                        result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        //Here we will avoid any duplicates
                        while (low < high && nums[low] == nums[low + 1]) low++;
                        while (low < high && nums[high] == nums[high - 1]) high--;
                        low++;
                        high--;
                    } else if (nums[low] + nums[high] < sum) {
                        high--;
                    } else {
                        low++;
                    }
                }
            }
        }
        return result;
    }

    public int[] twoSum2(int[] nums, int target) {
        int a_pointer = 0;
        int b_pointer = nums.length - 1;
        while (a_pointer < b_pointer) {
            int sum = nums[a_pointer] + nums[b_pointer];

            if (sum > target) {
                b_pointer -= 1;
            } else if (sum < target) {
                a_pointer += 1;
            } else {
                return new int[]{
                        a_pointer + 1, b_pointer + 1
                };
            }
        }
        return new int[]{a_pointer + 1, b_pointer + 1};
    }

    public void setZeroes(int[][] matrix) {
        boolean isColumn = false;
        int row = matrix.length;
        int col = matrix[0].length;

        for (int i = 0; i < row; i++) {
            if (matrix[0][0] == 0) {
                isColumn = true;
            }

            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // See if the first row needs to be set to zero as well
        if (matrix[0][0] == 0) {
            for (int j = 0; j < col; j++) {
                matrix[0][j] = 0;
            }
        }

        // See if the first column needs to be set to zero as well
        if (isColumn) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public int wateringPlants(int[] plants, int capacity) {
        int steps = 0;
        int capacityFull = capacity;
        for (int i = 0; i < plants.length; i++) {
            if (capacityFull < plants[i]) {
                steps += i * 2;
                capacityFull = capacity;
            }
            capacityFull = capacityFull - plants[i];
            steps++;

        }
        return steps;
    }

    public List<Integer> findDuplicates(int[] nums) {
        //If we see a duplicate we access the same index
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) list.add(index + 1);
            nums[index] = -nums[index];
        }
        return list;
    }

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> result = new ArrayList<>();
        int j = 0;
        int i = 0;
        while (i < firstList.length && j < secondList.length) {
            int[] a = firstList[i];
            int[] b = secondList[j];
            if (a[1] < b[0]) i++;
            else if (b[1] < a[0]) j++;
            else {
                int start = Math.max(a[0], b[0]);
                int end = Math.min(a[1], b[1]);
                result.add(new int[]{start, end});
                if (a[1] < b[1]) i++;
                else j++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        //create an array for UAM
        int[] res = new int[k];
        //Here we are using the set because it doesn't allow holding duplicate values
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] log : logs) {
            Set<Integer> set = map.computeIfAbsent(log[0], k1 -> new HashSet<>());
            set.add(log[1]);
        }

        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            Set<Integer> s = entry.getValue();
            int size = s.size();
            if (size <= k) {
                res[size - 1]++;
            }
        }
        return res;
    }

    public List<Integer> partitionLabels(String s) {
        if (s == null || s.length() == 0) return null;
        List<Integer> result = new ArrayList<>();

        int[] last_indices = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last_indices[s.charAt(i) - 'a'] = i;
        }

        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, last_indices[s.charAt(i) - 'a']);
            if (i == end) {
                result.add(end - start + 1);
                start = end + 1;
            }
        }
        return result;
    }

    public List<Boolean> checkArithmeticSubArrays(int[] nums, int[] l, int[] r) {
        List<Boolean> list = new ArrayList<>();
        int m = l.length;
        for (int i = 0; i < m; i++) {
            Boolean res = isArithmetic(Arrays.copyOfRange(nums, l[i], r[i] + 1));
            list.add(res);
        }
        return list;
    }

    public Boolean isArithmetic(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        //get difference
        int d = nums[1] - nums[0];
        //
        for (int i = 2; i <= len - 1; i++) {
            if (nums[i] - nums[i - 1] != d) {
                return false;
            }
        }
        return true;
    }
    //PERMUTATION PROBLEM STARTS HERE
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, int[] nums, int start) {
        if (start == nums.length) {
            result.add(toList(nums));
        } else {
            for (int i = start; i < nums.length; i++) {
                swap(i, start, nums);
                backtrack(result, nums, start + 1);
                swap(i, start, nums);
            }
        }
    }

    private void swap(int i, int start, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[start];
        nums[start] = temp;
    }

    private List<Integer> toList(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i : nums) {
            res.add(i);
        }
        return res;
    }

    //PERMUTATION PROBLEM ENDS HERE
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n = colSum.length;
        int[][] array = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = Math.min(rowSum[i], colSum[j]);
                rowSum[i] -= array[i][j];
                colSum[j] -= array[i][j];
            }
        }
        return array;
    }

    public int[] deckRevealedIncreasing(int[] deck) {
        int N = deck.length;
        Deque<Integer> index = new LinkedList<>();
        for (int i = 0; i < N; ++i)
            index.add(i);

        int[] ans = new int[N];
        Arrays.sort(deck);
        for (int card : deck) {
            ans[index.pollFirst()] = card;
            if (!index.isEmpty())
                index.add(index.pollFirst());
        }
        return ans;
    }
    //DISCUSS THIS SOLUTION LATER WHEN U PASS THE GRAPH
    public int[] restoreArray(int[][] adjacentPairs) {
        int n = adjacentPairs.length;
        int[] res = new int[n + 1];
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int[] pair : adjacentPairs) {
            if (!map.containsKey(pair[0])) {
                map.put(pair[0], new HashSet<>());
            }
            map.get(pair[0]).add(pair[1]);
            if (!map.containsKey(pair[1])) {
                map.put(pair[1], new HashSet<>());
            }
            map.get(pair[1]).add(pair[0]);
        }

        HashSet<Integer> result = new HashSet<>();
        int cur = Integer.MAX_VALUE;
        int i = 0;
        for (Map.Entry<Integer, HashSet<Integer>> e : map.entrySet()) {
            if (e.getValue().size() == 1) {
                cur = e.getKey();
                break;
            }
        }

        res[i] = cur;
        i++;
        result.add(cur);
        while (i < res.length) {
            for (int next : map.remove(cur)) {
                if (next != cur && result.add(next)) {
                    res[i] = next;
                    i++;
                    cur = next;
                }
            }
        }
        return res;
    }

    public String evaluate(String s, List<List<String>> knowledge) {
        String res = "";
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < knowledge.size(); i++) {
            map.put(knowledge.get(i).get(0), knowledge.get(0).get(i));
        }
        return res;
    }

    public static int largestAltitude(int[] gain) {
        int r = 0;
        int length = gain.length;
        int[] res = new int[length + 1];
        for (int i = 0; i < length; i++) {
            res[i] = r += gain[i];
        }
        Arrays.sort(res);
        return res[length];
    }
}