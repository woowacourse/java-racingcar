package racingcar.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.service.CarNameParser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ParserTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private static final String ERROR_MESSAGE = "[ERROR]";

    @ParameterizedTest
    @ValueSource(strings = {",", "#", "panda,", "#philz", ",phobi,"})
    @DisplayName("이름에 허용되지 않는 문자")
    public void Not_Available_Character(String input) {
        assertThatThrownBy(
                () -> CarNameParser.validateCarName(input)
        ).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("이름에 허용되지 않는 문자 : null")
    public void Not_Available_Null() {
        assertThatThrownBy(
                () -> CarNameParser.validateCarName(null)
        ).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("한 번 해보는 정상입력")
    public void Available_Character() {
        Assertions.assertDoesNotThrow(() -> {
            CarNameParser.validateCarName("polo");
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"panda,philz,java", " panda, philz  , java"})
    @DisplayName("자동차 전체 입력 : 정상")
    public void input_all_car_name(String input) {
        String[] inputNames = CarNameParser.parseCarNameInputs(input);
        assertThat(inputNames).containsExactly("panda", "philz", "java");
    }

    @Test
    @DisplayName("자동차 전체 입력 : 예외")
    public void input_all_car_name_exception() {
        assertThatThrownBy(() -> {
            CarNameParser.parseCarNameInputs("panda,philz,javajigi");
        });
    }
}