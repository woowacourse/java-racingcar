package domain;

public class Trial {
    private final String PREFIX = "[0-9]";
    private final int trial;

    public Trial(String input) {
        validateNumber(input);
        validateExtreme(input);
        this.trial = Integer.parseInt(input);
    }


    private void validateNumber(String input) {
        if (!input.matches(PREFIX)) {
            throw new IllegalArgumentException("횟수는 자연수로 입력해주세요.");
        }
    }

    private void validateExtreme(String input) {
        if (input.equals("0") || Integer.parseInt(input) > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("1 이상의 정수(int)범위로 입력해주세요.");
        }
    }
}
