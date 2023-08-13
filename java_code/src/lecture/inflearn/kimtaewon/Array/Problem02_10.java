package lecture.inflearn.kimtaewon.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 10. 봉우리
 */
public class Problem02_10 {

    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        solution();
    }
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] array = new int[N][N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int currentValue;
        int answer = 0;
        boolean flag;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                currentValue = array[i][j];
                flag = true;

                for(int k = 0; k < 4; k++) {
                    int nx = dx[k] + i;
                    int ny = dy[k] + j;

                    if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
                        if(currentValue <= array[nx][ny]) {
                            flag = false;
                            break;
                        }
                    }
                }

                if(flag) answer++;
            }
        }

        System.out.println(answer);

        br.close();
    }


}
