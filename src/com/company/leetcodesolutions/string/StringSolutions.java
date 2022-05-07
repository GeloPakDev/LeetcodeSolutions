package com.company.leetcodesolutions.string;

import java.util.*;

public class StringSolutions {
    public List<List<String>> groupAnagrams(String[] strs) {
        //KEY is sorted string , VALUE is the list of original strings
        Map<String, List<String>> res = new HashMap<>();
        for (String str : strs) {
            //here we get the actual key
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String sortedStr = String.valueOf(charArr);
            //Check if sortedStr as a KEY is already exists in a map or not
            if (!res.containsKey(sortedStr)) {
                res.put(sortedStr, new ArrayList<>());
            }
            res.get(sortedStr).add(str);
        }
        return new ArrayList<>(res.values());
    }

    public int lengthOfLongestSubstring(String s) {
        StringBuilder test = new StringBuilder();
        int maxLength = -1;
        if (s.isEmpty()) {
            return 0;
        } else if (s.length() == 1) {
            return 1;
        }
        for (char c : s.toCharArray()) {
            String current = String.valueOf(c);
            if (test.toString().contains(current)) {
                test = new StringBuilder(test.substring(test.indexOf(current) + 1));
            }
            test.append(c);
            maxLength = Math.max(test.length(), maxLength);
        }
        return maxLength;
    }

    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = maxSum;
        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i] + currentSum, nums[i]);
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }

    public static int minPartitions(String n) {
        char best = '0';
        for (char c : n.toCharArray())
            if (c > best) best = c;
        return best - '0';
    }

    public static int numberOfBeams(String[] bank) {
        int result = 0;
        int[] numsOfLasers = new int[bank.length];
        //outer loop for strings
        for (int i = 0; i < bank.length; i++) {
            int lasers = 0;
            //inner nums in string
            for (int j = 0; j < bank[i].length(); j++) {
                if (bank[i].charAt(j) == '1') {
                    lasers += 1;
                }
            }
            numsOfLasers[i] = lasers;
        }
        int targetIndex = 0;
        for (int sourceIndex = 0; sourceIndex < numsOfLasers.length; sourceIndex++) {
            if (numsOfLasers[sourceIndex] != 0)
                numsOfLasers[targetIndex++] = numsOfLasers[sourceIndex];
        }
        int[] newArray = new int[targetIndex];
        System.arraycopy(numsOfLasers, 0, newArray, 0, targetIndex);

        for (int i = 0; i < newArray.length - 1; i++) {
            result += newArray[i] * newArray[i + 1];
        }
        return result;
    }

    public int[] executeInstructions(int n, int[] startPos, String s) {
        int[] result = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            int countMoves = 0;
            int xIndex = startPos[0];
            int yIndex = startPos[1];

            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) == 'U') {
                    xIndex--;
                }
                if (s.charAt(j) == 'D') {
                    xIndex++;
                }
                if (s.charAt(j) == 'L') {
                    yIndex--;
                }
                if (s.charAt(j) == 'R') {
                    xIndex++;
                }
                if (xIndex < 0 || yIndex < 0 || xIndex > n || yIndex > n) {
                    break;
                } else {
                    countMoves++;
                }
            }
            result[i] = countMoves;
        }
        return result;
    }

    public int minSteps(String s, String t) {
        int counter = 0;
        int[] array = new int[26];
        for (int i = 0; i < s.length(); i++) {
            array[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            array[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (array[i] != 0) {
                counter += Math.abs(array[i]);
            }
        }
        return counter / 2;
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> answer = new ArrayList<>();
        for (String word : words) {
            if (match(word, pattern)) {
                answer.add(word);
            }
        }
        return answer;
    }

    public boolean match(String word, String pattern) {
        //Create map for storing the letters and their frequency
        Map<Character, Character> map = new HashMap<>();
        //word.length == pattern.length
        for (int i = 0; i < word.length(); i++) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);
            if (!map.containsKey(w)) map.put(w, p);
            if (map.get(w) != p) return false;
        }

        boolean[] seen = new boolean[26];
        for (char ch : map.values()) {
            if (seen[ch - 'a']) return false;
            seen[ch - 'a'] = true;
        }
        return true;
    }

    public int numOfPairs(String[] nums, String target) {
        //length of target
        final int n = target.length();

        int ans = 0;
        Map<String, Integer> count = new HashMap<>();

        for (final String num : nums) {
            final int k = num.length();
            if (k >= n)
                continue;
            if (target.substring(0, k).equals(num))
                ans += count.getOrDefault(target.substring(k), 0);
            if (target.substring(n - k).equals(num))
                ans += count.getOrDefault(target.substring(0, n - k), 0);
            count.merge(num, 1, Integer::sum);
        }

        return ans;
    }

    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> counts = new HashMap<>();
        for (String domain : cpdomains) {
            String[] cpInfo = domain.split("\\s+");
            String[] frags = cpInfo[1].split("\\.");
            int count = Integer.parseInt(cpInfo[0]);
            String cur = "";
            for (int i = frags.length - 1; i >= 0; i--) {
                cur = frags[i] + (i < frags.length - 1 ? "." : "") + cur;
                counts.put(cur, counts.getOrDefault(cur, 0) + count);
            }
        }

        List<String> answer = new ArrayList<>();

        for (String dom : counts.keySet()) {
            answer.add("" + counts.get(dom) + " " + dom);
        }
        return answer;
    }

    public String intToRoman(int num) {
        String[] m = {"", "M", "MM", "MMM"};
        String[] c = {"", "C", "CC", "CCC", "CD",
                "D", "DC", "DCC", "DCCC", "CM"};
        String[] x = {"", "X", "XX", "XXX", "XL",
                "L", "LX", "LXX", "LXXX", "XC"};
        String[] i = {"", "I", "II", "III", "IV",
                "V", "VI", "VII", "VIII", "IX"};
        String thousands = m[num / 1000];
        String hunderds = c[(num % 1000) / 100];
        String tens = x[(num % 100) / 10];
        String ones = i[num % 10];

        String answer = thousands + hunderds + tens + ones;

        return answer;
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length() || s2.length() == 0) return false;
        if (s1.length() == 0) return true;
        int x = s1.length();
        int y = s2.length();
        int[] array1 = new int[26];
        int[] array2 = new int[26];
        for (int i = 0; i < x; i++) {
            array1[s1.charAt(i) - 'a']++;
            array2[s2.charAt(i) - 'a']++;
        }
        for (int i = x; i < y; i++) {
            if (Arrays.equals(array1, array2)) {
                return true;
            }
            array2[s2.charAt(i - x) - 'a']--;
            array2[s2.charAt(i) - 'a']++;
        }
        return Arrays.equals(array1, array2);
    }

    public List<Integer> findAnagrams(String s, String p) {
        //get the actual length of the arrays
        int original = s.length();
        int anagram = p.length();
        //create return array
        List<Integer> res = new ArrayList<>();
        if (original <= 0 || anagram <= 0) return res;
        //create HashArray for anagram
        int[] anagramHash = new int[26];
        //fill the array
        for (int i = 0; i < anagram; i++) {
            anagramHash[p.charAt(i) - 'a']++;
        }
        //create an array for actual string
        int[] originalArray = new int[26];
        for (int i = 0; i < original; i++) {
            //fullFill the original Array with values
            originalArray[s.charAt(i) - 'a']++;
            //If index is longer than anagram than slide the window
            if (i >= anagram) {
                //delete left element of the window
                originalArray[s.charAt(i - anagram) - 'a']--;
            }
            //compare if arrays are equals we add index to our result array
            if (Arrays.equals(anagramHash, originalArray)) {
                res.add(i - anagram + 1);
            }
        }
        return res;
    }

    public String removeOccurrences(String s, String part) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            str.append(s.charAt(i));
            if (str.length() >= part.length()) {
                if (str.substring(str.length() - part.length()).equals(part)) {
                    str.setLength(str.length() - part.length());
                }
            }
        }
        return str.toString();
    }

    public int minFlips(String target) {
        int ans = 0;
        int state = 0;

        for (final char c : target.toCharArray())
            if (c - '0' != state) {
                state = c - '0';
                ++ans;
            }

        return ans;
    }

    public String convert(String s, int numRows) {
        Map<Integer, StringBuilder> map = new HashMap<>();
        int pos = 0;
        boolean incr = true;
        for (char ch : s.toCharArray()) {
            if (pos == numRows) incr = false;
            if (pos == 1) incr = true;
            if (incr) pos++;
            else pos--;

            if (!map.containsKey(pos))
                map.put(pos, new StringBuilder());
            map.get(pos).append(ch);
        }
        StringBuilder res = new StringBuilder();
        for (int i : map.keySet()) {
            res.append(map.get(i));
        }
        return res.toString();
    }

    public boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }

    public String build(String s) {
        Stack<Character> answer = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c != '#')
                answer.push(c);
            else if (!answer.isEmpty())
                answer.pop();
        }
        return String.valueOf(answer);
    }
}
