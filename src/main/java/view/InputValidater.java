package view;

public class InputValidater { //TODO: 첫 글자 대문자
    public void validateCars(String input) {
        validateBlank(input);
        validateDuplicatedDelimeter(input);
        validateStartWord(input);
        validateEndWord(input);
    }

    private void validateEndWord(String input) {
        if (input.endsWith(",")) {
            throw new IllegalArgumentException();
        }
    }

    private void validateStartWord(String input) {
        if (input.startsWith(",")) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicatedDelimeter(String input) {
        if (input.contains(",,")) { // 추후 리펙터링 할 것!
            throw new IllegalArgumentException();
        }
    }

    private void validateBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    public void validateCount(String input) {
        validateBlank(input);
        validateNumeric(input);
        validateRange(input);
        validatePostive(input);
    }

    private void validateRange(String input) {
        try {
            Integer.parseInt(input);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

    private void validatePostive(String input) {
        if (Integer.parseInt(input) <= 0) { // integer 범위 이상의 수가 들어오면? 오류!
            throw new IllegalArgumentException();
        }
    }

    private void validateNumeric(String input) {
        if (!input.matches("-?\\d+")) { // 성능 그지
            throw new IllegalArgumentException();
        }
    }
}
