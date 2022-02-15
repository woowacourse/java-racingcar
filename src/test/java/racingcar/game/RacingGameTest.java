package racingcar.game;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarDTO;
import racingcar.domain.RacingGame;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    static RacingGame racingGame = new RacingGame();
    static List<List<CarDTO>> totalExecutionResult;

    @BeforeAll
    public static void setRacingGame() {
        racingGame.initCarNames("woo,te,co");
        racingGame.initTotalAttempt("5");

        totalExecutionResult = racingGame.play();
    }

    @Test
    @DisplayName("입력된 시도횟수만큼 반복")
    public void repeatedAsAttempt() {
        assertThat(totalExecutionResult.size()).isEqualTo(5);
    }

    @Test
    @DisplayName("올바른 최종우승자 결정")
    public void selectRightWinner() {
        List<CarDTO> lastExecutionResult = totalExecutionResult.get(totalExecutionResult.size() - 1);
        int maxPosition = getMaxPosition(lastExecutionResult);
        List<String> winners = selectWinners(lastExecutionResult, maxPosition);

        assertThat(racingGame.selectWinners()).isEqualTo(winners);
    }

    private int getMaxPosition(List<CarDTO> cars) {
        return cars.stream()
                .mapToInt(CarDTO::getPosition)
                .max()
                .orElse(0);
    }

    private List<String> selectWinners(List<CarDTO> cars, int targetNum) {
        return cars.stream()
                .filter(c -> c.getPosition() == targetNum)
                .map(CarDTO::getCarName)
                .collect(Collectors.toList());
    }
}
