public class SelectionSort extends SortAlgorithm {

	public SelectionSort(int input_array[]) {
		super(input_array);
	}

    @Override
    public void sort() {
        int n = arr.length;

        for (int i = 0; i < n-1; i++) {
            int min_idx = i;
            for (int j = i+1; j < n; j++) {
                comparison_counter++; // increment comparison counter
                if (arr[j] < arr[min_idx])
                    min_idx = j;
            }

            // swap min_idx with i
            swap(min_idx, i);
        }
    }

    @Override
    public void print() {
    	System.out.print("Selection Sort\t=>\t");
    	super.print();
    }
}
