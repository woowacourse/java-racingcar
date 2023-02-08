package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Cars 는 ")
class CarsTest {

    @Test
    @DisplayName("String List를 받아 해당 이름을 가진 Car를 생성한다.")
    void test_1() {
        // given
        List<String> names = List.of("체체", "말랑");

        // when
        Cars cars = new Cars(names);

        // then
        assertThat(cars.getCars().size()).isEqualTo(names.size());
    }

    @Test
    @DisplayName("생성 시 이름의 수가 1개 이하인 경우 예외가 발생한다.")
    void test_2() {
        // given
        List<String> names = List.of("체체");

        // when & then
        Assertions.assertThatThrownBy(() -> new Cars(names))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("move() 시 Cars에 속한 Car들을 각각 움직인다.")
    void test_3() {
        // given
        Cars cars = new Cars(List.of("체체", "말랑"));
        List<Car> beforeMoveCars = cars.getCars().stream()
                .map(it -> new Car(it.getName().getName()))
                .collect(Collectors.toList());

        // when
        cars.move(new MockFixedNumberGenerator(4));

        // then
        List<Car> afterMoveCars = cars.getCars();
        for (int i = 0; i < beforeMoveCars.size(); i++) {
            assertThat(afterMoveCars.get(i).getPosition().getValue())
                    .isEqualTo(beforeMoveCars.get(i).getPosition().getValue() + 1);
        }
    }

    class MockFixedNumberGenerator extends NumberGenerator {
        private int returnNumber;

        public MockFixedNumberGenerator(int returnNumber) {
            this.returnNumber = returnNumber;
        }

        @Override
        public int generate(int minNumber, int maxNumber) {
            return returnNumber;
        }
    }
}