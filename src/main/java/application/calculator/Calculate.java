package application.calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculate {
    private String delimiter = ",|:";

    public static void calculation(List<Integer> numbers) {
        int result = 0;
        for (int i : numbers) {
            result = result + i;
        }
        System.out.println(result);
    }

    public void extractDelimiter(String s) {
        int index = s.indexOf('\n');
        delimiter += "|" + s.substring(2, index);
    }

    public List<Integer> extractExpression(String s) {
        String expression = s.substring(s.indexOf('\n') + 1);
        extractDelimiter(s);
        String[] splitExpression = expression.split(this.delimiter);
        List<Integer> result = new ArrayList<>();
        try {
            splitExpression(splitExpression, result);
        } catch (RuntimeException e) {
            throw new RuntimeException("양수 만 입력해주세요");
        }
        return result;
    }

    private void splitExpression(String[] splitExpression, List<Integer> result) {
        for (int i = 0; i < splitExpression.length; i++) {
            int convertNumber = Integer.parseInt(splitExpression[i]);
            throwRuntimeExceptionWhenNegativeNumber(convertNumber);
            result.add(convertNumber);
        }
    }

    private void throwRuntimeExceptionWhenNegativeNumber(int convertNumber) {
        if (convertNumber < 0) {
            throw new RuntimeException();
        }
    }

    public boolean isSameDelimiter(String delimiter) {
        if (this.delimiter.equals(delimiter)) {
            return true;
        }
        return false;
    }

    public void checkCustomExpression(String input) {
        String checkString = input.substring(0, input.indexOf("\n") + 1);
        if (!"//".equals(checkString.substring(0, 2))
                || !"\n".equals(checkString.substring(checkString.length() - 1))) {
            throw new RuntimeException("잘못된 커스텀 구분자 식을 입력하였습니다.");
        }
    }
}
