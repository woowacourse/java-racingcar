package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import validation.ErrorMessage;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class CarsTest {

    @ParameterizedTest
    @MethodSource("generateCarName")
    @DisplayName("중복된 자동차가 있으면 예외가 발생한다")
    public void createDuplicateCarNames(String name1, String name2, String name3) {
        List<Car> cars = List.of(new Car(name1), new Car(name2), new Car(name3));

        assertThatThrownBy(() -> new Cars(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.DUPLICATE_CAR_NAME.getMessage());
    }

    static Stream<Arguments> generateCarName() {
        return Stream.of(
                Arguments.of("gray", " hoi", "hoi"),
                Arguments.of("echo", "echo ", "gray"),
                Arguments.of(" hoi", "ho i ", "gray")
        );
    }

}
