package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

import racingcar.domain.Car;
import racingcar.domain.CarName;

@SuppressWarnings("NoneAsciiCharacters")
public class UserInputConvertorTest {
    @Test
    void 문자열을_자동차_리스트로_변환_테스트() {
        final String input = "칙촉,어썸오,앨런";
        List<Car> cars = UserInputConvertor.convertToCars(input);
        Car car1 = new Car(new CarName("칙촉"));
        Car car2 = new Car(new CarName("어썸오"));
        Car car3 = new Car(new CarName("앨런"));

        assertThat(cars).containsExactly(car1, car2, car3);
    }
}
