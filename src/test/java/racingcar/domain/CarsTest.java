package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarsTest {

    @Test
    @DisplayName("중복된 자동차 이름을 입력한 경우 예외 발생")
    void carNameMustNotDuplicated() {
        String[] carNames = {"woo", "te", "co", "woo"};

        assertThatThrownBy(() -> Cars.from(carNames))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("한명의 올바른 최종 우승자를 선택하는지 확인")
    void selectOneRightWinner() {
        Set<Car> input = new HashSet<>();

        input.add(new Car(new CarName("woo"), 10));
        input.add(new Car(new CarName("te"), 0));
        input.add(new Car(new CarName("co"), 0));

        Cars cars = new Cars(input);

        assertThat(cars.selectWinners()).containsExactly("woo");
    }

    @Test
    @DisplayName("여러명의 올바른 최종 우승자를 선택하는지 확인")
    void selectManyRightWinner() {
        Set<Car> input = new HashSet<>();

        input.add(new Car(new CarName("woo"), 10));
        input.add(new Car(new CarName("te"), 10));
        input.add(new Car(new CarName("co"), 0));

        Cars cars = new Cars(input);
        List<String> winners = cars.selectWinners();

        assertThat(cars.selectWinners().size()).isEqualTo(2);
        assertThat(winners).contains("woo");
        assertThat(winners).contains("te");
    }
}
