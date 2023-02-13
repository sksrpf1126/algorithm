package algorithm;

/**
 * 선택 정렬
 * 최솟값을 찾고, 최소값의 위치와 앞에서부터의 위치와 자리를 교체하는 알고리즘
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5,9,3,1,2,8,4,7,6};
        int temp = 0;

        for(int i = 0; i < arr.length; i++) {
            int min = i;
            for(int j = i; j < arr.length; j++) {
                if(arr[min] > arr[j]) {
                    min = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }

        for (int i : arr) {
            System.out.printf(i + " ");
        }

    }
}
