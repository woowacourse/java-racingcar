package util;

public class MoveCountValidator extends Validator {

    @Override
    public void validate(String input) throws IllegalArgumentException {
        validateNumeric(input);
        validateRange(input);
        validateNumberRange(input);
    }

    void validateNumberRange(String input) {
        int number = Integer.parseInt(input);
        if (number == 0) {
            throw new IllegalArgumentException("1회 이상 이동해야 합니다.");
        }
    }

}
