package baekjoon.bruteforce.gold.success;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 골드 5
 * 리모컨
 *
 * 같은 자릿수로 중복순열하여 제일 차가 적은 경우랑  한자릿수 적을 때 제일 큰 값을 찾아 차를 구할 때
 * 둘의 차가 동일하다면
 * ex
 * 1555
 * 3
 * 0 1 9
 *
 *는 2222 - 1555 = 671 이며, 1555 - 888 또한 671 이다. 이럴 때는 작은 자릿수로 구한 것을 택해야 한다.
 * 2222는 4번의 버튼을 눌렀지만, 888은 3번의 버튼을 눌렀기 때문이다.
 * 이것 때문에 반례를 찾아서 수정하였다..
 *
 *
 * 너무 어렵게 푼 것 같아서 다른 글을 참고하던 중 정말 간단한 방법을 발견했다.
 * https://velog.io/@hammii/%EB%B0%B1%EC%A4%80-1107-%EB%A6%AC%EB%AA%A8%EC%BB%A8-java 를 참고
 *
 * 누를 수 없는 번호를 인덱스로 해서 true값으로 지정한 뒤
 * check함수에 넘어온 n값은 숫자이다.
 * check함수에서 0이 넘어올때는, 0버튼을 누를 수 없다면 0을 반환한다. 반대로 누를 수 있다면 1을 반환한다. (0이라는 버튼을 한 번 눌렀으므로)
 * 이후 1~ 100만(50만의 수를 찾을 때  9만 누를 수 있는 경우 999,999가 정답이 될 수 있기에 100만)까지는
 * 하나씩 넘겨서 나머지와 나누기 연산자를 통해 자릿수마다 누를 수 없는 버튼이 하나라도 있다면 0을 반환하고, 전부 다 누를 수 있는 번호라면 해당 번호의 길이만큼
 * 반환한다.
 * 이후, 해당 값과 N값을 뺀 뒤 위 함수에서 반환한 len 값을 이미 들어있는 min값과 비교하여 더 최솟값을 넣는다.
 *
 * 이를 100만숫자까지 반복해서 제일 작은 수가 정답이 된다...
 *
 */
public class Problem1107 {
    public static String N;
    public static int notPushCount;
    public static Character[] notPushButton;
    public static ArrayList<Character> pushButton = new ArrayList<>();
    public static char[] permutationButton;
    public static int min;
    public static int differenceValue = Integer.MAX_VALUE;
    public static String selectedButton;

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = br.readLine();
        notPushCount = Integer.parseInt(br.readLine());

        StringTokenizer sToken;

        notPushButton = new Character[notPushCount];
        permutationButton = new char[N.length()];

        if(notPushCount != 0){
            sToken = new StringTokenizer(br.readLine());

            for(int i = 0; i < notPushCount; i++) {
                notPushButton[i] = sToken.nextToken().charAt(0);
            }
        }


        // '+' or '-'버튼으로만 이동했을 때의 버튼 수를 min에 저장
        min = Math.abs(100 - Integer.parseInt(N));

        //현재 채널과 이동하고자 하는 채널이 처음부터 같은 경우에는 0을 출력하고 끝
        if(min == 0){
            System.out.println(0);
            return;
        }

        if(notPushCount == 10) {
            System.out.println(min);
            return;
        }

        pushButtonSetting();
        duplicatePermutationButton(0);

        //N이 6자리인 경우 50만이 최댓값이다.
        //즉, 7자리에서 가장 작은 수를 50만과 비교하는 것보다 50만과 같은 자릿수의 숫자들과 비교하는게 더 작은 값이 됨
        //그렇기에 7자리는 배제
        if(N.length() < 6) {
            digitsPlusOne();
        }

        if(N.length() > 1) {
            digitsMinusOne();
        }

        // 앞의 0 제거
        selectedButton = String.valueOf(Integer.parseInt(selectedButton));

        if(min > differenceValue + selectedButton.length()) {
            min = differenceValue + selectedButton.length();
        }

        System.out.println(min);
    }

    /**
     * 99999의 채널을 갈 때 9를 누를 수 없는 경우 100000을 선택 하고 '-' 버튼을 누르면 됨
     * duplicatePermutationButton 메서드는 같은 자릿수 중에서 근사값을 찾을 뿐 다른 자릿수의 경우는 생각하지 않음
     * N의 자릿수가 위처럼 5자리일때 6자리에서 가장 작은값이 될 수 있는 수만 뽑으면 됨.
     */
    public static void digitsPlusOne(){
        String buttonString = "";

        if(pushButton.size() == 0) {
            return;
        }

        while (buttonString.length() <= N.length()) {
            //맨 앞의 수는 0이 될 수 없다.
            if(buttonString.length() == 0 && pushButton.get(0) == '0' && pushButton.size() > 1) {
                //0다음의 작은 수
                buttonString += pushButton.get(1);
                continue;
            }
            buttonString += pushButton.get(0);
        }

        int diff = Math.abs(Integer.parseInt(N) - Integer.parseInt(buttonString));

        if(differenceValue > diff) {
            differenceValue = diff;
            selectedButton = buttonString;
        }
    }

    /**
     * 10000의 채널을 갈 때 1을 누를 수 없는 경우 20000이 아닌 9999을 선택 하고 '+' 버튼을 누르면 됨
     * duplicatePermutationButton 메서드는 같은 자릿수 중에서 근사값을 찾을 뿐 다른 자릿수의 경우는 생각하지 않음
     * N의 자릿수가 위처럼 5자리일때 4자리에서 가장 큰 값이 될 수 있는 수만 뽑으면 됨.
     */
    public static void digitsMinusOne(){
        String buttonString = "";

        if(pushButton.size() == 0) {
            return;
        }

        while (buttonString.length() < N.length() - 1) {
            buttonString += pushButton.get(pushButton.size() - 1);
        }

        int diff = Math.abs(Integer.parseInt(N) - Integer.parseInt(buttonString));

        //같은 값일 경우엔 해당 값으로 변경 이유는 한자릿수가 더 적기 때문에 버튼 또한 -1번을 한다.
        if(differenceValue >= diff) {
            differenceValue = diff;
            selectedButton = buttonString;
        }
    }

    public static void duplicatePermutationButton(int idx) {

        if(idx == N.length()) {
            String buttonString = new String(permutationButton);
            int diff = Math.abs(Integer.parseInt(N) - Integer.parseInt(buttonString));
            if(differenceValue > diff) {
                differenceValue = diff;
                selectedButton = buttonString;
            }
            return;
        }

        for(int i = 0; i < pushButton.size(); i++) {
            permutationButton[idx] = pushButton.get(i);
            duplicatePermutationButton(idx + 1);
        }

    }


    public static void pushButtonSetting() {
        for(int i = 0; i <= 9; i++){
            pushButton.add((char)(i + '0'));
        }
        //1 ~ 9가 들어간 pushButton 에서 누르지 못하는 버튼을 제거
        for(int i = 0; i < notPushButton.length; i++) {
            pushButton.remove(notPushButton[i]);
        }
    }

}
