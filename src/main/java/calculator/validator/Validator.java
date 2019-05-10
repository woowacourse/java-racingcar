package calculator.validator;

import java.util.Arrays;

public class Validator {
    private String value;
    private String[] values;

    public Validator(String value) {
        this.value = value;
        this.values = value.split(" ");
    }

    public boolean validateAll() {
        if (!validateLength()) {
            System.out.println("계산식을 잘못 입력하였습니다. 다시 입력해주세요!");
            return false;
        }
        if (!validateForm()) {
            System.out.println("숫자와 연산자 외의 다른 문자를 입력하였습니다! 다시 입력해주세요!");
            return false;
        }
        if (!dividedZero()) {
            System.out.println("0으로 나눌 수 없습니다. 다시 입력해주세요!");
            return false;
        }
        if(!validateOrderOfNumbers() || !validateOrderOfOperator()) {
            System.out.println("계산식의 순서가 올바르지 않습니다. 다시 입력해주세요!");
            return false;
        }
        return true;
    }

    private boolean validateLength() {
        return (values.length < 3) ? false : true;
    }

    private boolean validateForm() {
        return !(Arrays.stream(values).anyMatch(x -> !isNumeric(x) && !(x.matches("[+|\\-|*|/]"))));
    }

    private boolean dividedZero() {
        return !(value.contains("/ 0"));
    }

    private boolean validateOrderOfNumbers() {
        int wrongCount = 0;
        for (int i = 0; i < values.length; i += 2)
            wrongCount += (isNumeric(values[i])) ? 0 : 1;
        return (wrongCount > 0) ? false : true;
    }

    private boolean validateOrderOfOperator() {
        int wrongCount = 0;
        for (int i = 1; i < values.length; i += 2)
            wrongCount += (values[i].matches("[+|\\-|*|/]")) ? 0 : 1;
        return (wrongCount > 0) ? false : true;
    }

    private boolean isNumeric(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
