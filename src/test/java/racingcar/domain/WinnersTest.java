package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("NonAsciiCharacters")
public class WinnersTest {
    @Test
    void 자동차들의_위치중_가장_큰_값을_반환() {
        Car car1 = new Car("두강");
        Car car2 = new Car("무늬");
        Car car3 = new Car("코일");

        car1.play(5);
        car2.play(5);
        car2.play(5);
        car2.play(5);
        car3.play(5);
        car3.play(5);

        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        Winners winners = new Winners(cars);
        assertThat(winners.findMaxLocation(cars)).isEqualTo(3);
    }

    @Test
    void 위치가_가장_큰_자동차들의_이름을_반환() {
        Car car1 = new Car("두강");
        Car car2 = new Car("무늬");
        Car car3 = new Car("코일");

        car1.play(5);
        car2.play(5);
        car2.play(5);
        car2.play(5);
        car3.play(5);
        car3.play(5);

        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        List<String> result = new ArrayList<>();
        result.add("무늬");

        Winners winners = new Winners(cars);
        assertThat(winners.findWinners(cars)).isEqualTo(result);
    }
}
