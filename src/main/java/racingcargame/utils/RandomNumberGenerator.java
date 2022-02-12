package racingcargame.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomNumberGenerator {
    private static final Random random = new Random();
    private static final int MAX_RANDOM_NUMBER = 9;
    private static final int RANDOM_NUMBER_PICK = 0;
    private static final int SHUFFLE_FOR_INDEX_FIRST = 0;
    private static final int SHUFFLE_FOR_INDEX_SECOND = 1;

    private RandomNumberGenerator() {
    }

    public static int makeRandomNumber() {
        return shuffle();
    }

    public static int getRandomNumber(List<Integer> numbers) {
        return numbers.get(RANDOM_NUMBER_PICK);
    }

    private static int shuffle() {
        List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        for (int i = 0; i < MAX_RANDOM_NUMBER; i++) {

            List<Integer> indexList = makeDifferentIndexForShuffle(random, selectRandom(),
                    selectRandom(), MAX_RANDOM_NUMBER);
            int indexFirst = indexList.get(SHUFFLE_FOR_INDEX_FIRST);
            int indexSecond = indexList.get(SHUFFLE_FOR_INDEX_SECOND);

            swap(numbers, indexFirst, indexSecond);
        }
        return getRandomNumber(numbers);
    }

    public static List<Integer> makeDifferentIndexForShuffle(Random random, int indexFirst, int indexSecond, int length) {
        while (indexFirst == indexSecond) {
            indexFirst = random.nextInt(length);
            indexSecond = random.nextInt(length);
        }
        return Arrays.asList(indexFirst, indexSecond);
    }

    private static int selectRandom() {
        return random.nextInt(MAX_RANDOM_NUMBER + 1);
    }

    public static List<Integer> swap(List<Integer> numbers, int indexFirst, int indexSecond) {
        int tmp = numbers.get(indexFirst);
        numbers.set(indexFirst, numbers.get(indexSecond));
        numbers.set(indexSecond, tmp);
        return numbers;
    }
}
