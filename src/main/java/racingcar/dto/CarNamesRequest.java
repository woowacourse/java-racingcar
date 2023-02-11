package racingcar.dto;

import racingcar.validator.CarValidator;
import racingcar.validator.DefaultCarValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarNamesRequest {
    private final List<String> carNames;

    public CarNamesRequest(String inputCarNames) {
        CarValidator carValidator = new DefaultCarValidator();
        this.carNames = splitByComma(inputCarNames);
        carValidator.validateCarNamesSize(this.carNames);
        for (String carName : carNames) {
            carValidator.validateCarName(carName);
        }
    }

    private List<String> splitByComma(String carNames) {
        String[] splitCarNames = carNames.split("\\s*,\\s*");
        return Arrays.stream(splitCarNames).collect(Collectors.toList());
    }

    public List<String> getCarNames() {
        return carNames;
    }
}
