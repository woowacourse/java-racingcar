package racingcar.domain.car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    @DisplayName("Cars 객체 생성")
    void create() {
        assertThat(new Cars("java,pobi,jason").size()).isEqualTo(3);
    }

    @Test
    @DisplayName("Cars toList 테스트")
    void toListTest() {
        Cars cars = new Cars("java,jason,pobi");
        List<Car> carList = Arrays.asList(
                new Car("java"),
                new Car("jason"),
                new Car("pobi")
        );
        assertEquals(carList, cars.toList());
    }

    @Test
    @DisplayName("Cars 추가 삽입 테스트")
    void addTest() {
        Cars cars = new Cars("pobi");
        assertFalse(cars.isEmpty());
        cars.add(new Car("jason"));
        List<Car> carList = Arrays.asList(
                new Car("pobi"),
                new Car("jason")
        );
        assertEquals(carList, cars.toList());
    }

    @Test
    @DisplayName("Cars 추가 삽입 중복 이름 예외 처리")
    void addException() {
        Cars cars = new Cars("jason");
        Car car = new Car("jason");
        assertThrows(IllegalArgumentException.class, () -> cars.add(car));
    }
}