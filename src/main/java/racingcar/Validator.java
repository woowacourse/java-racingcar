package racingcar;

public class Validator {

    private static final int MIN_COUNT_OF_CAR = 2;
    public static final String MIN_CAR_OF_COUNT_MESSAGE = "[ERROR] 자동차 개수는 2개 이상이어야 합니다.";

    public static void validateCountOfCar(RacingCars racingCars) {
        if (racingCars.getRacingCars().size() < MIN_COUNT_OF_CAR) {
            throw new IllegalArgumentException(MIN_CAR_OF_COUNT_MESSAGE);
        }
    }
}
