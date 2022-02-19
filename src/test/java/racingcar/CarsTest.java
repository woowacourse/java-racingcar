package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.MoveCondition;

@SuppressWarnings("NonAsciiCharacters")
public class CarsTest {

    private static final MoveCondition TRUE_MOVE_CONDITION = () -> true;
    private static final MoveCondition FALSE_MOVE_CONDITION = () -> false;

    @Test
    void 같은_이름의_자동차_생성시_예외발생() {

        List<Car> cars = Arrays.asList(new Car("happy", TRUE_MOVE_CONDITION),
            new Car("good", TRUE_MOVE_CONDITION),
            new Car("happy", TRUE_MOVE_CONDITION));

        assertThatThrownBy(() -> new Cars(cars))
            .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 다른_이름의_자동차_생성_성공() {

        Cars cars = new Cars(
            Arrays.asList(new Car("happy", TRUE_MOVE_CONDITION),
                new Car("good", TRUE_MOVE_CONDITION)));

        assertThat(
            cars.getCars()
                .stream()
                .map(Car::getName)
                .collect(Collectors.toList()))
            .containsExactly("happy", "good");

    }

    @Test
    void getWinners_우승자_한대_반환() {

        Car car1 = new Car("happy", TRUE_MOVE_CONDITION);
        Car car2 = new Car("good", FALSE_MOVE_CONDITION);

        Cars cars = new Cars(Arrays.asList(car1, car2));

        car1.movePosition();

        assertThat(cars.getWinners())
            .containsExactly("happy");

    }

    @Test
    void getWinners_우승자_두대_반환() {

        Car car1 = new Car("happy", TRUE_MOVE_CONDITION);
        Car car2 = new Car("good", TRUE_MOVE_CONDITION);

        Cars cars = new Cars(Arrays.asList(car1, car2));

        car1.movePosition();
        car2.movePosition();

        assertThat(cars.getWinners())
            .containsExactly("happy", "good");

    }

}
