import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Result {
    public static void main(String[] args) throws IOException {

        List<Integer> list0 = IntStream.of(1).boxed().collect(Collectors.toList());
        List<Integer> list1 = IntStream.of(4, 5, 6).boxed().collect(Collectors.toList());
        List<Integer> list2 = IntStream.of(9, 8).boxed().collect(Collectors.toList());
        List<Integer> list3 = IntStream.of(1, 2, 3).boxed().collect(Collectors.toList());
        List<Integer> list4 = IntStream.of(9, 9).boxed().collect(Collectors.toList());
        List<Integer> list5 = IntStream.of(1, 32, 98).boxed().collect(Collectors.toList());
        List<Integer> list6 = IntStream.of(1, 6, 0).boxed().collect(Collectors.toList());
        List<List<Integer>> arr = new ArrayList<>();

        arr.add(list0);
        arr.add(list1);
        arr.add(list2);
        arr.add(list3);
        arr.add(list4);
        arr.add(list5);
        arr.add(list6);

        int result = Result.diagonalDifference(arr);

        System.out.println(result);
    }

    private static List<List<Integer>> maiorMatrisQuadrada(List<List<Integer>> arr) {

        List<HashMap<Integer, Integer>> listMatrizes = new ArrayList<HashMap<Integer,Integer>>();

        List<Integer> arrSize = arr.stream()
            .map(list -> list.size())
            .collect(Collectors.toList());

        Integer startIndex = 0;
        Integer endIndex = 0;
        Integer greatSequecia = 0;
        Integer greatSize = 0;

        for (List<Integer> list : arr) {
            Integer size = list.size();
            Integer max = 0;
            for (int i = 0; i < arr.size(); i++) {
                Integer size2 = arr.get(i).size();
                if (size.equals(size2)) {
                    max++;
                }

                if (max > 1) {

                    if (max > greatSequecia) {
                        greatSequecia = max;
                        startIndex = i - max;
                        endIndex = i -1;
                        greatSize = size;
                    }
                    max = 0;
                } else if (!size.equals(size2)) {
                    max = 0;
                }
            }
        }

        return arr.subList(startIndex, endIndex);
    }

    private static void addMatriz(List<HashMap<Integer, Integer>> listMatrizes,
        Integer size, Integer sequecia) {
        listMatrizes.add(new HashMap<Integer,Integer>() {{
            put(size, sequecia);
        }});
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        if (Objects.nonNull(arr)) {
            List<List<Integer>> maiorMatrisQuadrada = maiorMatrisQuadrada(arr);
            int somaDiagonal = somaDiagonal(maiorMatrisQuadrada);
            int somaDiagonalreversa = somaDiagonal(revertLsit(maiorMatrisQuadrada));
            int result = somaDiagonal - somaDiagonalreversa;
            return  result < 0 ? result * -1 : result;
        } else {
            return 0;
        }

    }

    private static List<List<Integer>> revertLsit(List<List<Integer>> arr) {
        List<List<Integer>>  listReverse = new ArrayList<>(arr);
        listReverse.stream()
            .collect(Collectors.toCollection(LinkedList::new))
            .descendingIterator().forEachRemaining(Collections::reverse);
        return listReverse;
    }

    private static int somaDiagonal(List<List<Integer>> arr) {
        int somaDiagonal = 0;
        for (int i = 0; i < arr.size(); i++) {
            List<Integer> list = arr.get(i);
            somaDiagonal += Objects.nonNull(list.get(i)) ? list.get(i) : 0;
        }
        return somaDiagonal;
    }
}
