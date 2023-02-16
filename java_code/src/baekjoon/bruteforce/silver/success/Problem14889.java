package baekjoon.bruteforce.silver.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 실버 2
 * 스타트와 링크
 */
public class Problem14889 {
    public static int N;
    public static int combinationR;
    public static int[][] statusMap;
    public static ArrayList<Integer> employeeNumbers = new ArrayList<>();
    public static Integer[] team;
    public static ArrayList<Integer> otherTeam = new ArrayList<>();
    public static int answer = Integer.MAX_VALUE;
    public static int teamStatus = 0;
    public static Integer[] statusPermutation = new Integer[2];
    public static boolean[] visits;

    public static void main(String[] args) throws IOException {
        solution();

    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        combinationR = N / 2;
        statusMap = new int[N][N];
        team = new Integer[combinationR];

        StringTokenizer sToken;

        //1부터 접근
        for(int i = 0; i < N; i++) {
            sToken = new StringTokenizer(br.readLine());
            employeeNumbers.add(i);
            for(int j = 0; j < N; j++){
                statusMap[i][j] = Integer.parseInt(sToken.nextToken());
            }
        }
        teamCombination(0,0);

        System.out.println(answer);


    }

    public static void teamCombination(int idx, int start) {
        if(idx == combinationR) {

            otherTeam.addAll(employeeNumbers);
            for(int i = 0; i < team.length; i++) {
                otherTeam.remove(team[i]);
            }

            visits = new boolean[team.length];
            statusPermutation(0, team);
            int teamA = teamStatus;
            teamStatus = 0;

            visits = new boolean[otherTeam.size()];
            statusPermutation(0, otherTeam.toArray(new Integer[0]));
            int teamB = teamStatus;
            teamStatus = 0;

            answer = Math.min(answer, Math.abs(teamA - teamB));

            otherTeam.clear();
            return;
        }

        for(int i = start; i < N; i++) {
            team[idx] = employeeNumbers.get(i);
            teamCombination(idx + 1, i + 1);
        }
    }

    public static void statusPermutation(int idx, Integer[] target) {
        if(idx == 2) {
            teamStatus += statusMap[statusPermutation[0]][statusPermutation[1]];
            return;
        }

        for(int i = 0; i < target.length; i++) {
            if(visits[i]) continue;
            statusPermutation[idx] = target[i];
            visits[i] = true;
            statusPermutation(idx + 1, target);
            visits[i] = false;
        }

    }
}
