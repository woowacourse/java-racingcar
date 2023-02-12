package racing.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class ConverterTest {

    @Test
    void 문자열_분리() {
        Assertions.assertEquals(
                Converter.splitInput("be,be", ","),
                List.of("be", "be")
        );
    }

}