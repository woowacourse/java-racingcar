package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import domain.Car;

class CarTest {

    @DisplayName("0부터 9까지의 숫자를 넣고 차량의 전진 여부를 확인")
    @ParameterizedTest(name = "{0}을 입력 : {1}칸 이동")
    @MethodSource("randomNumberProvider")
    void move(int randomNumber, int expectedLocation) {
        Car car = Car.from("a");

        car.move(randomNumber);

        assertThat(car.getCarLocation()).isEqualTo(expectedLocation);
    }

    static Stream<Arguments> randomNumberProvider() {
        return Stream.of(
                arguments(0, 0),
                arguments(1, 0),
                arguments(2, 0),
                arguments(3, 0),
                arguments(4, 1),
                arguments(5, 1),
                arguments(6, 1),
                arguments(7, 1),
                arguments(8, 1),
                arguments(9, 1)
        );
    }
}
