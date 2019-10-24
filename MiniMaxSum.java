import java.util.Arrays;
import java.util.Objects;

/**
 * MiniMaxSum
 */
public class MiniMaxSum {

    public static void main(String[] args) {
        // int[] arr = {25,2,10,3,4};
        // int[] arr1 = {0,0,0,0,0,0,0,0};
        // int[] arr2 = {1,1,1,1,1,1,1,};
        int[] arr3 = {25,2,10,3,4};

        miniMaxSum(arr3);
    }

    private static void miniMaxSum(int[] arr) {

        if (Objects.nonNull(arr)) {
            long max = Arrays.stream(arr)
                .mapToLong(num -> num)
                .sorted()
                .skip(1)
                .sum();

            long min = Arrays.stream(arr)
                .mapToLong(num -> num)
                .sorted()
                .limit(arr.length -1)
                .sum();

            System.out.println( min + " " + max);
        }

    }
}