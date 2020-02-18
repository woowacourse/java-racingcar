package stringadder;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Input {
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private static final Pattern pattern = Pattern.compile(CUSTOM_DELIMITER);

    private String expression;
    private List<Integer> splitExperssion;

    public Input(String value) {
        this.expression = value;
        validateInput(value);
        splitExperssion = splitInput();
    }

    private void validateInput(String expression) {
        if (expression == null || expression.isEmpty()) {
            throw new NullPointerException("식을 입력해 주세요.");
        }
    }

    private void validateList(List<Integer> list) {
        if (list.isEmpty()) {
            throw new NullPointerException("식을 입력해 주세요.");
        }
    }

    private String getDelimiter() {
        if (expression.matches(CUSTOM_DELIMITER)) {
            Matcher m = pattern.matcher(expression);
            if (m.find()) {
                changeInput(m.group(2));
                return m.group(1);
            }
        }
        return DEFAULT_DELIMITER;
    }

    private void changeInput(String group) {
        validateInput(group);
        this.expression = group;
    }

    private List<Integer> parseIntList(String delimiter) {
        try {
            String[] stringArrayValues = expression.split(delimiter);
            List<String> stringListValues = Arrays.asList(stringArrayValues);
            return stringListValues.stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자 이외의 값은 입력하실 수 없습니다.");
        }
    }

    public List<Integer> splitInput() {
        String delimiter = getDelimiter();
        List<Integer> list = parseIntList(delimiter);

        validateList(list);
        return list;
    }

    public List<Integer> getExpression() {
        return splitExperssion;
    }
}
