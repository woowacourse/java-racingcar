package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@SuppressWarnings("NoneAsciiCharacters")
public class RacingCarGameTest {
    private Car correctCar2;
    private Cars correctCars;
    private Count correctCount;
    private RacingCarGame racingCarGame;

    @BeforeEach
    void setUp() {
        final CarName correctName1 = new CarName("칙촉");
        final CarName correctName2 = new CarName("어썸오");
        final Car correctCar1 = new Car(correctName1);
        correctCar2 = new Car(correctName2);
        correctCars = new Cars(Arrays.asList(correctCar1, correctCar2), () -> true);
        correctCount = new MockCount(1);
        racingCarGame = new RacingCarGame(correctCars, correctCount);
    }

    @Test
    void 자동차이름_입력값을_null로_생성_시도할_경우_예외발생() {
        final Cars cars = null;

        assertThatThrownBy(() -> new RacingCarGame(cars, correctCount))
                .hasMessageContaining("null은 사용할 수 없습니다. Cars 타입을 이용하세요.");
    }

    @Test
    void MoveStrategy를_null로_생성_시도할_경우_예외발생() {
        final Count count = null;

        assertThatThrownBy(() -> new RacingCarGame(correctCars, count)).isInstanceOf(
                        IllegalArgumentException.class)
                .hasMessageContaining("null은 사용할 수 없습니다. Count 타입을 이용하세요.");
    }

    @Test
    void 올바른_매개변수로_생성되는_경우() {
        assertThatCode(() -> new RacingCarGame(correctCars, correctCount))
                .doesNotThrowAnyException();
    }

    @Test
    void 모든_자동차_전진하는_라운드() {
        //given
        List<Car> cars = racingCarGame.getCars();
        Position positionAfterMove = new Position(2);

        //when
        racingCarGame.playRound();

        //then
        for (Car car : cars) {
            assertThat(car.getPosition()).isEqualTo(positionAfterMove);
        }
    }

    @Test
    void 우승자_뽑기_한명일_경우() {
        correctCar2.attemptToMove(true);

        assertThat(racingCarGame.getWinners()).containsOnly(correctCar2);
    }

    @Test
    void 게임종료전_우승자를_뽑을경우_예외발생() {
        final Count count = new Count(1);
        final RacingCarGame racingCarGame = new RacingCarGame(correctCars, count);

        assertThatThrownBy(racingCarGame::getWinners).isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("게임이 끝나지 않았습니다.");
    }
}
