package racing.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

class WinnersTest {

    @Test
    void Winners_1명_이상의_우승자_정상_생성된다() {
        Car pobi = new Car("pobi");
        assertThatCode(() ->
                new Winners(new ArrayList<>(Arrays.asList(pobi))))
                .doesNotThrowAnyException();
    }

    @Test
    void Winners_우승자가_한명도_없으면_에러가_발생한다() {
        assertThatThrownBy(() -> new Winners(new ArrayList<>()))
                .isInstanceOf(IllegalStateException.class);
    }

    static class Winners {
        private final List<Car> cars;

        public Winners(List<Car> cars) {
            this.cars = new ArrayList<>(cars);
            validateWinners();
        }

        public List<String> getWinnersName(){
            return cars.stream()
                    .map(Car::getName)
                    .collect(Collectors.toList());
        }

        private void validateWinners() {
            if (this.cars.isEmpty()) {
                throw new IllegalStateException();
            }
        }
    }
}