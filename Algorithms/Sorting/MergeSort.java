package CodeBase.Algorithms.Sorting;

/**
 * Merge Sort
 * This class implements Merge Sort algorithm.
 *
 * @author Atul Banwar
 * @version 1.0
 */
public class MergeSort {
    public static void sort(int[] arr) {
        int[] helper = new int[arr.length];
        sort(arr, helper, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int[] helper, int low, int high) {
        if (low < high) {
            int mid = (low + high)/ 2;
            sort(arr, helper, low, mid);
            sort(arr, helper, mid + 1, high);
            merge(arr, helper, low, mid, high);
        }
    }

    private static void merge(int[] arr, int[] helper, int low, int mid, int high) {
        int leftIndex = low;
        int rightIndex = mid+1;
        int sortIndex = low;

        for (int i = low; i <= high; i++) {
            helper[i] = arr[i];
        }

        while (leftIndex <= mid && rightIndex <= high) {
            if (helper[leftIndex] <= helper[rightIndex]) {
                arr[sortIndex] = helper[leftIndex];
                leftIndex++;
            } else {
                arr[sortIndex] = helper[rightIndex];
                rightIndex++;
            }

            sortIndex++;
        }

        int remaining = (mid + 1) - leftIndex;
        for (int i = 0; i < remaining; i++) {
            arr[sortIndex + i] = helper[leftIndex + i];
        }
    }
}

class MergeSortTest {
    public static void main(String[] args) {
        int[] arr = new int[] {8, 1, 3, 6, 7, 2, 5, 4};
        System.out.println("\nBefore Sorting: ");
        for (int item : arr) {
            System.out.print(item + " ");
        }

        MergeSort.sort(arr);

        System.out.println("\nAfter Sorting: ");
        for (int item : arr) {
            System.out.print(item + " ");
        }
    }
}
