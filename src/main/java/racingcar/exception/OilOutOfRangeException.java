package racingcar.exception;

import static racingcar.domain.generator.OilGenerator.MAX_OIL_AMOUNT;
import static racingcar.domain.generator.OilGenerator.MIN_OIL_AMOUNT;

public class OilOutOfRangeException extends IllegalArgumentException {
    private static final String MESSAGE = "oil의 값이 유효 범위를 벗어났습니다. 현재 범위: (%d - %d)";

    public OilOutOfRangeException() {
        super(String.format(MESSAGE, MIN_OIL_AMOUNT, MAX_OIL_AMOUNT));
    }
}
