public class SelectionSort {

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int swapElem(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
        return index1;
    }

    public static void main(String[] args) {
        int arr[] = {7,8,3,1,2};

        //Selection sort
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }

            }
            swapElem(arr, i, minIndex);


            System.out.print("\nAfter " + (i + 1) + " iterations : ");
            printArray(arr);

        }
        System.out.print("\nThe final sorted array is: ");
        printArray(arr);
    }
}
