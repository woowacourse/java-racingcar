package racingcar.util;

public class AssertUtils {
    private static final String EXPECTED_NULL_MESSAGE = "[ERROR] Null 값이 존재합니다.";
    public static void assertNull(Object object) {
        if (object == null) {
            throw new NullPointerException(EXPECTED_NULL_MESSAGE);
        }
    }
}
