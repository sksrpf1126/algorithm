package lecture.inflearn.kimtaewon.section_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/**
 * 8. 송아지 찾기
 */
public class Problem07_08 {

    public static int S, E, answer;
    public static boolean[] visits = new boolean[10001];
    public static int[] dis = {-1, 1, 5};

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        bfs();

        System.out.println(answer);
    }

    public static void bfs() {
        Queue<Position> q = new LinkedList<>();
        q.add(new Position(S, 0));
        visits[S] = true;

        while (!q.isEmpty()) {
            Position currentPosition = q.poll();

            if(currentPosition.xPos == E) {
                answer = currentPosition.jumpCount;
                return;
            }

            //아래의 if문보다 간결하며, if문 반복수를 줄일 수 있음
            for(int i = 0; i < 3; i++) {
                int nx = currentPosition.xPos + dis[i];

                if(nx >= 1 && nx <= 10000 && !visits[nx]) {
                    q.offer(new Position(nx, currentPosition.jumpCount + 1));
                    visits[nx] = true;
                }
            }

//            if(currentPosition.xPos + 1 <= 10000 && !visits[currentPosition.xPos + 1] ) {
//                q.offer(new Position(currentPosition.xPos + 1, currentPosition.jumpCount + 1));
//                visits[currentPosition.xPos + 1] = true;
//            }
//            if(currentPosition.xPos - 1 > 0 && !visits[currentPosition.xPos - 1]) {
//                q.offer(new Position(currentPosition.xPos - 1, currentPosition.jumpCount + 1));
//                visits[currentPosition.xPos - 1] = true;
//            }
//            if(currentPosition.xPos + 5 <= 10000 && !visits[currentPosition.xPos + 5]) {
//                q.offer(new Position(currentPosition.xPos + 5, currentPosition.jumpCount + 1));
//                visits[currentPosition.xPos + 5] = true;
//            }

        }

    }


}

class Position {
    int xPos;
    int jumpCount;

    public Position(int xPos, int jumpCount) {
        this.xPos = xPos;
        this.jumpCount = jumpCount;
    }
}
