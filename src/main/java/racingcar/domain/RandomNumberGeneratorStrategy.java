package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 임의의 숫자를 생성하는 클래스
 *
 * @version 1.0.0
 * @author K.S.KIM
 * @author HyoChan
 * @since 2020/02/13
 */
public class RandomNumberGeneratorStrategy implements NumberGeneratorStrategy {
    private final Random random = new Random();

    private int generateRandomNumber() {
        return random.nextInt(10);
    }

    @Override
    public List<Integer> generateNumbers(final int size) {
        List<Integer> numbers = new ArrayList<>();
        for (int index = 0; index < size; index++) {
            numbers.add(generateRandomNumber());
        }
        return numbers;
    }
}
