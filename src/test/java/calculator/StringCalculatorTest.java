package calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringCalculatorTest {

    @Test
    public void splitAndSum_null_또는_빈문자() throws Exception {
        int nullInputResult = StringCalculator.splitAndSum(null);
        int emptyInputResult = StringCalculator.splitAndSum("");

        assertAll(
            () -> assertEquals(nullInputResult, 0),
            () -> assertEquals(emptyInputResult, 0)
        );
    }
}