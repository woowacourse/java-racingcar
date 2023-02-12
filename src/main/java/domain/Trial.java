package domain;

public class Trial {

    private final static String NUMBER_REGULAR_EXPRESSION = "[0-9]";
    private final static String ERROR_MESSAGE_TRIAL_TYPE = "시도 횟수는 자연수로만 입력해주세요.";
    private final int trial;

    public Trial(String input) {
        validateNumber(input);
        validateExtreme(input);
        this.trial = Integer.parseInt(input);
    }

    private void validateNumber(String input) {
        if (!input.matches(NUMBER_REGULAR_EXPRESSION)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_TRIAL_TYPE);
        }
    }

    private void validateExtreme(String input) {
        if (input.equals("0") || Long.parseLong(input) > Integer.MAX_VALUE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_TRIAL_TYPE);
        }
    }

    public int getTrial() {
        return trial;
    }
}
