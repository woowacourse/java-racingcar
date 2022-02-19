package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

@SuppressWarnings("NoneAsciiCharacters")
public class RacingCarGameTest {
    @Test
    void 자동차이름_입력값을_null로_생성_시도할_경우_예외발생() {
        String incorrectInput = null;
        MoveStrategy correctMoveStrategy = new RandomMoveStrategy();

        assertThatThrownBy(() -> new RacingCarGame(incorrectInput, correctMoveStrategy))
                .hasMessageContaining("null은 사용할 수 없습니다. String 타입을 이용하세요.");
    }

    @Test
    void MoveStrategy를_null로_생성_시도할_경우_예외발생() {
        String correctInput = "어썸오,칙촉";
        MoveStrategy incorrectMoveStrategy = null;

        assertThatThrownBy(() -> new RacingCarGame(correctInput, incorrectMoveStrategy)).isInstanceOf(
                        IllegalArgumentException.class)
                .hasMessageContaining("null은 사용할 수 없습니다. MoveStrategy 타입을 이용하세요.");
    }

    @Test
    void 올바른_매개변수로_생성되는_경우() {
        String correctInput = "어썸오,칙촉";
        MoveStrategy correctMoveStrategy = new RandomMoveStrategy();

        assertThatCode(() -> new RacingCarGame(correctInput, correctMoveStrategy))
                .doesNotThrowAnyException();
    }

    @Test
    void 모든_자동차_전진하는_라운드() {
        //given
        String inputCarNames = "어썸오,칙촉";
        RacingCarGame racingCarGame = new RacingCarGame(inputCarNames, () -> true);
        List<Car> cars = racingCarGame.getCars();
        Position positionAfterMove = new Position(2);
        racingCarGame.setCount(new Count(1));

        //when
        racingCarGame.playRound();

        //then
        for (Car car : cars) {
            assertThat(car.getPosition()).isEqualTo(positionAfterMove);
        }
    }

    @Test
    void 우승자_뽑기_한명일_경우() {
        //given
        String inputCarNames = "어썸오,칙촉";
        RacingCarGame racingCarGame = new RacingCarGame(inputCarNames, () -> true);
        racingCarGame.setCount(new MockCount(1));
        List<Car> cars = racingCarGame.getCars();
        Car awesome0 = cars.get(0);

        //when
        awesome0.attemptToMove(true);

        //then
        assertThat(racingCarGame.getWinners()).containsOnly(awesome0);
    }

    @Test
    void 게임종료전_우승자를_뽑을경우_예외발생() {
        String inputCarNames = "어썸오,칙촉";
        RacingCarGame racingCarGame = new RacingCarGame(inputCarNames, () -> true);
        racingCarGame.setCount(new Count(1));

        assertThatThrownBy(racingCarGame::getWinners).isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("게임이 끝나지 않았습니다.");
    }
}
