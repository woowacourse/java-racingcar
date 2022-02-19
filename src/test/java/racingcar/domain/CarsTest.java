package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NoneAskiiCharacters")
public class CarsTest {
    private Car car1;
    private Car car2;
    private Cars cars;

    @BeforeEach
    void setUp() {
        car1 = new Car(new CarName("칙촉"));
        car2 = new Car(new CarName("어썸오"));
        cars = new Cars(Arrays.asList(car1, car2), () -> true);
    }

    @Test
    void 우승자를_선출한다_우승자가_한명인경우() {
        car1.attemptToMove(true);
        car2.attemptToMove(false);

        assertThat(cars.findWinners()).containsExactly(car1);
    }

    @Test
    void 우승자를_선출한다_우승자가_두명인경우() {
        car1.attemptToMove(true);
        car2.attemptToMove(true);

        assertThat(cars.findWinners()).containsExactly(car1, car2);
    }

    @Test
    void 모든_자동차가_전진할_경우() {
        //given
        final Position positionAfterMove = new Position(2);

        //when
        cars.attemptToMoveCars();

        //then
        assertThat(car1.getPosition()).isEqualTo(positionAfterMove);
        assertThat(car2.getPosition()).isEqualTo(positionAfterMove);
    }

    @Test
    void 자동차가_중복된_이름을_가지고_있을_경우_예외발생() {
        Car car1 = new Car(new CarName("앨런"));
        Car car2 = new Car(new CarName("앨런"));
        List<Car> inCorrectCars = Arrays.asList(car1, car2);

        assertThatThrownBy(() -> new Cars(inCorrectCars, () -> true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복");
    }

    @Test
    void 자동차가_한대_일경우_예외발생() {
        List<Car> onlyOneCar = List.of(car1);

        assertThatThrownBy(() -> new Cars(onlyOneCar, () -> true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("최소");
    }

    @Test
    void 자동차들이_null_일경우_예외발생() {
        assertThatThrownBy(() -> new Cars(null, () -> true))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("null");
    }
}
