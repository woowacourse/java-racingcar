package domain;

public class Trial {

    private final static String PREFIX = "[0-9]";
    private final int trial;
    private final String ERROR_TRIAL = "자연수로만 입력해주세요.";

    public Trial(String input) {
        validateNumber(input);
        validateExtreme(input);
        this.trial = Integer.parseInt(input);
    }

    private void validateNumber(String input) {

        if (!input.matches(PREFIX)) {
            throw new IllegalArgumentException(ERROR_TRIAL);
        }
    }

    private void validateExtreme(String input) {
        if (input.equals("0") || Long.parseLong(input) > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(ERROR_TRIAL);
        }
    }

    public int getTrial() {
        return trial;
    }
}
