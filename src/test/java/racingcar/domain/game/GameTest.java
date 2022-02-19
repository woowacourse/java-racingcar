package racingcar.domain.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.movement.Movement;
import racingcar.dto.CarDto;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {
    private final int[] definedMovementValue = {1, 1, 0};
    private int movementIndex = 0;
    private final Movement movementStrategy = () -> definedMovementValue[movementIndex++];
    private final List<String> carNames = Arrays.asList("Chris", "Roma", "Alex");
    private final int trialCount = 1;
    private final Game game = new Game(carNames, trialCount, movementStrategy);

    @Test
    @DisplayName("게임이 끝나지 않았는지 반환한다.")
    void isNotOver_Test() {
        assertThat(game.isNotOver()).isTrue();

        game.playOneRound();
        assertThat(game.isNotOver()).isFalse();
    }

    @Test
    @DisplayName("라운드 결과를 반환한다.")
    void getRoundResult_Test() {
        //given
        game.playOneRound();
        final CarDto firstCar = new CarDto("Chris", 1);
        final CarDto secondCar = new CarDto("Roma", 1);
        final CarDto thirdCar = new CarDto("Alex", 0);
        final List<CarDto> expected = Arrays.asList(firstCar, secondCar, thirdCar);
        //when
        final List<CarDto> actual = game.getRoundResult();
        //then
        assertThat(expected).isEqualTo(actual);
    }

    @Test
    @DisplayName("승자(들)을 반환한다.")
    void getWinners_Test() {
        //given
        game.playOneRound();
        final CarDto firstCar = new CarDto("Chris", 1);
        final CarDto secondCar = new CarDto("Roma", 1);
        final List<CarDto> expectedWinners = Arrays.asList(firstCar, secondCar);
        //when
        final List<CarDto> actualWinners = game.getWinners();
        //then
        assertThat(actualWinners).isEqualTo(expectedWinners);
    }
}