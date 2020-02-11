package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private String delimiter = ",|:";

    public static int calculation(List<Integer> numbers) {
        int result = 0;
        for (int i : numbers) {
            result = result + i;
        }
        return result;
    }

    public String[] splitString(String s) {
        return s.split(delimiter);
    }

    public String extractDelimiter(String s) {
        int index = s.indexOf('\n');
        return s.substring(2, index);
    }

    public List<Integer> extractExpression(String s) {
        String expression = s.substring(s.indexOf('\n') + 1);
        String[] splitExpression = expression.split(extractDelimiter(s));
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

    public void addDelimiter(String delimiter) {
        this.delimiter = this.delimiter + "|" + delimiter;
    }

    public boolean isSameDelimiter(String delimiter) {
        if (this.delimiter.equals(delimiter)) {
            return true;
        }
        return false;
    }
}
