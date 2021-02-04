package racingCar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NameSpliterTest {
    @ParameterizedTest
    @CsvSource(value={",apple,pear:false","apple,pear,:false","apple,,pear:false"},delimiter = ':')
    void inputCheckerTest(String input, boolean expected) {
        boolean actualValue = NameSpliter.inputChecker(input);
        assertEquals(expected, actualValue);
    }

    @ParameterizedTest
    @CsvSource(value={"apple,pear,banana:false","apple,pear:true"},delimiter = ':')
    void lengthTest(String input, boolean expected) {
        boolean actualValue = NameSpliter.inputChecker(input);
        assertEquals(expected, actualValue);
    }
}
