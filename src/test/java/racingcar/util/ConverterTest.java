package racingcar.util;

import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ConverterTest {

    @Test
    @DisplayName("String 형태의 차 이름들을 받았을 때, 쉼표 단위로 잘 나누어지는지 확인한다")
    void testStringToCars() {
        String testString = "가비,넛고,포비";
        assertThatCode(()-> Converter.stringToCars(testString)).doesNotThrowAnyException();
    }

}
