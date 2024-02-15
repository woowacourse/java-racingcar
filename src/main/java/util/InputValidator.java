package util;

public abstract class InputValidator {
    public void validate(String input) {
        validateNotBlank(input);
        validateNotContainSpace(input);
        validateCustom(input);
    }

    public void validateNotBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("입력값이 비어있습니다.");
        }
    }

    public void validateNotContainSpace(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException("입력값에 공백이 포함되어 있습니다.");
        }
    }

    abstract void validateCustom(String input);
}
