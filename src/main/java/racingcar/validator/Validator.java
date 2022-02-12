package racingcar.validator;

import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    public static final char MIN_NUMBER_CRITERIA = '0';
    private static final int MIN_COUNT_OF_CAR = 2;
    private static final int CAR_NAME_STANDARD_SIZE = 5;
    private static final String MIN_CAR_OF_COUNT_MESSAGE = "[ERROR] 자동차 개수는 2개 이상이어야 합니다.";
    private static final String CAR_NAME_EMPTY_MESSAGE = "[ERROR] 자동차 이름은 빈칸일 수 없습니다.";
    private static final String CAR_NAME_SIZE_MASSAGE = "[ERROR] 자동차 이름은 5자 이하여야 합니다.";
    private static final String CAR_NAME_DUPLICATED_MESSAGE = "[ERROR] 자동차 이름이 중복되어선 안됩니다.";
    private static final String LAST_INPUT_IS_COMMA = "[ERROR] 마지막 자동차 이름을 입력하지 않았습니다.";
    private static final String TRY_COUNT_FORMAT_ERROR_MESSAGE = "[ERROR] 시도회수는 자연수여야 합니다.";
    public static final char MAX_NUMBER_CRITERIA = '9';

    public static void checkCountOfCar(RacingCars racingCars) {
        if (racingCars.getRacingCars().size() < MIN_COUNT_OF_CAR) {
            throw new IllegalArgumentException(MIN_CAR_OF_COUNT_MESSAGE);
        }
    }

    public static void checkCarsNameIsEmpty(RacingCars racingCars) {
        for (RacingCar racingCar : racingCars.getRacingCars()) {
            validatorEmptyName(racingCar.getName());
        }
    }

    private static void validatorEmptyName(String name) {
        if ("".equals(name)) {
            throw new IllegalArgumentException(CAR_NAME_EMPTY_MESSAGE);
        }
    }

    public static void checkCarsNameSize(RacingCars racingCars) {
        for (RacingCar racingCar : racingCars.getRacingCars()) {
            validatorCarNameSize(racingCar);
        }
    }

    private static void validatorCarNameSize(RacingCar racingCar) {
        if (racingCar.getName().length() > CAR_NAME_STANDARD_SIZE) {
            throw new IllegalArgumentException(CAR_NAME_SIZE_MASSAGE);
        }
    }

    public static void checkDuplicatedName(RacingCars racingCars) {
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

    public static void checkHaveLastInputComma(String userInput) {
        if (',' == userInput.charAt(userInput.length() - 1)) {
            throw new IllegalArgumentException(LAST_INPUT_IS_COMMA);
        }
    }

    public static void checkTryCountIsNaturalNumber(String tryCountInput) {
        for (int i = 0; i < tryCountInput.length(); ++i) {
            isNumber(tryCountInput.charAt(i));
        }
    }

    private static void isNumber(char target) {
        if (target < MIN_NUMBER_CRITERIA || target > MAX_NUMBER_CRITERIA) {
            throw new IllegalArgumentException(TRY_COUNT_FORMAT_ERROR_MESSAGE);
        }
    }

    public static int convertToInt(String tryCountInput) {
        if (Integer.parseInt(tryCountInput) == 0) {
            throw new IllegalArgumentException(TRY_COUNT_FORMAT_ERROR_MESSAGE);
        }
        return Integer.parseInt(tryCountInput);
    }
}
