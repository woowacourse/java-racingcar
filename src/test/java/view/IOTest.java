package view;

import java.io.ByteArrayInputStream;

public abstract class IOTest {
    void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}
