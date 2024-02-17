package common.exception.message;

import domain.Cars;
import domain.TryCount;

public class ExceptionMessage {

    public static final String CARS_SIZE_RANGE_ERROR_MESSAGE = String.format("자동차 수는 %d 이상, %d 이하여야 합니다", Cars.MIN_CAR_SIZE, Cars.MAX_CAR_SIZE);
    public static final String CAR_NAME_DUPLICATION_ERROR_MESSAGE = "자동차 이름은 중복이 불가능합니다.";
    public static final String CAR_NAME_PATTERN_ERROR_MESSAGE = "올바른 자동차 이름 입력 형태가 아닙니다.";

    public static final String TRY_COUNT_RANGE_ERROR_MESSAGE = String.format("시도 횟수는 %d 이상, %d 이하여야 합니다", TryCount.MIN_TRY_COUNT, TryCount.MAX_TRY_COUNT);

    public static final String INT_FORMAT_ERROR_MESSAGE = "입력 값이 정수형태가 아닙니다.";
}
