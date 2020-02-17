package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;

import java.util.ArrayList;
import java.util.List;

public class WinnersTest {
    NumberGenerator fixedNumber = new FixedNumber();
    @Test
    @SuppressWarnings("NonAsciiCharacters")
    void 자동차들의_위치중_가장_큰_값을_반환() {
        Car car1 = new Car("두강");
        Car car2 = new Car("무늬");
        Car car3 = new Car("코일");

        car1.play(fixedNumber);
        car2.play(fixedNumber);
        car2.play(fixedNumber);
        car2.play(fixedNumber);
        car3.play(fixedNumber);
        car3.play(fixedNumber);

        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        Winners winners = new Winners(cars);
        assertThat(winners.findMaxLocation(cars)).isEqualTo(3);
    }

    @Test
    @SuppressWarnings("NonAsciiCharacters")
    void 위치가_가장_큰_자동차들의_이름을_반환() {
        Car car1 = new Car("두강");
        Car car2 = new Car("무늬");
        Car car3 = new Car("코일");

        car1.play(fixedNumber);
        car2.play(fixedNumber);
        car2.play(fixedNumber);
        car2.play(fixedNumber);
        car3.play(fixedNumber);
        car3.play(fixedNumber);

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
