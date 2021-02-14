package racingcar.domain.car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    @DisplayName("Cars 객체 생성")
    void create() {
        assertAll(
                () -> assertThat(new Cars(
                        Arrays.asList(
                                new Car("java"),
                                new Car("jason"),
                                new Car("pobi")
                        )
                ).size()).isEqualTo(3),
                () -> assertTrue(new Cars().isEmpty())
        );
    }

    @Test
    @DisplayName("생성자의 방어적 객체 생성 테스트")
    void checkDeepCopy() {
        List<Car> carList = Arrays.asList(
                new Car("java"),
                new Car("jason"),
                new Car("pobi")
        );
        Cars cars = new Cars(carList);
        carList.get(0).move(9);
        assertNotEquals(carList.get(0).getPosition(), cars.toList().get(0).getPosition());
    }

    @Test
    @DisplayName("Cars toList 테스트")
    void toListTest() {
        Cars cars = new Cars(
                Arrays.asList(
                        new Car("java"),
                        new Car("jason"),
                        new Car("pobi")
                )
        );
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
        Cars cars = new Cars();
        assertTrue(cars.isEmpty());
        cars.add(new Car("pobi"));
        assertFalse(cars.isEmpty());
        List<Car> carList = Arrays.asList(
                new Car("pobi")
        );
        assertEquals(carList, cars.toList());
    }

    @Test
    @DisplayName("Cars 추가 삽입 중복 이름 예외 처리")
    void addException() {
        Cars cars = new Cars();
        Car car = new Car("jason");
        cars.add(car);
        assertThrows(IllegalArgumentException.class, () -> cars.add(car));
    }
}