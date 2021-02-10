package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racing.domain.name.CarName;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private static Stream<Arguments> moveTest() {
        return Stream.of(Arguments.of(1, false),
                Arguments.of(2, false),
                Arguments.of(4, true),
                Arguments.of(9, true));
    }

    @DisplayName("값이 4이상이면 이동, 아니면 이동하지 않는다")
    @ParameterizedTest
    @MethodSource("moveTest")
    void Car_값이_4_이상일때_이동한다(int randomNumber, boolean isMoved) {
        CarName carName = new CarName("pobi");
        Car pobiCar = new Car(carName);
        boolean moveResult = pobiCar.move(randomNumber);

        assertThat(moveResult).isEqualTo(isMoved);
    }
}
