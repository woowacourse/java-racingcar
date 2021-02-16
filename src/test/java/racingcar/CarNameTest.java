package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.CarName;
import racingcar.domain.Cars;

public class CarNameTest {

    @DisplayName("1~5 범위 넘어가는 이름 체크")
    @ParameterizedTest
    @ValueSource(strings = {"sixsix", ""})
    void checkNameLength(String value) {
        assertThatThrownBy(() -> {
            CarName carName = new CarName(value);
        }).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("이름 1개 또는 중복 값 처리")
    @ParameterizedTest
    @MethodSource("generateData")
    void addCarNames(List<String> carNamesInput) {
        assertThatThrownBy(() -> new Cars(carNamesInput))
            .isInstanceOf(RuntimeException.class);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
            Arguments.of(Arrays.asList("one")),
            Arguments.of(Arrays.asList("one", "one"))
        );
    }

}
