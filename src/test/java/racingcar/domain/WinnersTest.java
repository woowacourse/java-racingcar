package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnersTest {

    private final List<Car> cars = new ArrayList<>();

    @Test
    void getWinnersTest_한_명() {
        cars.add(new Car("루트", 2));
        cars.add(new Car("소롱", 5));

        List<String> expected = Stream.of("소롱")
                .collect(Collectors.toList());

        List<String> actual = new Winners(cars, 5).getWinners();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void getWinnersTest_두_명_이상() {
        cars.add(new Car("루트", 2));
        cars.add(new Car("소롱", 2));

        List<String> expected = Stream.of("루트", "소롱")
                .collect(Collectors.toList());

        List<String> actual = new Winners(cars, 2).getWinners();
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void getWinnerTest_모두_움직이지_않음() {
        cars.add(new Car("루트", 0));
        cars.add(new Car("소롱", 0));

        List<String> expected = Stream.of("루트", "소롱")
                .collect(Collectors.toList());

        List<String> actual = new Winners(cars, 0).getWinners();
        assertThat(actual).isEqualTo(expected);
    }
}
