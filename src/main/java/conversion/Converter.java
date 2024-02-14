package conversion;

import domain.Car;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import validation.Validator;

public class Converter {

    public static List<Car> toCars(String rawCarNames) {
        List<Car> cars = new ArrayList<>();
        List<String> carNames = Arrays.stream(rawCarNames.split(",")).toList();

        Validator.validateCarNames(carNames);

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

        Validator.validateRound(round);
        return round;
    }
}