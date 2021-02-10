package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CarsTest {
    @Test
    @DisplayName("자동차들 이름이 중복되었을 경우")
    void carsDuplicatedName() {
        assertThatThrownBy(() -> {
            Cars cars = new Cars(
                    Arrays.asList(
                            new Car(new Name("pobi")),
                            new Car(new Name("pobi")),
                            new Car(new Name("pobi"))
                    ));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동차들 중 최대 position car 확인")
    void carsGetMaxPosition() {
        Cars cars = new Cars(
                Arrays.asList(
                        new Car(new Name("pobi"), 0),
                        new Car(new Name("amazi"), 3)
                ));
        assertThat(cars.getMaxPositionCar())
                .isEqualTo(new Car(new Name("amazi"), 3));
    }

    @Test
    void defensiveCopy() {
        final List<Car> cars = new ArrayList<>();
        final Cars actual = new Cars(cars);

        cars.add(new Car(new Name("amazi")));

        assertThat(actual.cars()).isEmpty();
    }
}
