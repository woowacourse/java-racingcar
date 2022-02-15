package util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.util.CarNameParser;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameParserTest {
    @ParameterizedTest
    @ValueSource(strings = {"panda,philz,java", " panda, philz  , java"})
    @DisplayName("자동차 전체 입력 : 정상")
    public void input_all_car_name(String input) {
        Assertions.assertDoesNotThrow(
                () -> CarNameParser.parseCarNameInputs(input)
        );
    }

    @Test
    @DisplayName("자동차 전체 입력 : 예외")
    public void input_all_car_name_exception() {
        assertThatThrownBy(() -> {
            CarNameParser.parseCarNameInputs("panda,philz,javajigi");
        });
    }
}
