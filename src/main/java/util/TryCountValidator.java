package util;

public class TryCountValidator extends InputValidator {
    @Override
    void validateCustom(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }
}
