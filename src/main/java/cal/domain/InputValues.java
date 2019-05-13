package cal.domain;

public class InputValues {
    private final static int EVEN = 2;

    private String[] input;

    public InputValues(String[] input) {
        this.input = input;

        for (int i = 0; i < input.length; i++) {
            if (i % EVEN == 0){
                invalidateNumberException(input[i]);
                continue;
            }

            invalidateOperatorLengthException(input[i]);
            unmatchedOperatorException(input[i]);
        }
    }

    private void invalidateOperatorLengthException(String s) {
        if (s == null || s.length() > 1) {
            throw new IllegalArgumentException("올바른 연산기호가 아닙니다.");
        }
    }

    private void unmatchedOperatorException(String s) {
        char oper = s.charAt(0);
        if (oper != '+' && oper != '-' && oper != '*' && oper != '/') {
            throw new IllegalArgumentException("올바른 연산기호가 아닙니다.");
        }
    }

    private void invalidateNumberException(String input) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    private boolean isNumeric(String input) {
        return input.matches("-?\\d+(\\.\\d+)?");
    }

    public String[] getInput() {
        return input;
    }
}
