package util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SplitterTest {
    @Test
    @DisplayName("문자열을 콤마(,) 를 통해 구분한다")
    void splitWithComma() {
        String originalString = "pond,crong,joyson";

        List<String> splitResult = Splitter.splitWithComma(originalString);

        assertEquals(splitResult.size(), 3);
    }
}
