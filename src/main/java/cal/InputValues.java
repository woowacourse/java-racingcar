package cal;

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

            invalidateOperatorException(input[i]);
        }
    }

    private void invalidateOperatorException(String s) {
        char oper = s.charAt(0);
        if (oper != '+' && oper != '-' && oper != '*' && oper != '/') {
            throw new IllegalArgumentException("올바른 연산기호가 아닙니다.");
        }
    }

    private void invalidateNumberException(String input) {
        if (!isNumber(input)) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    private boolean isNumber(String input) {
        return input.matches("-?\\d+(\\.\\d+)?");
    }

    public String[] getInput() {
        return input;
    }
}
