package racingcar.model;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarsTest {

    @DisplayName("공동 우승자 확인")
    @Test
    void findWinners() {
        // given
        Cars cars = Cars.from("aa,bb,cc");
        cars.go(() -> 5);

        // when
        List<Car> winner = cars.findWinner();

        // then
        Assertions.assertThat(winner).hasSize(3);
    }

    @DisplayName("단독 우승자 확인")
    @Test
    void findWinner() {
        // given
        Cars cars = Cars.from("aa,bb,cc");
        cars.go(new TestNumberGenerator());
        // when
        List<Car> winner = cars.findWinner();

        // then
        Assertions.assertThat(winner).hasSize(1).extracting("name").isEqualTo(List.of("cc"));
    }

    @DisplayName("올바르지 않은 구분자")
    @ParameterizedTest
    @ValueSource(strings = {"a,b,,", ",akd,ll", "a,,b", ","})
    void invalidSeparator(String value) {
        Assertions.assertThatThrownBy(() -> Cars.from(value))
                .isInstanceOf(IllegalArgumentException.class);
    }



    static class TestNumberGenerator implements NumberGenerator {

        private static int value = 2;
        @Override
        public int generate() {
            return value++;
        }
    }
}