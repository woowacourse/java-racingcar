package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;

@SuppressWarnings("NonAsciiCharacters")
public class CarsTest {

    @Test
    void 같은_이름의_자동차_생성시_예외발생() {

        List<Car> cars = Arrays.asList(new Car("happy"), new Car("good"), new Car("happy"));

        assertThatThrownBy(() -> new Cars(cars)).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 다른_이름의_자동차_생성_성공() {

        Cars cars = new Cars(Arrays.asList(new Car("happy"), new Car("good")));

        assertThat(
            cars.getCars().stream().map(Car::getName).collect(Collectors.toList())).containsExactly(
            "happy", "good");

    }

    @Test
    void getWinners_우승자_한대_반환() {

        Car car1 = new Car("happy");
        Car car2 = new Car("good");

        car1.setPosition(5);
        car2.setPosition(6);

        List<Car> carLists = new ArrayList<>();
        carLists.add(car1);
        carLists.add(car2);

        Cars cars = new Cars(carLists);

        assertThat(cars.getWinners()).containsExactly("good");

    }

    @Test
    void getWinners_우승자_두대_반환() {

        Car car1 = new Car("happy");
        Car car2 = new Car("good");

        List<Car> carLists = new ArrayList<>();
        carLists.add(car1);
        carLists.add(car2);

        car1.setPosition(6);
        car2.setPosition(6);

        Cars cars = new Cars(carLists);

        assertThat(cars.getWinners()).containsExactly("happy", "good");

    }

}
