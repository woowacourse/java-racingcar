public class inputValidater {
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

}
