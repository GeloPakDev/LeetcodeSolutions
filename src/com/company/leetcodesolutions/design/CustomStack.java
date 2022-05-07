package com.company.leetcodesolutions.design;

class CustomStack {
    int[] stack;
    public int top = -1;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
    }

    public void push(int x) {
        if (top < stack.length - 1) {
            stack[++top] = x;
        }
    }

    public int pop() {
        if (top == -1)
            return -1;
        top--;
        return stack[top + 1];
    }

    public void increment(int k, int val) {
        for (int i = 0; i < (Math.min(k, top + 1)); i++) {
            stack[i] += val;
        }
    }
}