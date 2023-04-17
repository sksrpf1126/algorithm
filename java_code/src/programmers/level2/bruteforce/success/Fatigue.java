package programmers.level2.bruteforce.success;

/**
 * level 2
 * 피로도
 */
public class Fatigue {

    public static int answer = Integer.MIN_VALUE;
    public static boolean[] visits;

    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80,20},{50,40},{30,10}};
        visits = new boolean[dungeons.length];
        rotateDungeons(k, dungeons, 0);
        System.out.println(answer);
    }

    public static void rotateDungeons(int k, int[][] dungeons, int rotateCount) {

        for(int i = 0; i < dungeons.length; i++) {
            if(k >= dungeons[i][0] && !visits[i]) {
                visits[i] = true;
                rotateDungeons(k - dungeons[i][1], dungeons, rotateCount + 1);
                answer = Math.max(answer, rotateCount + 1);
                visits[i] = false;
            }
        }
    }
}
