package algorithm;

/**
 * 힙 정렬은 크게 1. 배열 -> 최대 힙 변환  2. 최대 힙 정렬(root노드가 최댓값인 것을 활용) 으로 이루어진다.
 * 참고 : https://herong.tistory.com/entry/%ED%9E%99-%EC%A0%95%EB%A0%ACHeap-Sort
 * O(NlonN)이며, 힙 자료구조를 활용하기 때문이다. (힙 자료구조는 완전이진트리로 구현되며, 높이는 최대 log N으로 이루어짐)
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {5,9,3,1,2,8,4,7,6};

        for(int i = arr.length / 2 - 1; i >= 0; i--) {
            heapify(arr, arr.length, i);
        }

        heapSort(arr);

        //정렬 검사
        for (int i : arr) {
            System.out.printf(i + " ");
        }

    }

    /**
     * 최대 힙 변환 이후 정렬 로직 실행 메서드
     * 1. 루트노드는 최댓값이며, 마지막 노드(마지막 인덱스 내부 값)와 루트노드를 바꾼다.
     * 2. 마지막 인덱스를 제외하고, 다시 최대 힙 정렬을 수행한다.
     * 3. 정렬이 될 때까지 반복 수행
     */
    public static void heapSort(int[] arr) {
        for(int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            //루트노드를 대상으로 최대 힙으로 변환
            heapify(arr, i, 0);
        }
    }


    public static void heapify(int[] arr, int maxLength, int parentIdx) {
        int leftChildIdx = parentIdx * 2 + 1;
        int rightChildIdx = parentIdx * 2 + 2;
        int parentIdxCopy = parentIdx;

        if (leftChildIdx < maxLength && arr[leftChildIdx] > arr[parentIdxCopy]) {
            parentIdxCopy = leftChildIdx;
        }

        if(rightChildIdx < maxLength && arr[rightChildIdx] > arr[parentIdxCopy]) {
            parentIdxCopy = rightChildIdx;
        }

        //부모노드와 자식노드가 변경이 되었다면
        if(parentIdxCopy != parentIdx) {
            swap(arr, parentIdx, parentIdxCopy);
            
            //자식과 부모노드가 바뀐 이후의 자식노드를 대상으로 서브트리 검사
            heapify(arr, maxLength, parentIdxCopy);
        }
    }

    public static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }
}
