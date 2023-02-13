package algorithm;

/**
 * 병합 정렬
 * 참고 사이트 : https://yunmap.tistory.com/entry/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-Java%EB%A1%9C-%EA%B5%AC%ED%98%84%ED%95%98%EB%8A%94-%EC%89%AC%EC%9A%B4-Merge-Sort-%EB%B3%91%ED%95%A9-%EC%A0%95%EB%A0%AC-%ED%95%A9%EB%B3%91-%EC%A0%95%EB%A0%AC
 * O(NlogN) -> 이진 트리로 분할하며, 이진 트리의 높이는 log N -> 분할 이후 병합과정에서 N번의 연산을 통해 정렬
 */
public class MergeSort {

    public static int[] array;
    public static int[] tempArray;

    public static void main(String[] args) {
        array = new int[]{5,9,3,1,2,8,4,7,6};
        tempArray = new int[array.length];
        mergeSort(0, array.length - 1);

        //결과 출력
        for (int i : array) {
            System.out.printf(i + " ");
        }
    }
    
    public static void mergeSort(int start, int end) {
        
        //재귀 함수 호출 조건
        if(start < end) {
            int mid = (start + end) / 2;
            mergeSort(start, mid); //재귀함수 왼쪽 분할
            mergeSort(mid + 1, end); //재귀함수 오른쪽 분할

            int leftIdx = start; //왼쪽 분할 리스트(배열)의 첫번째 인덱스 값
            int rightIdx = mid + 1; //오른쪽 분할 리스트(배열)의 첫번째 인덱스 값
            int tempArrayIdx = leftIdx; //정렬된 값을 temp배열에 순서대로 저장하기 위한 인덱스 값

            //양쪽 리스트 모두 탐색했을 때 실행 X
            while (leftIdx <= mid || rightIdx <= end) {
                //오른쪽 리스트 탐색이 먼저 전부 이루어졌을 경우에나 왼쪽 리스트 탐색이 전부 이루어지지않았으며, 왼쪽리스트 인덱스 내부 값이 오른쪽 리스트 인덱스 내부 값보다 작은 경우
                //temp배열에 왼쪽 리스트 인덱스 내부 값 할당
                if(rightIdx > end || (leftIdx <= mid && array[leftIdx] < array[rightIdx])) {
                    tempArray[tempArrayIdx++] = array[leftIdx++];
                }else {
                    //아니라면(오른쪽 리스트 탐색이 덜 이루어졌으며, 왼쪽리스트 탐색이 전부 이루어졌거나 왼쪽리스트 내부 값보다 오른쪽 리스트 내부 값이 작은 경우)
                    tempArray[tempArrayIdx++] = array[rightIdx++];
                }
            }

            for (int i = start; i <= end; i++) {
                array[i] = tempArray[i];
            }
        }
    }
}
