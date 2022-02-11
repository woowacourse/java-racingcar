package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    private static final int MIN_COUNT_OF_CAR = 2;
    private static final int CAR_NAME_STANDAR_SIZE = 5;
    private static final String MIN_CAR_OF_COUNT_MESSAGE = "[ERROR] 자동차 개수는 2개 이상이어야 합니다.";
    private static final String CAR_NAME_EMPTY_MESSAGE = "[ERROR] 자동차 이름은 빈칸일 수 없습니다.";
    private static final String CAR_NAME_SIZE_MASSAGE = "[ERROR] 자동차 이름은 5자 이하여야 합니다.";
    private static final String CAR_NAME_DUPLICATED_MESSAGE = "[ERROR] 자동차 이름이 중복되어선 안됩니다.";

    public static void validateCountOfCar(RacingCars racingCars) {
        if (racingCars.getRacingCars().size() < MIN_COUNT_OF_CAR) {
            throw new IllegalArgumentException(MIN_CAR_OF_COUNT_MESSAGE);
        }
    }


    public static void validateCarsNameIsEmpty(RacingCars racingCars) {
        for (RacingCar racingCar : racingCars.getRacingCars()) {
            validatorEmptyName(racingCar.getName());
        }
    }

    private static void validatorEmptyName(String name) {
        if ("".equals(name)) {
            throw new IllegalArgumentException(CAR_NAME_EMPTY_MESSAGE);
        }
    }

    public static void validateCarsNameSize(RacingCars racingCars) {
        for (RacingCar racingCar : racingCars.getRacingCars()) {
            validatorCarNameSize(racingCar);
        }
    }

    private static void validatorCarNameSize(RacingCar racingCar) {
        if(racingCar.getName().length() > CAR_NAME_STANDAR_SIZE){
            throw new IllegalArgumentException(CAR_NAME_SIZE_MASSAGE);
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
}
