package lecture.inflearn.kimtaewon.Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 * 3. 가위 바위 보
 */
public class Problem02_03 {
    public static void main(String[] args) throws IOException {
        solution();
    }
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] Aarr = new int[N];
        int[] Barr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            Aarr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            Barr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++){
            if(Aarr[i] == Barr[i]) {
                System.out.println("D");
                continue;
            }

            if(Aarr[i] == 1) {
                if(Barr[i] == 2) System.out.println("B");
                else System.out.println("A");
            }else if(Aarr[i] == 2) {
                if(Barr[i] == 1) System.out.println("A");
                else System.out.println("B");
            }else {
                if(Barr[i] == 1) System.out.println("B");
                else System.out.println("A");
            }
        }


        br.close();
    }

}
