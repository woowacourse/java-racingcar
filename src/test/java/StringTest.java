import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringTest {
    @Test
    void startsWith_학습테스트() {
        String testString = "//;\n1;2;3";
        assertTrue(testString.startsWith("//"));
    }

    @Test
    void substring_학습테스트() {
        String testString = "//;\n1;2;3";
        assertTrue(testString.substring(3,4).equals("\n"));

    }
}
