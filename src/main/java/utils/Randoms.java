package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Randoms {
    private static final Random random = new Random();

    /**
     * @param count        뽑을 숫자 개수
     * @param endInclusive 숫자 범위
     * @return 0부터 endInclusive까지의 count만큼의 랜덤 숫자 리스트
     */
    public static List<Integer> getRandomNumbers(int count, int endInclusive) {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            randomNumbers.add(getRandomNumber(endInclusive));
        }

        return randomNumbers;
    }

    /**
     * @param endInclusive 최댓값
     * @return 0 이상 endInclusive 이하의 랜덤 정수
     */
    public static int getRandomNumber(int endInclusive) {
        return random.nextInt(endInclusive + 1);
    }
}
