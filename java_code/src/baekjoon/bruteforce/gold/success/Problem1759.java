package baekjoon.bruteforce.gold.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 골드 5
 * 암호 만들기
 */
public class Problem1759 {
    public static int L;
    public static int C;
    public static char[] alphabet;
    public static char[] password;

    public static void main(String[] args) throws IOException {
        solution();

    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sToken = new StringTokenizer(br.readLine());
        L = Integer.parseInt(sToken.nextToken());
        C = Integer.parseInt(sToken.nextToken());

        sToken = new StringTokenizer(br.readLine());
        alphabet = new char[C];
        password = new char[L];

        for(int i = 0; i < C; i++) {
            alphabet[i] = sToken.nextToken().charAt(0);
        }

        Arrays.sort(alphabet);

        combination(0, 0);

    }


    public static void combination(int idx, int start) {

        if(idx == L) {
            int vowelCount = 0; //모음 수
            int consonants = 0; //자음 수
            for(int i = 0; i < password.length; i++) {
                if(password[i] == 'a' || password[i] == 'e' || password[i] == 'i' || password[i] == 'o' || password[i] == 'u') {
                    vowelCount++;
                }else {
                    consonants++;
                }
            }

            if(vowelCount >= 1 && consonants >=2) {
                System.out.println(new String(password));
            }
            return;
        }

        for(int i = start; i < alphabet.length; i++) {
            password[idx] = alphabet[i];
            combination(idx + 1, i + 1);
        }
    }

}
