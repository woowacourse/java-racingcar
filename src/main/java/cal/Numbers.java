package cal;

public class Numbers {
    private String[] input;

    public Numbers(String[] input) {
        this.input = input;

        for (int i = 0; i < input.length; i++) {
            if (i % 2 == 0){
                if (!isNumber(input[i])) {
                    throw new IllegalArgumentException("숫자가 아닙니다.");
                }
                continue;
            }

            char oper = input[i].charAt(0);
            if (oper != '+' && oper != '-' && oper != '*' && oper != '/') {
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
