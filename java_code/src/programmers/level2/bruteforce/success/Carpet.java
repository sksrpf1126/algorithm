package programmers.level2.bruteforce.success;

/**
 * level 2
 * 카펫
 */
public class Carpet {

    public static void main(String[] args) {
        int brown = 10, yellow = 2;
        int total = brown + yellow;
        int row = 0, col = 0;

        for(int i = 3; i <= total / 2; i++) {

            if(total % i == 0) {
                row = total / i;
                col = i;

                if((row * 2) + (col * 2 - 4) == brown) {
                    break;
                }

            }
        }

        int[] answer = {row, col};

    }
}
