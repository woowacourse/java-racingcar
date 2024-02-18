package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
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
    @DisplayName("[Success] 자동차가 정상적으로 생성됨")
    void createCars() {
        List<String> carNames = List.of("a", "b");

        assertThatCode(() -> Cars.of(carNames))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("[Exception] 중복된 자동차 이름이 있으면 예외를 던진다")
    void createCarsByDuplicateCarNames() {
        List<String> carNames = List.of("123", "123");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> Cars.of(carNames))
                .withMessage("자동차 이름은 중복될 수 없습니다.");
    }

    @ParameterizedTest
    @MethodSource("InputCarNames")
    @DisplayName("[Exception] 자동차 대수가 2대 미만이거나 10대 초과하면 예외를 던진다")
    void createCarsByInvalidSize(List<String> carNames) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Cars.of(carNames))
                .withMessage("자동차 대수는 2대 이상 10대 이하여야 합니다.");
    }

    private static Stream<Arguments> InputCarNames() {
        return Stream.of(
                Arguments.arguments(List.of("1")),
                Arguments.arguments(List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"))
        );
    }

    // TODO: getWinners 테스트 코드 추가
}
