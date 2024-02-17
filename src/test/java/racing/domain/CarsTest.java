package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.util.RandomNumberGenerator;

class CarsTest {

    @Test
    @DisplayName("정상적인 Cars 객체 생성")
    void createCars() {
        assertThatCode(() -> new Cars("pobi,crong,honux")).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("겹치는 자동차 이름이 존재하면 예외")
    void createCarsWithDuplicateName() {
        assertThatThrownBy(() -> new Cars("pobi,pobi"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("랜덤값이 4이상이면 N대의 자동차가 전진")
    void moveAllByMovableNumber() {
        Cars cars = new Cars("pobi,cront,honux");
        cars.moveAll(new RandomNumberGenerator(6, 4));
        List<Integer> positions = cars.getCars().stream().map(Car::getPosition).collect(Collectors.toList());
        assertThat(positions).containsOnly(1);
    }

    @Test
    @DisplayName("랜덤값이 3이하면 N대의 자동차가 멈춤")
    void moveAllByImmovableNumber() {
        Cars cars = new Cars("pobi,cront,honux");
        cars.moveAll(new RandomNumberGenerator(3, 0));
        List<Integer> positions = cars.getCars().stream().map(Car::getPosition).collect(Collectors.toList());
        assertThat(positions).containsOnly(0);
    }

    @Test
    @DisplayName("가장 먼 전진 거리를 가진 자동차가 우승")
    void findFurthestCar() {
        Cars cars = new Cars("pobi,crong,honux", List.of(1, 2, 3));
        List<Car> furthestCars = cars.findFurthestCars();
        assertThat(furthestCars).hasSize(1)
                .extracting("name")
                .containsExactly("honux");
    }

    @Test
    @DisplayName("가장 먼 전진 거리를 가진 자동차가 여러 대면 모두 우승")
    void findFurthestCars() {
        Cars cars = new Cars("pobi,crong,honux", List.of(1, 2, 2));
        List<Car> furthestCars = cars.findFurthestCars();
        assertThat(furthestCars).hasSize(2)
                .extracting("name")
                .contains("crong", "honux");
    }
}
