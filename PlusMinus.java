import java.math.BigDecimal;
import java.util.Objects;

/**
 * PlusMinus
 */
public class PlusMinus {

    public static void main(String[] args) {

        int[] arr2 = {1, 2, 3, -1, -2, -3, 0, 0};
        plusMinus(arr2);
    }

    private static void plusMinus(int[] arr) {

        BigDecimal positive = new BigDecimal(0);
        BigDecimal negative = new BigDecimal(0);
        BigDecimal zeros = new BigDecimal(0);
        BigDecimal total = new BigDecimal(0);
        if (Objects.nonNull(arr)) {
            total = new BigDecimal(arr.length);
            for (int number : arr) {
                if ( number > 0 )
                    positive = positive.add(new BigDecimal(1));
                else if ( number < 0 )
                    negative = negative.add(new BigDecimal(1));
                else if ( number == 0 )
                    zeros = zeros.add(new BigDecimal(1));
            }
        }

        System.out.println(sum(positive, total));
        System.out.println(sum(negative, total));
        System.out.println(sum(zeros, total));
    }

    private static BigDecimal sum(BigDecimal num1, BigDecimal num2) {
        if (!num2.equals(new BigDecimal(0)))
            return num1.divide(num2, 6, 1);
        return new BigDecimal(0);
    }
}