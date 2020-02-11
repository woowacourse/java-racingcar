package application.calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculate {
    private String delimiter = ",|:";

    public static int calculation(List<Integer> numbers) {
        int result = 0;
        for (int i : numbers) {
            result = result + i;
        }
        return result;
    }

    public List<Integer> makeNumbersList(String s) {
        String expression = extractExpression(s);
        addCustomDelimiter(s);
        String[] splitExpression = expression.split(this.delimiter);
        List<Integer> result = new ArrayList<>();
        try {
            convertExpression(splitExpression, result);
        } catch (RuntimeException e) {
            throw new RuntimeException("양수만 입력해주세요");
        }
        return result;
    }

    public String extractExpression(String s) {
        if (isStartsWithSlash(s)) {
            return s.substring(s.indexOf("\\n") + 2);
        }
        return s;
    }

    public void addCustomDelimiter(String s) {
        if (!isStartsWithSlash(s)) {
            return;
        }
        this.delimiter = this.delimiter + extractDelimiter(s);
    }

    public String extractDelimiter(String s) {
        if (!isStartsWithSlash(s)) {
            return "";
        }
        int index = s.indexOf("\\n");
        return "|" + s.substring(2, index);
    }

    public boolean isStartsWithSlash(String s) {
        if (s.startsWith("/")) {
            return true;
        }
        return false;
    }

    private void convertExpression(String[] splitExpression, List<Integer> result) {
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

    public void checkCustomExpression(String input) {
        String checkString = input.substring(0, input.indexOf("\\n") + 1);
        if (!"//".equals(checkString.substring(0, 2))
                || !"\\n".equals(checkString.substring(checkString.length() - 1))) {
            throw new RuntimeException("잘못된 커스텀 구분자 식을 입력하였습니다.");
        }
    }

    /**
     * 구분자가 제대로 추출되었는지 확인하는 메소드
     *
     * @param delimiter 추출한 구분자
     * @return 구분자를 제대로 추출하면 true, 아니면 false
     */
    public boolean isSameDelimiter(String delimiter) {
        if (this.delimiter.equals(delimiter)) {
            return true;
        }
        return false;
    }
}
