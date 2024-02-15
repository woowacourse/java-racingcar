package model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CarsTest {

    private static Car myungOh;
    private static Car baeky;

    @BeforeEach
    void beforeEach() {
        myungOh = new Car("명오");
        baeky = new Car("배키");
    }

    static Stream<Arguments> cars() {
        return Stream.of(
                Arguments.of(List.of(true, true), 2, "공동 우승자가 존재하는 경우 공동 우승자 모두를 반환한다."),
                Arguments.of(List.of(true, false), 1, "1명의 우승자가 존재하는 경우 우승자를 반환한다.")
        );
    }

    @ParameterizedTest(name = "{2}")
    @MethodSource("cars")
    void findWinnersTest(List<Boolean> move, int expected, String reason) {
        Cars cars = new Cars(List.of(myungOh, baeky));
        cars.moveCars(move);

        List<Car> result = cars.findWinners();

        assertThat(result).hasSize(expected);
    }

}