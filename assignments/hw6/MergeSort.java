public class MergeSort extends SortAlgorithm {
    public MergeSort(int[] input_array) {
        super(input_array);
    }

    private void merge(int arr[], int l, int m, int r) {
        int n1 = m - l + 1; // size of left subarray
        int n2 = r - m; // size of right subarray

        int[] L = new int[n1]; // create left subarray
        int[] R = new int[n2]; // create right subarray

        for (int i = 0; i < n1; ++i) // copy data to left subarray
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j) // copy data to right subarray
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0; 

        int k = l; // initial index of merged subarray
        while (i < n1 && j < n2) { // merge the subarrays
            comparison_counter++; // increment comparison counter
            if (L[i] <= R[j]) { // compare elements from left and right subarrays
                arr[k] = L[i];
                i++;
            } else { // if right element is smaller
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) { // copy remaining elements of L[] if any
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) { // copy remaining elements of R[] if any
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    private void sort(int arr[], int l, int r) {
        if (l < r) { // check if there are more than 1 elements
            int m = (l + r) / 2; // find the middle point

            sort(arr, l, m); // sort first and second halves
            sort(arr, m + 1, r); // sort first and second halves

            merge(arr, l, m, r); // merge the sorted halves
        }
    }

    @Override
    public void sort() {
        sort(arr, 0, arr.length - 1); // call the recursive sort function
    }

    @Override
    public void print() {
        System.out.print("Merge Sort\t=>\t");
        super.print();
    }
}
