package dto;

import java.util.Arrays;
import java.util.List;

public record CarNameRequest(String cars) {

    public static final String DELIMITER = ",";

    public CarNameRequest from() {
        validateCars(cars);
        return new CarNameRequest(cars);
    }

    public List<String> asList() {
        return Arrays.asList(cars.split(DELIMITER));
    }

    public void validateCars(String input) {
        validateBlank(input);
        validateDuplicatedDelimiter(input);
        validateStartWord(input);
        validateEndWord(input);
    }

    private void validateEndWord(String input) {
        if (input.endsWith(DELIMITER)) {
            throw new IllegalArgumentException("구분자로 끝날 수 없습니다.");
        }
    }

    private void validateStartWord(String input) {
        if (input.startsWith(DELIMITER)) {
            throw new IllegalArgumentException("구분자로 시작할 수 없습니다.");
        }
    }

    private void validateDuplicatedDelimiter(String input) {
        if (input.contains(DELIMITER.repeat(2))) {
            throw new IllegalArgumentException("올바른 형식으로 입력해주세요.");
        }
    }

    private void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("공백을 입력할 수 없습니다.");
        }
    }
}
