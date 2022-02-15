package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;

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

    @Test
    void 생성자의_파라미터가_구분자만_있을_경우_예외발생() {
        final String nameString = ",";

        assertThatThrownBy(() -> new Cars(nameString))
            .isInstanceOf(RuntimeException.class)
            .hasMessageContaining("이름을 입력해주세요");
    }

    @Test
    void 생성자의_파라미터가_중복된_이름을_가지고_있을_경우_예외발생() {
        final String nameString = "pobi,pobi";

        assertThatThrownBy(() -> new Cars(nameString))
            .isInstanceOf(RuntimeException.class)
            .hasMessageContaining("중복");
    }

    @Test
    void 생성자의_파라미터가_하나만의_이름을_가지고_있을_경우_예외발생() {
        final String nameString = "pobi";

        assertThatThrownBy(() -> new Cars(nameString))
            .isInstanceOf(RuntimeException.class)
            .hasMessageContaining("최소");
    }

    @Test
    void 생성자의_파라미터가_null_일경우_예외발생() {
        final String nameString = null;

        assertThatThrownBy(() -> new Cars(nameString))
            .isInstanceOf(RuntimeException.class)
            .hasMessageContaining("값을 입력해주세요!");
    }

    @Test
    void 생성자의_파라미터가_빈값_일경우_예외발생() {
        final String nameString = "";

        assertThatThrownBy(() -> new Cars(nameString))
            .isInstanceOf(RuntimeException.class)
            .hasMessageContaining("값을 입력해주세요!");
    }
}
