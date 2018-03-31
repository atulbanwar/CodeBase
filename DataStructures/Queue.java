package CodeBase.DataStructures;

/**
 * Queue
 * This class implements Queue data structure concept.
 *
 * @author Atul Banwar
 * @version 1.0
 */
public class Queue<T> {
    /**
     * Access modifier is set to public to allow extension of Queue functionality in CTCI problems.
     * In real world, instead of public variables, public Getter and Setter methods should be used.
     * It's avoided here to keep the implementation of new functionality in CTCI solutions simple and easy to understand.
     */
    protected static class QueueNode<T> {
        public T data;
        public QueueNode<T> next;

        QueueNode(T data) {
            this.data = data;
        }
    }

    protected QueueNode<T> first;
    protected QueueNode<T> last;

    public void add(T data) {
        QueueNode<T> node = new QueueNode<>(data);

        if (last != null) {
            last.next = node;
        }

        last = node;
        if (first == null) {
            first = last;
        }
    }

    public T remove() {
        if (first == null) throw new QueueEmptyException();

        T data = first.data;
        first = first.next;
        if (first == null) {
            last = null;
        }
        return data;
    }

    public T peek() {
        if (first == null) {
            throw new QueueEmptyException();
        }

        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public String toString() {
        if (first == null) return "<QUEUE IS EMPTY>";

        StringBuilder output = new StringBuilder();
        QueueNode current = first;
        if (current != null) {
            output.append(first.data);
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

class QueueEmptyException extends RuntimeException {
}

class QueueTest {
    public static void main(String[] args) {
        System.out.println("Creating Queue");
        Queue<Integer> queue = new Queue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        System.out.print("Printing Queue: ");
        System.out.print(queue.toString());

        System.out.print("\nPeeking queue element: ");
        System.out.print(queue.peek());

        System.out.print("\nQueue Is Empty?: ");
        System.out.print(queue.isEmpty());

        System.out.print("\nRemoving Queue element: ");
        System.out.print(queue.remove());

        System.out.print("\nPrinting Queue: ");
        System.out.print(queue.toString());

        System.out.print("\nRemoving Queue element: ");
        System.out.print(queue.remove());

        System.out.print("\nRemoving Queue element: ");
        System.out.print(queue.remove());

        System.out.print("\nQueue Is Empty?: ");
        System.out.print(queue.isEmpty());

        System.out.print("\nPrinting Queue: ");
        System.out.print(queue.toString());

        try {
            System.out.print("\nPeeking empty Queue: ");
            System.out.print(queue.peek());
        } catch (QueueEmptyException ex) {
            System.out.print("QueueEmptyException Caught!");
        }
    }
}


