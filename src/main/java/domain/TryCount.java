package domain;

import exception.NotPositiveIntegerException;
import java.util.regex.Pattern;

public class TryCount {

    private final int tryCount;

    public TryCount(final String inputCount) {
        validateTryCount(inputCount);
        this.tryCount = Integer.parseInt(inputCount);
    }

    private void validateTryCount(final String inputCount) {
        String positiveIntegerRegex = "^[1-9]|[1-9][0-9]+$";
        if (!Pattern.matches(positiveIntegerRegex, inputCount)) {
            throw new NotPositiveIntegerException("[ERROR] 양의 정수를 입력해주세요.");
        }
    }
}
