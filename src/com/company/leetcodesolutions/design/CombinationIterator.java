package com.company.leetcodesolutions.design;

import java.util.LinkedList;
import java.util.Queue;

public class CombinationIterator {
    private String s;
    Queue<String> q;

    private void getCombination(int start, int length, StringBuilder txt) {
        if (length == 0) {
            q.add(txt.toString());
            return;
        }

        for (int i = start; i <= s.length() - length; ++i) {
            txt.append(s.charAt(i));
            getCombination(i + 1, length - 1, txt);
            txt.deleteCharAt(txt.length() - 1);
        }
    }

    public CombinationIterator(String characters, int combinationLength) {
        s = characters;
        q = new LinkedList<>();

        getCombination(0, combinationLength, new StringBuilder());
    }

    public String next() {
        return q.poll();
    }

    public boolean hasNext() {
        return !q.isEmpty();
    }
}
