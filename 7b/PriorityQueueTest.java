public class PriorityQueueTest {
    public static void main(String[] args) {
        // Testing with integers
        PriorityQueue<Integer> intPriorityQueue = new PriorityQueue<>(10, Integer::compare);
        intPriorityQueue.offer(5);
        intPriorityQueue.offer(2);
        intPriorityQueue.offer(8);
        intPriorityQueue.offer(3);
        System.out.println("Integer priority queue:");
        while (!intPriorityQueue.isEmpty()) {
            System.out.print(intPriorityQueue.poll() + " ");
        }
        System.out.println();

        // Testing with doubles
        PriorityQueue<Double> doublePriorityQueue = new PriorityQueue<>(10, Double::compare);
        doublePriorityQueue.offer(3.5);
        doublePriorityQueue.offer(1.2);
        doublePriorityQueue.offer(4.8);
        doublePriorityQueue.offer(2.1);
        System.out.println("Double priority queue:");
        while (!doublePriorityQueue.isEmpty()) {
            System.out.print(doublePriorityQueue.poll() + " ");
        }
        System.out.println();

        // Testing with strings
        PriorityQueue<String> stringPriorityQueue = new PriorityQueue<>(10, String::compareTo);
        stringPriorityQueue.offer("hello");
        stringPriorityQueue.offer("world");
        stringPriorityQueue.offer("abc");
        stringPriorityQueue.offer("def");
        System.out.println("String priority queue:");
        while (!stringPriorityQueue.isEmpty()) {
            System.out.print(stringPriorityQueue.poll() + " ");
        }
        System.out.println();
    }
}