package racingcar;

import java.io.ByteArrayInputStream;

public class TestUtil {
    public static void setInput(final String... args) {
        System.setIn(new ByteArrayInputStream(String.join("\n", args).getBytes()));
    }
}