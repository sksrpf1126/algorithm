package algorithm;

public class Factorial {
    public static void main(String[] args) {
        System.out.println(factorialMethod(5));
    }

    public static int factorialMethod(int n) {
        if(n <= 1) {
            return 1;
        }

        return n * factorialMethod(n - 1);
    }
}
