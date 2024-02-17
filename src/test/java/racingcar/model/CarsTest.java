package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @DisplayName("올바르지 않은 구분자")
    @ParameterizedTest
    @ValueSource(strings = {"a,b,,", ",akd,ll", "a,,b", ","})
    void invalidSeparator(String value) {
        assertThatThrownBy(() -> CarNames.from(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static class TestNumberGenerator implements NumberGenerator {

        private static int value = 2;
        @Override
        public int generate() {
            return value++;
        }
    }

    @DisplayName("자동차 이름이 중복시 예외 발생")
    @Test
    void duplicatedName() {
        assertThatThrownBy(() -> CarNames.from("aa,aa"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
