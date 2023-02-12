package racingcar.model;

public class CarName {

    private static final Integer MAX_SIZE = 5;
    private static final String SIZE_EXCEPTION_MESSAGE = "자동차 이름은 5글자 이하만 가능합니다.";

    private final String name;

    public String getName() {
        return name;
    }

    public CarName(String input) {
        validateNameSize(input);
        this.name = input;
    }

    private void validateNameSize(String input) {
        if (input.length() > MAX_SIZE){
            throw new IllegalArgumentException(SIZE_EXCEPTION_MESSAGE);
        }
    }
}
