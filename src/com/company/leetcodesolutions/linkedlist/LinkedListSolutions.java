package com.company.leetcodesolutions.linkedlist;

import java.util.Stack;

public class LinkedListSolutions {
    Node head;

    static class Node {
        int val;
        Node next;

        Node() {
        }

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public int getDecimalValue(Node head) {
        int x = 0;
        while (head != null) {
            x = x * 2 + head.val;
            head = head.next;
        }
        return x;
    }

    public Node middleNode(Node head) {
        //init two nodes as head element
        Node slow_ptr = head;
        Node fast_ptr = head;
        //Iterate both until they reach end of the LinkedList
        while (fast_ptr != null && fast_ptr.next != null) {
            fast_ptr = fast_ptr.next.next;
            slow_ptr = slow_ptr.next;
        }
        return slow_ptr;
    }

    public void deleteNode(Node node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    //We need to reverse the list by changing the links between nodes.
    public Node reverseList(Node head) {
        /* Given a list
         * 1 2 3 4 5 6 7 8
         * prev = null
         * current = 1
         * next = current.next (2)
         */
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            //change the LINK from next to the prev LINK
            current.next = prev;
            //move links of the PREVIOUS to the HEAD link
            prev = current;
            //change the current link to the NEXT
            current = next;
        }
        head = prev;
        return head;
    }

    public Node mergeInBetween(Node list1, int a, int b, Node list2) {
        //Consider at which index do we have counter 'a' and 'b' values
        int counter = 1;
        //That is the list which we will iterate
        Node current = list1;
        //Store 2 modes that we should change
        Node head = null;
        Node last = null;
        //traverse the first list
        while (current != null) {
            //
            if (counter == a) {
                head = current;
            }
            if (counter == b) {
                last = current.next.next;
                break;
            }
            counter++;
            current = current.next;
        }
        //Now as we have pointers of 2 nodes ,initialize them
        head.next = list2;
        current.next = list2;
        //get the last element by traversing through the list
        while (current.next != null) {
            current = current.next;
        }
        current.next = last;
        return list1;
    }

    //To delete the last node of a linked list, find the second last node and make the next pointer of that node null.
    public Node deleteLastNode(Node head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return null;
        }
        //find the second last node
        Node node = head;
        while (node.next.next != null)
            node = node.next;
        //change link of second last
        node.next = null;

        return head;
    }

    public void deleteIndexNode(int k) {
        if (head == null)
            return;
        Node temp = head;

        if (k == 0) {
            head = temp.next;
            return;
        }
        for (int i = 0; temp != null && i < k - 1; i++) {
            temp = temp.next;
            if (temp == null || temp.next == null)
                return;
            temp.next = temp.next.next;
        }
    }

    public boolean find(int k, Node head) {
        Node temp = head;
        while (temp != null) {
            if (head.val == k)
                return true;
            /* this line is used as increment operator in array i++
             * in LinkedList you iterate through the elements by links
             */
            temp = temp.next;
        }
        return false;
    }

    public void insertAfter(Node prev_List_node, int new_data) {
        if (prev_List_node == null) {
            System.out.println("The given previous node cannot be null");
            return;
        }
        Node new_List_node = new Node(new_data);
        new_List_node.next = prev_List_node.next;
        prev_List_node.next = new_List_node;
    }

    static int countNodes(Node n) {
        int res = 1;
        Node temp = n;
        while (temp.next != n) {
            res++;
            temp = temp.next;
        }
        return res;
    }

    boolean isPalindrome(Node head) {
        Node slow = head;
        boolean isPalindrome = true;
        Stack<Integer> stack = new Stack<>();
        //Traverse the given list from head to tail and push every visited node to stack.
        while (slow != null) {
            stack.push(slow.val);
            slow = slow.next;
        }
        /*
         * Traverse the list again. For every visited node, pop a node
         * from the stack and compare data of popped node with the currently visited node.
         * If all nodes matched, then return true, else false.
         */
        while (head != null) {
            int i = stack.pop();
            if (head.val == i) {
                isPalindrome = true;
            } else {
                isPalindrome = false;
                break;
            }
            head = head.next;
        }
        return isPalindrome;
    }

    public Node removeElements(Node head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }

        Node current_List_node = head;
        while (current_List_node != null && current_List_node.next != null) {
            if (current_List_node.next.val == val) {
                current_List_node.next = current_List_node.next.next;
            } else {
                current_List_node = current_List_node.next;
            }
        }
        return head;
    }

    public Node oddEvenList(Node head) {
        if (head == null) return null;
        Node odd = head;
        Node even = head.next;
        Node evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;

        return head;
    }

    public Node mergeTwoLists(Node list1, Node list2) {
        if (list1 == null && list2 == null)
            return null;

        Node res = null;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                Node temp = list1.next;
                list1.next = res;
                res = list1;
                list1 = temp;
            } else {
                Node temp = list2.next;
                list2.next = res;
                res = list2;
                list2 = temp;
            }
        }
        return head;
    }

    public int countNodes() {
        int count = 0;
        Node s = head;
        while (s != null) {
            count++;
            s = s.next;
        }
        return count;
    }

    public Node swapNodes(Node head, int k) {

        k = k - 1;
        Node firstN = head;
        while (k > 0) {
            firstN = firstN.next;
            k--;
        }

        Node f = firstN;
        Node secondN = head;
        while (f.next != null) {
            secondN = secondN.next;
            f = f.next;
        }

        int temp = firstN.val;
        firstN.val = secondN.val;
        secondN.val = temp;

        return head;
    }

    public Node rotateRight(Node head, int k) {
        //initialize two pointers
        Node slow = head;
        Node fast = head;
        //check if head is null
        if (head == null) {
            return null;
        }
        //This code wil give us the length of the LinkedList
        Node temp = head;
        int counter = 0;
        while (temp != null) {
            temp = temp.next;
            counter++;
        }
        //get offset of the list to do rotation
        k = k % counter;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = head;

        Node result = slow.next;
        slow.next = null;

        return result;
    }

    public Node deleteMiddle(Node head) {
        if (head == null || head.next == null) return null;
        Node slow = head, fast = head, prev = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        return head;
    }

    public Node addTwoNumbers(Node l1, Node l2) {
        Node dummy_List_node = new Node(0);
        Node l3 = dummy_List_node;

        int carry = 0;
        while (l1 != null || l2 != null) {
            int l1_val = (l1 != null) ? l1.val : 0;
            int l2_val = (l2 != null) ? l2.val : 0;

            int currentSum = l1_val + l2_val + carry;

            carry = currentSum / 10;
            int lastDigit = currentSum % 10;

            l3.next = new Node(lastDigit);

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;

            l3 = l3.next;
        }

        if (carry > 0) {
            l3.next = new Node(1);

            l3 = l3.next;
        }
        return dummy_List_node.next;
    }

    public Node reverse(Node head) {
        if (head == null) {
            return null;
        }
        Node a = head;
        Node b = head.next;

        if (b == null) {
            return head;
        }
        Node c = b.next;
        a.next = null;
        while (c != null) {
            b.next = a;
            a = b;
            b = c;
            c = c.next;
        }
        b.next = a;
        return b;
    }

    public int size(Node head) {
        if (head == null) {
            return 0;
        }
        return 1 + size(head.next);
    }

    public int pairSum(Node head) {
        int n = size(head);
        int p = n / 2;

        Node curr = head;
        for (int i = 0; i < p - 1; i++) {
            curr = curr.next;
        }

        Node x = curr.next;
        curr.next = null;
        Node otherHead = reverse(x);

        int max = 0;
        while (head != null) {
            int sum = head.val + otherHead.val;
            if (sum > max) {
                max = sum;
            }
            head = head.next;
            otherHead = otherHead.next;
        }
        return max;
    }

    public Node swapPairs(Node head) {
        Node temp = new Node(0);
        temp.next = head;
        Node current = temp;
        while (temp.next != null && current.next.next != null) {
            Node first = current.next;
            Node second = current.next.next;
            first.next = second.next;
            current.next = second;
            current.next.next = first;
            current = current.next.next;
        }
        return head;
    }

    public Node sortList(Node head) {
        if (head == null || head.next == null)
            return head;
        Node mid = getMid(head);
        Node left = sortList(head);
        Node right = sortList(mid);
        return merge(left, right);
    }

    public Node merge(Node list1, Node list2) {
        Node dummyHead = new Node();
        Node tail = dummyHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        tail.next = (list1 != null) ? list1 : list2;
        return dummyHead.next;
    }

    Node getMid(Node head) {
        Node midPrev = null;
        while (head != null && head.next != null) {
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }
        Node mid = midPrev.next;
        midPrev.next = null;
        return mid;
    }

    public Node insertionSortList(Node head) {
        Node node = new Node(-1);
        Node current = head;
        while (current != null) {
            Node temp = current.next;
            Node prev = node;
            Node next = node.next;
            while (next != null) {
                if (next.val > current.val)
                    break;
                prev = next;
                next = next.next;
            }

            current.next = next;
            prev.next = current;
            current = temp;
        }
        return node.next;
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;

        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                //skip the nodes whose values are equal to head
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                prev.next = head.next;
            } else {
                prev = prev.next;
            }
            head = head.next;
        }
        return dummy.next;
    }
}