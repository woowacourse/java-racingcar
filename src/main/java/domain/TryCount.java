package domain;

import exception.NotPositiveIntegerException;
import java.util.regex.Pattern;

public class TryCount {

    private static final int END_FLAG = 0;

    private final int tryCount;

    public TryCount(final String inputCount) {
        validateTryCount(inputCount);
        this.tryCount = Integer.parseInt(inputCount);
    }

    private TryCount(final int tryCount) {
        this.tryCount = tryCount;
    }

    private void validateTryCount(final String inputCount) {
        String positiveIntegerRegex = "^[1-9]|[1-9][0-9]+$";
        if (!Pattern.matches(positiveIntegerRegex, inputCount)) {
            throw new NotPositiveIntegerException("[ERROR] 양의 정수를 입력해주세요.");
        }
    }

    public TryCount deduct() {
        return new TryCount(tryCount - 1);
    }

    public boolean isZero() {
        return this.tryCount == END_FLAG;
    }
}
