package com.company.leetcodesolutions.design;

import java.util.Stack;

public class MinStack {
    private final Stack<Integer> stack;
    private final Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();

    }

    public void push(int val) {
        int min = val;
        //push only the minimum value. For minimum value, Compare the current value with the value present at the top of the stack.
        if (!minStack.isEmpty() && min > minStack.peek()) {
            min = minStack.peek();
        }
        stack.push(val);
        minStack.push(min);

    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();

    }
}
