
/**
 * This class implements a heap sort algorithm
 *
 * @author abdirahmanmohamed
 *
 */
public class heapSort {
    protected static int comparisons;
    private int[] heap;
    private int size;
    /**
     * Constructs a heap with the specified capacity.
     *
     * @param capacity The capacity of the heap.
     */
    public heapSort(int capacity){
        this.heap = new int[capacity];
        this.size = 0;
        this.comparisons = 0;
    }


    /**
     * Returns a copy of the heap array.
     * @return A copy of the heap array.
     */
    public int[] getHeap(){
        return heap.clone();
    }

    private int leftChild(int index){
        return 2 * index + 1;
    }
    private int rightChild(int index){
        return 2 * index + 2;
    }
    private int parent(int index){
        return (index -1) / 2;
    }
    private void swap(int index1, int index2){
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }
    /**
     * Inserts a value into the heap.
     * @param value The value to be inserted.
     */
    public void insert(int value){
        heap[size] = value;
        int current = size;
        size++;
        while(current > 0 && heap[current] > heap[parent(current)]){
            comparisons++;
            swap(current, parent(current));
            current = parent(current);
        }
    }
    private void heapify(int index) {
        int largest = index;
        int left = leftChild(index);
        int right = rightChild(index);

        if (left < size && heap[left] > heap[largest]) {
            comparisons++;
            largest = left;
        }

        if (right < size && heap[right] > heap[largest]) {
            comparisons++;
            largest = right;
        }

        if (largest != index) {
            swap(index, largest);
            heapify(largest);
        }
    }

    public void sort() {
        comparisons = 0;
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(i);
        }

        for (int i = size - 1; i >= 0; i--) {
            comparisons++;
            swap(0, i);
            size--;
            heapify(0);
        }
    }
    public static int getComparisons() {
        return comparisons;
    }
    /**
     * Prints the contents of the heap.
     */
    public void printHeap() {
        for (int i = 0; i < heap.length; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create an instance of heapSort
        int[] arr = {1, 4, 5, 2, 3, 6,7,0}; // Unsorted array

        heapSort hs = new heapSort(arr.length);


        // Insert elements into the heap
        for (int element : arr) {
            hs.insert(element);

        }

        System.out.println("Unsorted Array:");
        hs.printHeap(); // Print the unsorted array


        // Sort the heap in ascending order
        hs.sort();


        System.out.println("\nSorted Array:");
        hs.printHeap(); // Print the sorted array

        System.out.println(" number of comparisons "+hs.comparisons);

    }

}
