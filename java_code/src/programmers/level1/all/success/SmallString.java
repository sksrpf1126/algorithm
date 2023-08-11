package programmers.level1.all.success;

/**
 * level 1
 * 크기가 작은 부분문자열
 */
public class SmallString {

    public static void main(String[] args) {
        solution("3141592", "271");
        solution("500220839878", "7");
        solution("111111110000000000000000000000000000000000001111", "7");
    }

    public static void solution(String t, String p) {
        int answer = 0;

        for(int i = 0; i <= t.length() - p.length(); i++) {
            if(t.charAt(i) <= p.charAt(0)) {
                String small = t.substring(i, i + p.length());
                if(Long.parseUnsignedLong(small) <= Long.parseUnsignedLong(p)) {
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

}
