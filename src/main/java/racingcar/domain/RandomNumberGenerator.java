package racingcar.domain;

import static racingcar.domain.Cars.*;

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
public class RandomNumberGenerator {
	private final Random random = new Random();

	public int generateRandomNumber() {
		return random.nextInt(MAX_CARS_SIZE);
	}

	public List<Integer> generateRandomNumbers(final int size) {
		List<Integer> numbers = new ArrayList<>();
		for (int index = 0; index < size; index++) {
			numbers.add(generateRandomNumber());
		}
		return numbers;
	}
}
