package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    @DisplayName("우승자 확인 테스트")
    void getWinnersTest() {
        Cars cars = new Cars(List.of(new Car("win", 3), new Car("lose", 1)));
        String winner = cars.getWinners().get(0);
        assertThat(winner).isEqualTo("win");
    }
}
