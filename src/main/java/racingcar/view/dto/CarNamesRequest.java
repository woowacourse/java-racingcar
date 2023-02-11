package racingcar.view.dto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.ErrorMessage;

public class CarNamesRequest {
    private static final String SEPARATOR = ",";

    private final String carNames;

    public CarNamesRequest(String userInput) {
        validate(userInput);
        this.carNames = userInput;
    }

    private void validate(String userInput) {
        validateBlank(userInput);
    }

    private void validateBlank(String splitCarName) {
        if (splitCarName.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_NULL.message());
        }
    }

    public List<String> toSplitCarNames() {
        return Arrays.stream(carNames.split(SEPARATOR))
                .collect(Collectors.toList());
    }
}
