package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @DisplayName("공동 우승자 확인")
    @Test
    void findWinners() {
        // given
        CarNames carNames = CarNames.from("aa,bb,cc");
        Cars cars = Cars.from(carNames);
        cars.go(() -> 5);

        // when
        List<String> winner = cars.findWinners();

        // then
        assertThat(winner).hasSize(3);
    }

    @DisplayName("단독 우승자 확인")
    @Test
    void findWinner() {
        // given
        CarNames carNames = CarNames.from("aa,bb,cc");
        Cars cars = Cars.from(carNames);
        cars.go(new TestNumberGenerator());

        // when
        List<String> winner = cars.findWinners();

        // then
        assertThat(winner).hasSize(1).isEqualTo(List.of("cc"));
    }


    static class TestNumberGenerator implements NumberGenerator {

        private static int value = 2;
        @Override
        public int generate() {
            return value++;
        }
    }
}
