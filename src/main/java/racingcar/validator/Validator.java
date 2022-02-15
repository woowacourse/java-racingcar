package racingcar.validator;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    private static final int MIN_COUNT_OF_CAR = 2;
    private static final String MIN_CAR_OF_COUNT_MESSAGE = "[ERROR] 자동차 개수는 2개 이상이어야 합니다.";
    private static final String CAR_NAME_DUPLICATED_MESSAGE = "[ERROR] 자동차 이름이 중복되어선 안됩니다.";
    private static final String LAST_INPUT_IS_COMMA = "[ERROR] 마지막 자동차 이름을 입력하지 않았습니다.";
    private static final String TRY_COUNT_FORMAT_ERROR_MESSAGE = "[ERROR] 시도회수는 자연수여야 합니다.";

    public static void validateCountOfCar(RacingCars racingCars) {
        if (racingCars.getRacingCars().size() < MIN_COUNT_OF_CAR) {
            throw new IllegalArgumentException(MIN_CAR_OF_COUNT_MESSAGE);
        }
    }


    public static void validateDuplicatedName(RacingCars racingCars) {
        List<String> nameList = new ArrayList<>();
        for (RacingCar racingCar : racingCars.getRacingCars()) {
            validatorDuplicatedName(nameList, racingCar.getName());
            nameList.add(racingCar.getName());
        }
    }

    private static void validatorDuplicatedName(List<String> nameList, String name) {
        if (nameList.contains(name)) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATED_MESSAGE);
        }
    }

    public static void validateHaveLastInputComma(String userInput) {
        if (',' == userInput.charAt(userInput.length() - 1)) {
            throw new IllegalArgumentException(LAST_INPUT_IS_COMMA);
        }
    }

    public static void validateTryCountIsNaturalNumber(String tryCountInput) {
        for (int i = 0; i<tryCountInput.length(); ++i) {
            isNumber(tryCountInput.charAt(i));
        }
        if (Integer.parseInt(tryCountInput) == 0) {
            throw new IllegalArgumentException(TRY_COUNT_FORMAT_ERROR_MESSAGE);
        }
    }

    private static void isNumber(char target) {
        if (target < '0' || target > '9') {
            throw new IllegalArgumentException(TRY_COUNT_FORMAT_ERROR_MESSAGE);
        }
    }
}
