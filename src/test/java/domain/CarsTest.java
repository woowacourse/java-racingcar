package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarsTest {
    @DisplayName("중복된 이름이 있으면 예외 발생")
    @Test
    void duplicateTest() {
        assertThatThrownBy(() -> Cars.from(List.of("a", "a")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("차 이름은 중복될 수 없습니다");
    }

    @DisplayName("우승자는 가장 멀리 간 차들이다")
    @Test
    void getWinnersTest() {
        //given
        Cars cars = Cars.from(List.of("a", "b", "c"));
        List<Integer> powers = List.of(0, 9, 9);

        //when
        cars.move(new TestPowerGenerator(powers));

        //then
        assertThat(cars.getWinners())
                .containsExactly("b", "c");
    }

    private static class TestPowerGenerator implements PowerGenerator {
        Iterator<Integer> iterator;

        public TestPowerGenerator(List<Integer> powers) {
            this.iterator = powers.iterator();
        }

        @Override
        public int nextPower() {
            return iterator.next();
        }
    }
}