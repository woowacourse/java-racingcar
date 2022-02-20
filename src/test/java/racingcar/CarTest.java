package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;


@SuppressWarnings("NonAsciiCharacters")
public class CarTest {

    @Test
    public void 자동차_전진_테스트() {
        Car car = new Car("클레이", 0);
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    public void 자동차_객체_비교_테스트() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("클레이", 0));
        cars.add(new Car("포비", 5));
        cars.add(new Car("이브", 100));
        Collections.sort(cars, Comparator.comparingInt(Car::getPosition));
        assertThat(cars.get(2).getName()).isEqualTo("이브");
    }
}
