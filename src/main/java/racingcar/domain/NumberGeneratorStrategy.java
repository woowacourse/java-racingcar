package racingcar.domain;

import java.util.List;

/**
 * 숫자를 생성하는 인터페이스
 *
 * @version 1.0.0
 * @author HyoChan
 * @since 2020/02/17
 */

public interface NumberGeneratorStrategy {
    public List<Integer> generateNumbers(final int size);
}
