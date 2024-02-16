package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CarsTest {

    static Stream<Arguments> cars() {
        return Stream.of(
                Arguments.of(new int[]{1, 1}, List.of(new Car("명오"), new Car("배키")),
                        "공동 우승자가 존재하는 경우 공동 우승자 모두를 반환한다."),
                Arguments.of(new int[]{1, 0}, List.of(new Car("명오")),
                        "1명의 우승자가 존재하는 경우 우승자를 반환한다.")
        );
    }

    @ParameterizedTest(name = "{2}")
    @MethodSource("cars")
    void findWinnersTest(int[] movement, List<Car> expected, String reason) {
        Car myungOh = new Car("명오", movement[0]);
        Car baeky = new Car("배키", movement[1]);
        Cars cars = new Cars(List.of(myungOh, baeky));
        List<Car> result = cars.findWinners();

        assertThat(result).isEqualTo(expected);
    }
}