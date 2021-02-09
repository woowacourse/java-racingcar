package racingcar;

import racingcar.model.Cars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarsTest {

    @ParameterizedTest()
    @MethodSource("invalidParameters")
    @DisplayName("Users 생성 유효성 검사")
    void invalidCreate(List<String> carNames) {
        assertThrows(IllegalArgumentException.class, ()-> new Cars(carNames));
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new Cars(carNames));
        assertThat(e.getMessage()).isEqualTo(Cars.CAR_NAME_INVALID);
    }

    static Stream<Arguments> invalidParameters() throws Throwable {
        return Stream.of(
                Arguments.arguments(Arrays.asList("pika", "pika", "ryan")),
                Arguments.arguments(Arrays.asList("pika", "ryan", "  ")),
                Arguments.of(Arrays.asList("ryan")),
                Arguments.of(Arrays.asList("a"))
        );
    }
}
