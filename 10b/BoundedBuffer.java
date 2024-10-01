import java.util.LinkedList;
import java.util.Queue;

public class BoundedBuffer {
    private final int capacity;
    private final Queue<Integer> buffer;

    public BoundedBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new LinkedList<>();
    }

    // Producer method to add an item to the buffer
    public synchronized void put(int item) throws InterruptedException {
        // Wait if the buffer is full
        while (buffer.size() == capacity) {
            System.out.println(Thread.currentThread().getName() + " waiting, buffer full...");
            wait();
        }
        // Add the item to the buffer
        buffer.add(item);
        System.out.println(Thread.currentThread().getName() + " produced: " + item);

        // Notify the consumer that a new item is available
        notifyAll();
    }

    // Consumer method to remove an item from the buffer
    public synchronized int take() throws InterruptedException {
        // Wait if the buffer is empty
        while (buffer.isEmpty()) {
            System.out.println(Thread.currentThread().getName() + " waiting, buffer empty...");
            wait();
        }
        // Remove the item from the buffer
        int item = buffer.poll();
        System.out.println(Thread.currentThread().getName() + " consumed: " + item);

        // Notify the producer that space is available
        notifyAll();
        return item;
    }
}
