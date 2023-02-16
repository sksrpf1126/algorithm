package programmers.kit.greedy;

/**
 * level 2
 * 조이스틱(첫번째 시도 : X)
 * 문제는 이해했지만, 풀 수 없었던 문제
 * 좌우 이동이 핵심이다.
 * 오른쪽으로만 쭉 탐색해서 끝까지 간다면 좌우 이동거리는 배열의 길이 - 1이 되며, 이 경우는 A가 존재하지 않았을 경우이다.
 * 반대로 A가 존재하는 경우에는 어느것이 더 효율적인지 2가지 경우를 판단해야 한다.
 * 1. A를 만나기 이전까지 탐색했다가 A를 만났을 때 뒤로 back하는 경우
 * 2. 처음부터 뒤로 back을 했다가 다시 앞으로 와서 i까지 탐색하는 경우
 * 반복문을 돌며 처음에는 최댓값과 1번과 2번 중 효율적인 것을 찾아서 min값을 반환하며, 이 때 최댓값이 바뀌는 경우는 오른쪽으로 쭉 탐색하는 경우보다 back을 하는 경우가 더 효율적인 경우가 존재한다는 것
 *
 * 핵심 로직은 min=Math.min(min,i+length-next+Math.min(i,length-next)) 으로
 * 좌우 이동의 최솟값을 구하는 핵심은 A를 만났을 경우 뒤로갈 것인가 앞으로 갈것인가 판단 여부이다.
 * 위 로직은 처음엔 최대값인 min값과 비교하며, i+length-next를 먼저 보면,
 * i는 오른쪽으로 이동한 횟수
 * next는 i에서부터 오른쪽으로 탐색하여 'A'가 아닌 알파벳을 만날때까지 1씩 더한다.(즉, A가 아닌 문자열의 인덱스)
 * 그럼 length - next는 맨 오른쪽에서부터 시작해서 next까지의 거리(길이)를 의미한다.
 * i + length - next 는 오른쪽 이동 횟수와 맨오른쪽에서 next까지의 거리 즉, 현재 i에서 back을 해서 'A'가 아닌 인덱스까지 도달할 거리(횟수)이다.
 * 마지막으로, Math.min(i, length - next)를 통해 둘 중에 작은 값을 위 식과 더하게 되는데
 * 오른쪽으로 이동한 횟수, 맨 오른쪽에서부터  next까지 잰 길이(횟수)를 비교한다.
 * i를 반환하는 경우는 오른쪽으로 이동한 횟수보다 맨 오른쪽에서 next까지의 길이가 더 경우이다.
 * length - next를 반환하는 경우는 위의 반대이다.
 * i + length - next + i 의 식이 되는 경우에는 i까지 갔다가 다시 뒤로가서 next까지 간 거리이다.
 * i + length - next + length - next의 식이 되는 경우에는 처음부터 뒤로 back해서 next까지 간 후 i까지 탐색하는 경우이다.
 */
public class Joystick {
    public static void main(String[] args) {
        String name = "BBAAAAAB";
        int answer = 0;
        //또는 아래 for문으로 상하이동 연산 가능
//        int[] diff={0,1,2,3,4,5,6,7,8,9,10,11,12,13,12,11,10,9,8,7,6,5,4,3,2,1};
//        for(char c:name.toCharArray())
//            answer+=diff[c-'A'];

        int length=name.length();
        int min=length-1;

        for(int i=0;i<length;i++){
            // 상하이동
            if(name.charAt(i)<'N'){
                answer += name.charAt(i)-'A';
            }else{
                answer += 'Z' - name.charAt(i)+1;
            }
            
            int next=i+1;
            while(next<length && name.charAt(next)=='A'){
                next++;
            }
            min=Math.min(min,i+length-next+Math.min(i,length-next));
        }

//        return answer+min;
    }
}
