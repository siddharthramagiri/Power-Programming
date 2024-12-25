package RecursionsKunal;
import java.util.Arrays;

public class RecursiveSort {
    public static void main(String[] args) {
        int[] arr = {6,7,3,5,11,1,4};
        System.out.println("Before Sorting");
        printArray(arr,0);
        Sort(arr);
//        Triangle(4,0);
//        int[] res = MergeSort(arr);
//        printArray(res, 0);

    }
    public static void Sort(int[] arr) {
        bubbleSort(arr, 0, 1);
        System.out.println("\nAfter Bubble Sort");
        printArray(arr, 0);
        selectionSort(arr, 0, arr.length - 1, 0);
        System.out.println("\nAfter Selection Sort");
        printArray(arr, 0);
        MergeSortInplace(arr, 0, arr.length);
        System.out.println("\nAfter Merge Sort");
        printArray(arr, 0);
    }

    public static void MergeSortInplace(int[] arr, int left, int right) {
        if(right - left == 1) return;
        int mid = left + (right - left) / 2;
        MergeSortInplace(arr, left, mid);
        MergeSortInplace(arr, mid, right);
        MergeInplace(arr,left,mid,right);
    }
    public static void MergeInplace(int[] arr, int l, int m, int r) {
        int[] mixed = new int[r - l];
        int i = l,j = m,k = 0;
        while(i < m && j < r) {
            if(arr[i] < arr[j]) {
                mixed[k] = arr[i]; i++;
            } else {
                mixed[k] = arr[j]; j++;
            }
            k++;
        }
        while(i < m) {
            mixed[k] = arr[i];
            i++;k++;
        }
        while(j < r) {
            mixed[k] = arr[j];
            j++;k++;
        }
        for(i = 0; i < mixed.length; i++)
            arr[i + l] = mixed[i];

    }

    public static int[] MergeSort(int[] arr) {
        if (arr.length == 1)
            return arr;
        int mid = arr.length / 2;
        int[] leftArr = MergeSort(Arrays.copyOfRange(arr,0,mid));
        int[] rightArr = MergeSort(Arrays.copyOfRange(arr,mid,arr.length));
        //   To Merge the Splited Arrays
        return MergeTwo(arr, leftArr, rightArr);
    }
    public static int[] MergeTwo(int[] arr, int[] first, int[] second) {
        int[] merged = new int[first.length + second.length];
        int i = 0, j = 0, k = 0;
        while(i < first.length && j < second.length) {
            if(first[i] < second[j]) {
                merged[k] = first[i];
                i++;
            } else {
                merged[k] = second[j];
                j++;
            }
            k++;
        }
        while(i < first.length) {
            merged[k] = first[i];
            i++;k++;
        }
        while(j < second.length) {
            merged[k] = second[j];
            j++;
            k++;
        }
        return merged;
    }
    public static void selectionSort(int[] arr, int i, int lastIdx, int maxIdx) {
        if (lastIdx == 0) return;
        if(i <= lastIdx) {
            if(arr[maxIdx] < arr[i]) {
                maxIdx = i;
            }
            selectionSort(arr, i+1, lastIdx, maxIdx);
        } else {
            int max = arr[maxIdx];
            arr[maxIdx] = arr[lastIdx];
            arr[lastIdx] = max;
            selectionSort(arr,0,lastIdx - 1, 0);
        }
    }

    public static void bubbleSort(int[] arr, int i, int j) {
        if(i == arr.length - 1) {
            return;
        }
        if(j < arr.length) {
            if (arr[i] >= arr[j]) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            bubbleSort(arr, i, j + 1);
        } else {
            bubbleSort(arr, i + 1, i + 2);
        }
    }

    static void printArray(int[] arr, int i) {
        if(i >= arr.length) {
            return;
        }
        System.out.print(arr[i] + " ");
        printArray(arr,i + 1);
    }

    public static void Triangle(int r, int c) {
        if (r == 0) {
            return;
        }
        if (c < r) {
            System.out.print("* ");
            Triangle(r, c + 1);
        } else {
            System.out.println();
            Triangle(r-1,0);
        }
    }
}
