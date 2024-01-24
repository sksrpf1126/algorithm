package programmers.level1.all.success;

/**
 * level 1
 * 공원 산책
 */
public class ParkWalk {
    public static int[] answer =  new int[2];
    public static char[][] map;

    public static void main(String[] args) {
        solution(new String[]{"OOOOO", "OOOOO", "OOSOO", "OOOOO", "OOOOO"}, new String[]{"E 3", "W 3", "S 3", "N 3", "E 2", "E 1", "W 4", "W 1", "S 2", "S 1", "N 4", "N 1"});
    }

    public static int[] solution(String[] park, String[] routes) {
        map = new char[park.length][park[0].length()];

        for(int i = 0; i < park.length; i++) {
            char[] charArray = park[i].toCharArray();

            for(int j = 0; j < charArray.length; j++) {
                map[i][j] = charArray[j];

                if(charArray[j] == 'S') {
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }

        for(int i = 0; i < routes.length; i++) {
            String[] s = routes[i].split(" ");

            int move = Integer.parseInt(s[1]);

            switch (s[0]) {
                case("E") :
                    if(answer[1] + move < map[0].length) {
                        for(int j = answer[1] + 1; j <= answer[1] + move; j++) {
                            if(map[answer[0]][j] == 'X') {
                                move = 0;
                                break;
                            }
                        }
                        answer[1] = answer[1] + move;
                    }
                    break;
                case("W") :
                    if(answer[1] - move >= 0) {
                        for(int j = answer[1] - 1; j >= answer[1] - move; j--) {
                            if(map[answer[0]][j] == 'X') {
                                move = 0;
                                break;
                            }
                        }
                        answer[1] = answer[1] - move;
                    }
                    break;
                case("S") :
                    if(answer[0] + move < map.length) {
                        for(int j = answer[0] + 1; j <= answer[0] + move; j++) {
                            if(map[j][answer[1]] == 'X') {
                                move = 0;
                                break;
                            }
                        }
                        answer[0] = answer[0] + move;
                    }
                    break;
                case("N") :
                    if(answer[0] - move >= 0) {
                        for(int j = answer[0] - 1; j >= answer[0] - move; j--) {
                            if(map[j][answer[1]] == 'X') {
                                move = 0;
                                break;
                            }
                        }
                        answer[0] = answer[0] - move;
                    }
                    break;
            }
        }

        return answer;
    }

}
