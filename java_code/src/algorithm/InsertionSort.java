package algorithm;

/**
 * 삽입 정렬
 * 배열이 이미 정렬이 되어 있는 경우 while문의 비교연산만 실행하고, 반복은 실행이 안되므로 O(n)의 시간복잡도를 가지게 된다.
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {5,9,3,1,2,8,4,7,6};

        for(int i = 1; i < arr.length; i++) {
            int target = arr[i];
            int j = i - 1;

            while (j >= 0 && target < arr[j]) {
                arr[j+1] = arr[j];
                j--;
            }

            arr[j+1] = target;

        }


        for (int i : arr) {
            System.out.printf(i + " ");
        }
    }
}
