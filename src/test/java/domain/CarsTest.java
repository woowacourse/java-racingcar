package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("모든 자동차")
public class CarsTest {

    @Test
    @DisplayName("이동 결과 확인")
    void moveAll() {
        List<Car> inputCars = List.of(
                new Car("pobi"),
                new Car("crong"),
                new Car("honux")
        );
        Cars cars = new Cars(inputCars);
        cars.moveAll(createCustomPowerGenerator(4));

        assertThat(cars.getCars()
                .stream()
                .allMatch(car -> car.isSameDistance(1)))
                .isTrue();
    }

    @Test
    @DisplayName("중복 이름 검증")
    void validateDuplicateCarNames() {
        List<Car> inputCars = List.of(
                new Car("pobi"),
                new Car("pobi"),
                new Car("hello")
        );

        assertThatThrownBy(() -> new Cars(inputCars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차명은 중복되어선 안됩니다.");
    }

    @Test
    @DisplayName("중 경주 우승자 확인")
    void getWinner() {
        Car pobi = new Car("pobi", 1);
        List<Car> inputCars = List.of(
                pobi,
                new Car("crong", 0),
                new Car("honux", 0)
        );

        Cars cars = new Cars(inputCars);
        assertThat(cars.getWinners())
                .containsExactly(pobi);
    }

    @Test
    @DisplayName("중 경주 우승자 확인(복수 우승자)")
    void getWinners() {
        Car pobi = new Car("pobi", 1);
        Car crong = new Car("crong", 1);
        List<Car> inputCars = List.of(
                pobi,
                crong,
                new Car("honux", 0)
        );
        Cars cars = new Cars(inputCars);

        assertThat(cars.getWinners())
                .containsExactly(pobi, crong);
    }

    public PowerGenerator createCustomPowerGenerator(int customPower) {
        return new PowerGenerator(new Random() {
            public int nextInt(int bound) {
                return customPower;
            }
        });
    }

}
