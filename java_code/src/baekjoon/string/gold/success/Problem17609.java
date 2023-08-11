package baekjoon.string.gold.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 골드 5
 * 회문
 */
public class Problem17609 {

    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            String word = br.readLine();
            answer = 0;
            int lt = 0, rt = word.length() - 1;

            while (lt < rt) {
                if(word.charAt(lt) != word.charAt(rt)) {
                    checking(word, lt + 1, rt);
                    if(answer == 2) {
                        checking(word, lt, rt - 1);
                    }
                    break;
                }
                lt++;
                rt--;
            }

            System.out.println(answer);

        }

        br.close();
    }

    public static void checking(String word, int lt, int rt) {
        answer = 1;
        while(lt < rt) {
            if (word.charAt(lt) != word.charAt(rt)) {
                answer = 2;
                break;
            }

            lt++;
            rt--;
        }
    }

}

