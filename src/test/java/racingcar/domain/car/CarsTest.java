package racingcar.domain.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Cars 는 ")
class CarsTest {

    private static final int ONGOING_NUMBER = 4;
    private static final String MALLANG_NAME = "말랑";
    private static final String KYLE_NAME = "카일";

    @Test
    @DisplayName("String List를 받아 해당 이름을 가진 Car를 생성한다.")
    void test_1() {
        // given
        List<String> names = List.of(MALLANG_NAME, KYLE_NAME);

        // when
        Cars cars = new Cars(names);

        // then
        assertThat(cars.cars().size()).isEqualTo(names.size());
    }

    @Test
    @DisplayName("생성 시 이름의 수가 1개 이하인 경우 예외가 발생한다.")
    void test_2() {
        // given
        List<String> names = List.of(MALLANG_NAME);

        // when & then
        Assertions.assertThatThrownBy(() -> new Cars(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("move() 시 Cars에 속한 Car들을 각각 움직인다.")
    void test_3() {
        // given
        Cars cars = new Cars(List.of(MALLANG_NAME, KYLE_NAME));
        List<Car> beforeMoveCars = cars.cars().stream()
                .map(it -> new Car(it.name().value()))
                .collect(Collectors.toList());

        // when
        cars.move(ONGOING_NUMBER, ONGOING_NUMBER);

        // then
        List<Car> afterMoveCars = cars.cars();
        for (int i = 0; i < beforeMoveCars.size(); i++) {
            assertThat(afterMoveCars.get(i).position().value())
                    .isEqualTo(beforeMoveCars.get(i).position().value() + 1);
        }
    }
}