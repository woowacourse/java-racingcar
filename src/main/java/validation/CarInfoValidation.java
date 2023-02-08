package validation;

public class CarInfoValidation {

    private static final int CAR_NAME_LENGTH_MAX = 5;

    public static void validateCar(String input) {
        final String[] cars = input.split(",");
        validateLength(cars);
        validateName(cars);
    }

    private static void validateLength(final String[] cars) {
        if (cars.length == 0) {
            throw new IllegalArgumentException("자동차를 한 대 이상 작성해주세요.");
        }
    }

    private static void validateName(final String[] cars) {
        for (final String car : cars) {
            if (car.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이상 작성해주세요.");
            }
        }
    }

}
