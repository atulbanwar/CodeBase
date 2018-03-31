package CodeBase.DataStructures;

import java.util.EmptyStackException;

/**
 * Stack
 * This class implements Stack data structure concept.
 *
 * @author Atul Banwar
 * @version 1.0
 */
public class Stack<T> {
    /**
     * Access modifier is set to public to allow extension of Stack functionality in CTCI problems.
     * In real world, instead of public variables, public Getter and Setter methods should be used.
     * It's avoided here to keep the implementation of new functionality in CTCI solutions simple and easy to understand.
     */
    protected static class StackNode<T> {
        public T data;
        public StackNode<T> next;

        StackNode(T data) {
            this.data = data;
        }
    }

    protected StackNode<T> top;

    public void push(T data) {
        StackNode<T> node = new StackNode<>(data);

        if (top == null) {
            top = node;
        } else {
            node.next = top;
            top = node;
        }
    }

    public T pop() {
        if (top == null) throw new EmptyStackException();

        T data;
        data = top.data;
        top = top.next;

        return data;
    }

    public T peek() {
        if (top == null) throw new EmptyStackException();

        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public String toString() {
        if (top == null) return "<STACK IS EMPTY>";

        StringBuilder output = new StringBuilder();
        StackNode current = top;
        if (current != null) {
            output.append(top.data);
            current = current.next;

            while (current != null) {
                output.append(" -> ");
                output.append(current.data);
                current = current.next;
            }
        }

        return output.toString();
    }
}

class StackTest {
    public static void main(String[] args) {
        System.out.println("Creating Stack");
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.print("Printing Stack: ");
        System.out.print(stack.toString());

        System.out.print("\nPeeking Stack element: ");
        System.out.print(stack.peek());

        System.out.print("\nStack Is Empty?: ");
        System.out.print(stack.isEmpty());

        System.out.print("\nRemoving Stack element: ");
        System.out.print(stack.pop());

        System.out.print("\nPrinting Stack: ");
        System.out.print(stack.toString());

        System.out.print("\nRemoving Stack element: ");
        System.out.print(stack.pop());

        System.out.print("\nRemoving Stack element: ");
        System.out.print(stack.pop());

        System.out.print("\nStack Is Empty?: ");
        System.out.print(stack.isEmpty());

        System.out.print("\nPrinting Stack: ");
        System.out.print(stack.toString());

        try {
            System.out.print("\nPeeking empty Stack: ");
            System.out.print(stack.peek());
        } catch (EmptyStackException ex) {
            System.out.print("EmptyStackException Caught!");
        }
    }
}