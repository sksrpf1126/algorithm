package baekjoon.greedy.Silver.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem17615 {

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] ballArray = br.readLine().toCharArray();

        int redBall = 0, blueBall = 0;
        int answer = Integer.MAX_VALUE;

        for(char c : ballArray) {
            if(c == 'R') redBall++;
            else blueBall++;
        }

        int firstBallCount = 0;

        //빨간불을 왼쪽으로 옮기는 작업
        for(int i = 0; i < ballArray.length; i++) {
            if(ballArray[i] == 'R') {
                firstBallCount++;
            }else {
                break;
            }
        }

        answer = Math.min(answer, redBall - firstBallCount);
        firstBallCount = 0;

        //빨간불을 오른쪽으로 옮기는 작업
        for(int i = ballArray.length - 1; i >= 0; i--) {
            if(ballArray[i] == 'R') {
                firstBallCount++;
            }else {
                break;
            }
        }

        answer = Math.min(answer, redBall - firstBallCount);
        firstBallCount = 0;

        //빨간불을 왼쪽으로 옮기는 작업
        for(int i = 0; i < ballArray.length; i++) {
            if(ballArray[i] == 'B') {
                firstBallCount++;
            }else {
                break;
            }
        }

        answer = Math.min(answer, blueBall - firstBallCount);
        firstBallCount = 0;

        //파란불을 오른쪽으로 옮기는 작업
        for(int i = ballArray.length - 1; i >= 0; i--) {
            if(ballArray[i] == 'B') {
                firstBallCount++;
            }else {
                break;
            }
        }

        answer = Math.min(answer, blueBall - firstBallCount);

        System.out.println(answer);

        br.close();
    }

}
