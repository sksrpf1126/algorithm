package baekjoon.string.silver.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 실버 5
 * 단어 정렬
 */
public class Problem1181 {

    public static void main(String[] args) throws IOException {
        solution_2();
    }

    /**
     * Comparator 를 재정의하여 정렬한 방법
     */
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashSet<String> words = new HashSet<>();

        for (int i = 0; i < N; i++) {
            words.add(br.readLine());
        }

        List<String> wordsList = new ArrayList<>(words);

        Collections.sort(wordsList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }
                return o1.length() - o2.length();
            }
        });

        for(String s : wordsList) {
            System.out.println(s);
        }

        br.close();
    }

    /**
     * Comparable 을 재정의하여 정렬한 방법
     * 단어 하나당 객체를 만들기 때문에 메모리를 더 사용한다.
     */
    public static void solution_2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        SortedSet<Word> words = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            words.add(new Word(br.readLine()));
        }

        for(Word word : words) {
            System.out.println(word.getWord());
        }

        br.close();
    }

}

class Word implements Comparable<Word> {
    private String word;

    public Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    @Override
    public int compareTo(Word o) {
        if(this.word.length() == o.word.length()) {
            return this.word.compareTo(o.word);
        }

        return this.word.length() - o.word.length();
    }
}
