package racingcar.domain;


import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CarsTest {
    @Test
    @DisplayName("[Exception] 중복된 자동차 이름이 있으면 예외를 던진다")
    void createCarsByDuplicateCarNames() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Cars(List.of("123", "123")))
                .withMessage("자동차 이름은 중복될 수 없습니다.");
    }

    @ParameterizedTest
    @MethodSource("InputCarNames")
    @DisplayName("[Exception] 자동차 대수가 2대 미만이거나 10대 초과하면 예외를 던진다")
    void createCarsByInvalidSize(List<String> carNames) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Cars(carNames))
                .withMessage("자동차 대수는 2대 이상 10대 이하여야 합니다.");
    }

    private static Stream<Arguments> InputCarNames() {
        return Stream.of(
                Arguments.arguments(List.of("1")),
                Arguments.arguments(List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"))
        );
    }
}