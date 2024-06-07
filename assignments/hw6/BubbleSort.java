public class BubbleSort extends SortAlgorithm {

	public BubbleSort(int[] input_array) {
		super(input_array);
	}

    /**
     * Sort the array using Bubble Sort algorithm.
     * Swap the adjacent elements if they are in wrong order.
     */
    @Override
    public void sort() {
        int n = arr.length; // get the length of the array
        boolean swapped;
        for (int i = 0; i < n - 1; i++) { // loop through the array
            swapped = false; 
            for (int j = 0; j < n - i - 1; j++) { // loop through the array
                comparison_counter++; // increment comparison counter
                if (arr[j] > arr[j + 1]) { // compare adjacent elements
                    swap(j, j + 1); // swap the elements
                    swapped = true; // set swapped to true
                }
            }
            // If no two elements were swapped by inner loop, then the array is sorted.
            if (!swapped) break;
        }
    }
    
    @Override
    public void print() {
    	System.out.print("Bubble Sort\t=>\t");
    	super.print();
    }
}
