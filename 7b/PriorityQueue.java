import java.util.Comparator;

public class PriorityQueue<T> {
    private Node<T>[] heap;
    private int size;
    private final Comparator<T> comparator;

    @SuppressWarnings("unchecked")
    public PriorityQueue(int capacity, Comparator<T> comparator) {
        heap = (Node<T>[]) new Node[capacity + 1];
        size = 0;
        this.comparator = comparator;
    }

    public void offer(T element) {
        if (size == heap.length - 1) {
            resize();
        }
        heap[++size] = new Node<>(element);
        percolateUp(size);
    }

    public T poll() {
        if (size == 0) {
            throw new RuntimeException("Priority queue is empty");
        }
        T element = heap[1].data;
        heap[1] = heap[size--];
        heap[size + 1] = null; // Avoid loitering
        percolateDown(1);
        return element;
    }

    public T peek() {
        if (size == 0) {
            throw new RuntimeException("Priority queue is empty");
        }
        return heap[1].data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void percolateUp(int index) {
        while (index > 1) {
            int parentIndex = index / 2;
            if (comparator.compare(heap[index].data, heap[parentIndex].data) >= 0) {
                break;
            }
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    private void percolateDown(int index) {
        while (index * 2 <= size) {
            int childIndex = index * 2;
            if (childIndex + 1 <= size && comparator.compare(heap[childIndex].data, heap[childIndex + 1].data) > 0) {
                childIndex++;
            }
            if (comparator.compare(heap[index].data, heap[childIndex].data) <= 0) {
                break;
            }
            swap(index, childIndex);
            index = childIndex;
        }
    }

    private void swap(int i, int j) {
        Node<T> temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        Node<T>[] newHeap = (Node<T>[]) new Node[heap.length * 2];
        System.arraycopy(heap, 0, newHeap, 0, heap.length);
        heap = newHeap;
    }

    private static class Node<T> {
        T data;

        Node(T data) {
            this.data = data;
        }
    }
}
