package com.company.leetcodesolutions.queue;

import java.util.LinkedList;

public class QueueSolutions {
    public int countStudents(int[] students, int[] sandwiches) {
        //Create LinkedList as a Stack
        LinkedList<Integer> studentQueue = new LinkedList<>();
        //length of an array
        int len = students.length;
        for (int i = 0; i < len; i++) {
            studentQueue.offer(i);
        }

        int lastQuery = -1;
        int sIdx = 0;

        while (sIdx < len) {
            if (studentQueue.peekFirst() == lastQuery) {
                break;
            } else if (students[studentQueue.peekFirst()] == sandwiches[sIdx]) {
                studentQueue.pollFirst();
                lastQuery = -1;
                sIdx++;
            } else {
                Integer tmp = studentQueue.pollFirst();
                studentQueue.offer(tmp);
                if (lastQuery == -1) {
                    lastQuery = tmp;
                }
            }
        }
        return studentQueue.size();
    }

    public int timeRequiredToBuy(int[] tickets, int k) {
        int result = 0;
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i] - tickets[k] >= 0 && k >= i) {
                result += tickets[k];
            } else if (tickets[i] - tickets[k] >= 0 && k < i) {
                result += tickets[k] - 1;
            } else if (tickets[i] - tickets[k] < 0) {
                result += tickets[i];
            }
        }
        return result;
    }

    public int firstUniqueChar(String s) {
        char[] count = new char[256];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }
        int index = -1;
        for (int j = 0; j < s.length(); j++) {
            if (count[s.charAt(j)] == 1) {
                index = j;
                break;
            }
        }
        return index;
    }
}
