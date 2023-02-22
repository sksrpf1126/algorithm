package baekjoon.bfs.gold.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 골드 4
 * 이모티콘 (실패)
 *
 * 참고 : https://www.acmicpc.net/board/view/30100
 *
 * BFS에 대한 이해를 한 단계 발전시킨 문제였으며, 위에서 자세히 설명되어 있다.
 * 지금까지 푼 BFS문제는 하나의 상태에 대해서만 판단을 하여서 여러 상태일 때에는 어떻게 판단해야하는지를 몰랐다.
 *
 * 실패처리로 남겨놓음
 */
public class Problem14226 {

    static class Position {
        private int index;
        private int clipboard;
        private int time;

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getClipboard() {
            return clipboard;
        }

        public void setClipboard(int clipboard) {
            this.clipboard = clipboard;
        }

        public Position(int index, int clipboard, int time) {
            this.index = index;
            this.clipboard = clipboard;
            this.time = time;
        }
    }

//    public static int[] map = new int[2000];
    public static boolean[][] visits = new boolean[2000][2000];
    public static int S, answer = 0;


    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Integer.parseInt(br.readLine());

        bfs(1);

    }

    public static void bfs(int startPos) {
        Queue<Position> q = new LinkedList<>();

        q.offer(new Position(startPos, 0, 0));
        visits[startPos][0] = true;

        while (!q.isEmpty()) {
            Position currentPosition = q.poll();

            if(currentPosition.getIndex() == S){
                System.out.println(currentPosition.getTime());
                return;
            }

            if(currentPosition.getIndex() -1 >= 0 && !visits[currentPosition.getIndex() -1][currentPosition.clipboard]) {
                visits[currentPosition.getIndex() - 1][currentPosition.clipboard] = true;
                q.offer(new Position(currentPosition.getIndex() -1, currentPosition.getClipboard(), currentPosition.getTime() + 1));
            }

            if(currentPosition.getClipboard() != 0 && (currentPosition.getIndex() + currentPosition.getClipboard()) < visits.length) {
                if(!visits[currentPosition.getIndex() + currentPosition.getClipboard()][currentPosition.clipboard]) {
                    visits[currentPosition.getIndex() + currentPosition.getClipboard()][currentPosition.clipboard] = true;
                    q.offer(new Position(currentPosition.getIndex() + currentPosition.getClipboard(), currentPosition.getClipboard(), currentPosition.getTime() + 1));
                }
            }

            if(currentPosition.getIndex() > 0 && currentPosition.getIndex() < visits.length) {
                if(!visits[currentPosition.getIndex()][currentPosition.getIndex()]){
                    q.offer(new Position(currentPosition.getIndex(), currentPosition.getIndex(), currentPosition.getTime() + 1));
                }
            }


        }

    }



}
