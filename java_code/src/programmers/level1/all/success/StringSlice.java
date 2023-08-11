package programmers.level1.all.success;

/**
 * level 1
 * 문자열 나누기
 */
public class StringSlice {

    public static void main(String[] args) {
        solution("banana");
        solution("abravadabra");
        solution("aaabbaccccabba");
    }

    public static void solution(String s) {
        int answer = 0;

        char first = ' ';
        int xCnt = 0, otherCnt = 0;

        for(int i = 0; i < s.length(); i++) {
            if(i == s.length() - 1) {
                answer++;
                break;
            }

            if(first == ' ') {
                first = s.charAt(i);
                xCnt++;
            }else if(first == s.charAt(i)) {
                xCnt++;
            }else {
                otherCnt++;
            }

            if(xCnt == otherCnt) {
                answer++;
//                xCnt = 0; 없어도 정답
//                otherCnt = 0; 없어도 정답
                first = ' ';
            }

        }


        System.out.println(answer);
    }

}
