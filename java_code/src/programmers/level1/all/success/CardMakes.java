package programmers.level1.all.success;

/**
 * level 1
 * 카드 뭉치
 */
public class CardMakes {

    public static void main(String[] args) {
        String answer = solution(new String[]{"i", "drink", "water"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"});
        System.out.println(answer);
        answer = solution(new String[]{"i", "water", "drink"}, new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"});
        System.out.println(answer);
    }

    public static String solution(String[] cards1, String[] cards2, String[] goal) {

        int card1Idx = 0, card2Idx = 0, goalIdx = 0;

        while(goalIdx < goal.length) {
            if(card1Idx < cards1.length && cards1[card1Idx].equals(goal[goalIdx])) {
                card1Idx++;
                goalIdx++;
            }else if(card2Idx < cards2.length && cards2[card2Idx].equals(goal[goalIdx])) {
                card2Idx++;
                goalIdx++;
            }else {
                return "NO";
            }
        }

        return "YES";
    }
}
