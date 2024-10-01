public class BoundedBufferApp {
    public static void main(String[] args) {
        // Create a bounded buffer with a capacity of 10 items
        BoundedBuffer buffer = new BoundedBuffer(10);

        // Create producer and consumer objects
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);

        // Create and start producer and consumer threads
        Thread producerThread = new Thread(producer, "Producer");
        Thread consumerThread = new Thread(consumer, "Consumer");

        producerThread.start();
        consumerThread.start();

        try {
            // Wait for both threads to complete
            producerThread.join();
        3    consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
