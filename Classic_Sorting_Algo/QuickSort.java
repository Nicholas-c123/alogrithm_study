import java.util.Arrays;

public class QuickSort {
    public static int[] quickSort(int[] data) {
        if (data == null)
            return null;
        quickSort(data, 0, data.length - 1);
        return data;
    }

    public static void quickSort(int[] data, int start, int end) {
        int pivot = partition(data, start, end);
        if (pivot < end)
            quickSort(data, pivot + 1, end);
        if (pivot > start)
            quickSort(data, start, pivot - 1);
    }

    private static int partition(int[] data, int start, int end) {
        int pivot = data[start];
        while (start < end) {
            while (start < end && data[end] >= pivot)
                end--;
            data[start] = data[end];
            while (start < end && data[start] <= pivot)
                start++;
            data[end] = data[start];
        }
        data[start] = pivot;
        return start;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(quickSort(new int[]{3, 2, -1, 2, 10, 5, 5, 4, 100, 1})));
    }
}