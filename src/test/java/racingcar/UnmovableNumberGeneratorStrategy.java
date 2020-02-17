package racingcar;

import racingcar.domain.NumberGeneratorStrategy;

import java.util.Random;

/**
 * 움직일 수 없는 숫자를 생성하는 클래스
 *
 * @author HyoChan
 * @version 1.0.0
 * @since 2020/02/17
 */
public class UnmovableNumberGeneratorStrategy implements NumberGeneratorStrategy {
    private final Random random = new Random();

    @Override
    public int generateNumber() {
        return random.nextInt(4);
    }
}
