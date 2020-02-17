package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 특정 숫자를 생성하는 클래스
 *
 * @version 1.0.0
 * @author HyoChan
 * @since 2020/02/7
 */
public class DefaultNumberGeneratorStrategy implements NumberGeneratorStrategy {
    public static final int DEFAULT_NUMBER= 1;

    @Override
    public int generateNumber() {
        return DEFAULT_NUMBER;
    }
}
