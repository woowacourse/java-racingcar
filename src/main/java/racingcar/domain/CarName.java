package racingcar.domain;

public class CarName {

    static private final Integer MAX_SIZE = 5;
    static private final String SIZE_EXCEPTION_MESSAGE = "자동차 이름은 5글자 이하만 가능합니다.";

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
