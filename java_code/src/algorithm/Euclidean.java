package algorithm;

/**
 * 유클리드 호제법
 * 두 수 A와 B가 있으며, A>B 일 때
 * 두 수의 최대 공약수를 구하는 알고리즘이다.
 *
 * 참고로, A * B / 최대 공약수 는 최소 공배수가 된다.
 *
 * 재귀함수와, 반복문의 방법이 있으며 코드가 간결한 것은 재귀함수이지만, 수가 커지면 stackOverFlow가 발생할 수 있으므로, 안전한 반복문으로 구현한다.
 */
public class Euclidean {
    public static void main(String[] args) {
        System.out.println(gcd(12, 10));
        System.out.println("최소공배수 : " + 12 * 10 / gcd(12, 10));
    }

    public static int gcd(int A, int B) {
        if(A <= B) {
            return -1;
        }

        while (B != 0) {
            int r = A % B;
            A = B;
            B = r;
        }

        return A;

    }
}
