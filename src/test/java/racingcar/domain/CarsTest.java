package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {
    Cars cars = new Cars(List.of(new Car("tori", 10), new Car("mango", 20)));

    @Test
    @DisplayName("우승자의 이름을 Return")
    void Should_Winner_When_getWinnerMethod() {
        assertThat(cars.getWinner()).isEqualTo(List.of("mango"));
    }

}
