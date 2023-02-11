package baekjoon.greedy.gold.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 골드 5
 * 도서관
 *
 * 맞추긴 했지만 다른 분의 풀이를 보고 더 쉬운 방법이 있어 추가한다.(내 풀이 : mySolution 메서드, 다른 분의 풀이 : solution())
 *
 * https://hello-backend.tistory.com/m/129 참고
 *
 * 우선순위 큐를 쓰든 ArrayList를 쓰든 선택이지만 다른 분과의 차이점은
 * 나는 왼쪽과 오른쪽 끝을 찾아서, 반복문 안에서 둘의 값을 비교하여 더 큰 값(거리가 제일 먼 곳)을 가지고 있는 방향의 반대편부터 처리하도록 하였지만
 * 다른 분은 더 깔끔하게 왼쪽과 오른쪽 끝을 찾고, Math.max로 더 큰 값을 변수에 할당시킨다. 그리고는 짧은 쪽, 긴 쪽 구분 없이 각각 반복문을 그냥 돌린다.
 *
 * 다음으로, 나는 한쪽 방향에서 책의 수만큼 나누어 떨어지지 않는다면 나머지 만큼 작은 값에서부터 해당 인덱스만큼 *2를 반환하였지만
 * 다른 분은 그냥 우선순위 큐를 역순으로 정렬해서  가장 긴 값 * 2를 더하고, 이후 책의 수만큼 뺀다.
 * 이를 왼쪽 방향 큐 오른쪽 방향 큐 각각 따로 반복문을 돌리며, 전부 * 2를 해서 계산하고 마지막에 위에서 가장 긴 거리의 값을 한번 뺴준다.
 *
 * 핵심은 예를들어 오른쪽 방향으로 5개가 있고, M 값이 2 일 때 위에서 말했듯이 나는
 * 1 - 2 - 2로 앞에서부터 짤랐지만 그냥 이럴필요 없이 역순으로 정렬해서 2 - 2 - 1(나머지) 로 해도 되는 것이었다.
 *
 */
public class Problem1461 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sToken = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(sToken.nextToken());
        int M = Integer.parseInt(sToken.nextToken());
        PriorityQueue<Integer> leftPq = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> rightPq = new PriorityQueue<>(Collections.reverseOrder());
        int endPoint = 0;

        sToken = new StringTokenizer(br.readLine());

        for(int i = 0; sToken.hasMoreTokens(); i++) {
            Integer distance = Integer.valueOf(sToken.nextToken());
            if(distance < 0) {
                leftPq.add(Math.abs(distance));
            }else {
                rightPq.add(distance);
            }
        }

        //왼쪽 오른족 긴 값 비교할 필요 없이 그냥 가장 긴 값을 가직 있는다.
        if(!leftPq.isEmpty()) {
            endPoint = leftPq.peek();
        }else if(!rightPq.isEmpty()){
            endPoint = rightPq.peek();
        }else{
            endPoint = Math.max(leftPq.peek(), rightPq.peek());
        }

        int answer = 0;

        //왼쪽을 내림차순으로 맨끝 * 2를 더하며, 책의 운반 수만큼 뺀다.
        //이러면 나머지가 떨어지는지 안떨어지는지 검사할 필요가 없다.
        while (!leftPq.isEmpty()) {
            answer += leftPq.peek() * 2;
            for(int i = 0; i < M; i++) {
                leftPq.poll();
            }
        }

        //오른쪽도 동일
        while (!rightPq.isEmpty()) {
            answer += rightPq.peek() * 2;
            for(int i = 0; i < M; i++) {
                rightPq.poll();
            }
        }

        //마지막에는 0으로 돌아올 필요가 없으므로 enoPoint를 한 번 빼준다...
        answer -= endPoint;

        System.out.println(answer);

        br.close();
    }


    public static void mySolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sToken = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(sToken.nextToken());
        int M = Integer.parseInt(sToken.nextToken());
        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();
        int answer = 0;
        int leftEnd = 0;
        int rightEnd = 0;

        sToken = new StringTokenizer(br.readLine());

        for(int i = 0; sToken.hasMoreTokens(); i++) {
            Integer distance = Integer.valueOf(sToken.nextToken());
            if(distance < 0) {
                distance = Math.abs(distance);
                leftList.add(distance);
                if(leftEnd < distance) {
                    leftEnd = distance;
                }
            }else {
                rightList.add(distance);
                if(rightEnd < distance) {
                    rightEnd = distance;
                }
            }
        }

        Collections.sort(leftList);
        Collections.sort(rightList);

        while (!leftList.isEmpty() || !rightList.isEmpty()) {
            if(leftList.isEmpty() || (!rightList.isEmpty() && leftEnd > rightEnd)) {
                //왼쪽이 없는 경우나 왼쪽이 더 클 경우 오른쪽 책들부터 비운다.
                if(rightList.size() <= M){
                    if(leftList.isEmpty()) {
                        answer += rightList.get(rightList.size() - 1);
                    }else{
                        answer += rightList.get(rightList.size() - 1) * 2;
                    }
                    rightList.clear();
                } else if(rightList.size() % M != 0) {
                    int mod = rightList.size() % M;
                    answer += rightList.get(mod - 1) * 2;
                    rightList.subList(0, mod).clear();
                }else {
                    answer += rightList.get(M - 1) * 2;
                    rightList.subList(0, M).clear();
                }
            }else {
                //왼쪽에 책들이 존재하면서, 오른쪽이 끝났을 경우나, 오른쪽이 같거나 더 클 경우 왼쪽 책들을 비운다.
                if(leftList.size() <= M){
                    if(rightList.isEmpty()) {
                        answer += leftList.get(leftList.size() - 1);
                    }else{
                        answer += leftList.get(leftList.size() - 1) * 2;
                    }
                    leftList.clear();
                } else if(leftList.size() % M != 0) {
                    int mod = leftList.size() % M;
                    answer += leftList.get(mod - 1) * 2;
                    leftList.subList(0, mod).clear();
                }else {
                    answer += leftList.get(M - 1) * 2;
                    leftList.subList(0, M).clear();
                }
            }
        }

        System.out.println(answer);

        br.close();
    }

}
