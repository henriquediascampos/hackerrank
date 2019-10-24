/**
 * escada
 */
public class Escada {

    public static void main(String[] args) {
        escada(10);
    }

    private static void escada(int n) {
        for (int i = 1; i <= n; i++) {
            String step = generateStep(" ", n - i) + generateStep("#", i);

            System.out.println(step);
        }
    }

    private static String generateStep(String stepFormat, int n) {
        String steps = "";
        for (int i = 0; i < n; i++) {
            steps += stepFormat;
        }
        return steps;
    }

}