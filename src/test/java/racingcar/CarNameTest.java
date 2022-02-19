package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.util.StringUtil;
import racingcar.validator.exception.carname.CarNameException;

@SuppressWarnings("NonAsciiCharacters")
public class CarNameTest {

    @ParameterizedTest
    @MethodSource(value = "provideCarNameAndExceptionMessage")
    public void 자동차_이릅_예외_테스트(String carName, String message) {
        assertThatThrownBy(() -> new CarName(carName))
                .isInstanceOf(CarNameException.class)
                .hasMessageContaining(message);
    }

    private static Stream<Arguments> provideCarNameAndExceptionMessage() {
        return Stream.of(
                Arguments.of("다섯글자이상", "자동차 이름은 5자 이하여야 합니다."),
                Arguments.of("", "모든 자동차 이름은 반드시 존재해야 합니다."),
                Arguments.of(" ", "자동차 이름은 공백으로 설정할 수 없습니다."),
                Arguments.of("    ", "자동차 이름은 공백으로 설정할 수 없습니다.")
        );
    }
}