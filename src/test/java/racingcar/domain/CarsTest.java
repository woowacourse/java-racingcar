package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
        cars = new Cars(Arrays.asList(car1, car2));
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
    void 한_라운드를_진행한다_모든_자동차가_전진할_경우() {
        //given
        cars.setMoveStrategy(() -> true);
        final Position positionAfterMove = new Position(2);

        //when
        cars.playRound();

        //then
        assertThat(car1.getPosition()).isEqualTo(positionAfterMove);
        assertThat(car2.getPosition()).isEqualTo(positionAfterMove);
    }
}
