package sortalgorithm;

/**
 * 버블 정렬 구현
 * 인접한 값과 비교하여 정렬하는 알고리즘
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5,9,3,1,2,8,4,7,6};
        int temp = 0;

        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = 1; j < arr.length - i; j++) {
                if(arr[j-1] > arr[j]) {
                   temp = arr[j];
                   arr[j] = arr[j-1];
                   arr[j-1] = temp;
                }
            }
        }

        for (int i : arr) {
            System.out.printf(i + " ");
        }

    }
}
