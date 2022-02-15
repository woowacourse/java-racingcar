package common;

import static org.junit.jupiter.params.ParameterizedTest.ARGUMENTS_PLACEHOLDER;
import static org.junit.jupiter.params.ParameterizedTest.DISPLAY_NAME_PLACEHOLDER;

public class DisplayFormat {

    public static final String PARAMETERIZED_TEST_DISPLAY_FORMAT =
            DISPLAY_NAME_PLACEHOLDER + " [" + ARGUMENTS_PLACEHOLDER + "]";

    private DisplayFormat() {
    }
}
