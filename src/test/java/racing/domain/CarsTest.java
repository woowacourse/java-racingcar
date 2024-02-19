package racing.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    @DisplayName("겹치는 자동차 이름이 없으면 Cars 객체 생성")
    void createCars() {
        assertThatCode(() -> new Cars(
                List.of(new Car("pobi"), new Car("crong"), new Car("honux")))).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("겹치는 자동차 이름이 존재하면 예외")
    void createCarsWithDuplicateName() {
        Car car = new Car("pobi");
        assertThatThrownBy(() -> new Cars(List.of(new Car("pobi"), new Car("pobi"))))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("랜덤값이 4 이상이면 자동차가 전진한다")
    void moveAllByMovableNumber() {
        Cars cars = new Cars(List.of(new Car("pobi"), new Car("crong")));
        cars.moveAll(() -> true);
        List<Integer> positions = cars.getCars().stream().map(Car::getPosition).collect(Collectors.toList());
        assertThat(positions).containsOnly(1);
    }

    @Test
    @DisplayName("랜덤값이 3 이하면 자동차가 멈춘다")
    void moveAllByImmovableNumber() {
        Cars cars = new Cars(List.of(new Car("pobi"), new Car("crong")));
        cars.moveAll(() -> false);
        List<Integer> positions = cars.getCars().stream().map(Car::getPosition).collect(Collectors.toList());
        assertThat(positions).containsOnly(0);
    }

    @Test
    @DisplayName("최대 전진 거리를 가진 모든 자동차를 우승자로 찾을 수 있다")
    void findWinners() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("crong");
        Car car3 = new Car("honux");
        car2.move();
        car3.move();
        car3.move();
        Cars cars = new Cars(new ArrayList<>(List.of(car1, car2, car3)));

        List<Car> winners = cars.findWinners();

        assertThat(winners)
                .extracting(Car::getName)
                .containsExactly(car3.getName());
    }
}
