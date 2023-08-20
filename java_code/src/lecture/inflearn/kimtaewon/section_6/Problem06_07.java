package lecture.inflearn.kimtaewon.section_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


/**
 * 7. 좌표 정렬
 */
public class Problem06_07 {

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int x, y;

        List<Position> list = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            list.add(new Position(x, y));
        }

        Collections.sort(list);

        for(Position p : list) {
            System.out.println(p.x + " " + p.y);
        }
    }


}

class Position implements Comparable<Position>{
    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Position o) {
        if(this.x == o.x) {
            return this.y - o.y;
        }

        return this.x - o.x;
    }
}