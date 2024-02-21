package conversion;

import domain.Car;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import domain.validation.CarValidator;
import domain.validation.RoundValidator;

public class Converter {
    private Converter() {
    }

    public static List<Car> toCars(String rawCarNames) {
        List<Car> cars = new ArrayList<>();
        List<String> carNames = Arrays.stream(rawCarNames.trim().split("\\s*,\\s*")).toList();

        CarValidator.validateCarNames(carNames);

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public static int toRound(String rawRound) {
        int round;

        try {
            round = Integer.parseInt(rawRound);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }

        RoundValidator.validateRound(round);
        return round;
    }
}
