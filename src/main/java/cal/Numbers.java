package cal;

public class Numbers {
    private static final int EVEN_NUMBER = 2;
    private String[] input;

    public Numbers(String[] input) throws IllegalArgumentException {
        this.input = input;
        validateNumber();
    }

    private void validateNumber() throws IllegalArgumentException {
        for (int i = 0; i < input.length; i++) {
            if (i % EVEN_NUMBER == 0) {
                if (!isNumber(input[i])) {
                    throw new IllegalArgumentException("숫자가 아닙니다.");
                }
                continue;
            }
            char operator = input[i].charAt(0);
            if (!Operator.isOperator(operator)) {
                throw new IllegalArgumentException("올바른 연산기호가 아닙니다.");
            }

        }
    }

    private boolean isNumber(String input) {
        return input.matches("-?\\d+(\\.\\d+)?");
    }

    public String[] getInput() {
        return input;
    }
}
