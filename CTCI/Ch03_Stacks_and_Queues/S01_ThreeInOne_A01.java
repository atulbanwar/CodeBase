package CodeBase.CTCI.Ch03_Stacks_and_Queues;

import java.util.EmptyStackException;

/**
 * Three In One - Approach 01
 * Problem: Describe how could you use a single array to implement three stacks.
 * This class is used to create a fixed size stack using an array.
 * Drawback: You could face a situation where you cannot push more elements into one stack as it is full,
 * while there are empty space in the array which is allocated to other stacks.
 *
 * @author Atul Banwar
 * @version 1.0
 */
class FixedMultiStack {
    private int numOfStacks = 3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    FixedMultiStack(int sizeOfStack) {
        this.stackCapacity = sizeOfStack;
        values = new int[numOfStacks * sizeOfStack];
        sizes = new int[numOfStacks];
    }

    void push(int stackNum, int data) {
        if (isFull(stackNum)) throw new StackFullException();

        sizes[stackNum]++;
        values[getTopIndex(stackNum)] = data;
    }

    int pop(int stackNum) {
        if (isEmpty(stackNum)) throw new EmptyStackException();

        int data = values[getTopIndex(stackNum)];
        values[getTopIndex(stackNum)] = 0;
        sizes[stackNum]--;

        return data;
    }

    int peek(int stackNum) {
        if (isEmpty(stackNum)) throw new EmptyStackException();

        return values[getTopIndex(stackNum)];
    }

    private int getTopIndex(int stackNum) {
        return (stackNum * stackCapacity) + sizes[stackNum] - 1;
    }

    private boolean isFull(int stackNum) {
        return sizes[stackNum] == stackCapacity;
    }

    private boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }
}

class StackFullException extends RuntimeException {}

public class S01_ThreeInOne_A01 {
    public static void main(String[] args)  {
        FixedMultiStack stack = new FixedMultiStack(3);

        stack.push(0, 1);
        System.out.print("\nStack 1 Top Element: " + stack.peek(0));

        stack.push(0, 2);
        System.out.print("\nStack 1 Top Element: " + stack.peek(0));

        stack.push(0, 3);
        System.out.print("\nStack 1 Top Element: " + stack.peek(0));

        try {
            stack.push(0, 4);
        } catch (StackFullException ex) {
            System.out.print("\nCaught StackFullException on push of Stack 1");
        }

        stack.push(1, 4);
        System.out.print("\nStack 2 Top Element: " + stack.peek(1));

        stack.push(1, 5);
        System.out.print("\nStack 2 Top Element: " + stack.peek(1));

        stack.push(1, 6);
        System.out.print("\nStack 2 Top Element: " + stack.peek(1));

        try {
            stack.push(0, 7);
        } catch (StackFullException ex) {
            System.out.print("\nCaught StackFullException on push of Stack 2");
        }

        stack.push(2, 7);
        System.out.print("\nStack 3 Top Element: " + stack.peek(2));

        stack.push(2, 8);
        System.out.print("\nStack 3 Top Element: " + stack.peek(2));

        stack.push(2, 9);
        System.out.print("\nStack 3 Top Element: " + stack.peek(2));

        try {
            stack.push(0, 10);
        } catch (StackFullException ex) {
            System.out.print("\nCaught StackFull Exception on push of Stack 3");
        }

        System.out.print("\nStack 1 Pop Element: " + stack.pop(0));
        System.out.print("\nStack 1 Pop Element: " + stack.pop(0));
        System.out.print("\nStack 1 Pop Element: " + stack.pop(0));

        try {
            stack.pop(0);
        } catch (EmptyStackException ex) {
            System.out.print("\nCaught EmptyStackException on pop of Stack 1");
        }

        System.out.print("\nStack 2 Pop Element: " + stack.pop(1));
        System.out.print("\nStack 2 Pop Element: " + stack.pop(1));
        System.out.print("\nStack 2 Pop Element: " + stack.pop(1));

        try {
            stack.pop(1);
        } catch (EmptyStackException ex) {
            System.out.print("\nCaught EmptyStackException on pop of Stack 2");
        }

        System.out.print("\nStack 3 Pop Element: " + stack.pop(2));
        System.out.print("\nStack 3 Pop Element: " + stack.pop(2));
        System.out.print("\nStack 3 Pop Element: " + stack.pop(2));

        try {
            stack.pop(2);
        } catch (EmptyStackException ex) {
            System.out.print("\nCaught EmptyStackException on pop of Stack 3");
        }

        stack.push(0, 1);
        System.out.print("\nStack 1 Top Element: " + stack.peek(0));
    }
}