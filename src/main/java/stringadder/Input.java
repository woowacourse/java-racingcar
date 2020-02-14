package stringadder;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Input {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    public static final String EMPTY_EXPRESSION_ERROR = "식을 입력해 주세요.";
    public static final String NUMBER_FORMAT_ERROR = "숫자 이외의 값은 입력하실 수 없습니다.";

    private String expression;

    public Input(String value) {
        this.expression = value;
        validateInput();
    }

    private void validateInput() {
        if (expression == null || expression.isEmpty()) {
            throw new NullPointerException(EMPTY_EXPRESSION_ERROR);
        }
    }

    private void validateList(List<Integer> list) {
        if (list.isEmpty()) {
            throw new NullPointerException(EMPTY_EXPRESSION_ERROR);
        }
    }

    private String getDelimiter() {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER).matcher(expression);
        if (m.find()) {
            changeInput(m.group(2));
            return m.group(1);
        }
        return DEFAULT_DELIMITER;
    }

    private void changeInput(String group) {
        expression = group;
        validateInput();
    }

    private List<Integer> parseIntList(String delimiter) {
        try {
            String[] stringArrayValues = expression.split(delimiter);
            List<String> stringListValues = Arrays.asList(stringArrayValues);
            return stringListValues.stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new RuntimeException(NUMBER_FORMAT_ERROR);
        }
    }

    public List<Integer> splitInput() {
        try {
            String delimiter = getDelimiter();
            List<Integer> list = parseIntList(delimiter);

            validateList(list);
            return list;
        } catch (NullPointerException e) {
            throw new NullPointerException();
        }
    }
}
