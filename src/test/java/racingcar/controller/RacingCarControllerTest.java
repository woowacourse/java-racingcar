package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarDto;
import racingcar.domain.RacingGame;

class RacingCarControllerTest {

    private final RacingCarController controller = new RacingCarController();
    private final List<String> carNames = Arrays.asList("carA", "carB", "carC", "carD");

    @Test
    @DisplayName("레이싱 게임 생성 테스트")
    void initRacing() {
        RacingGame racingGame = controller.initRacing(carNames, 5);
        List<Car> cars = racingGame.findWinners(); // race() 전이므로 모든 자동차가 우승자
        assertThat(cars).contains(new Car("carA"),
                new Car("carB"),
                new Car("carC"),
                new Car("carD"));
    }

    @Test
    @DisplayName("우승자 이름 얻어오기")
    void getWinnerNames() {
        RacingGame racingGame = controller.initRacing(carNames, 5);
        List<String> winnerNames = controller.getWinnerNames(racingGame);
        assertThat(winnerNames).isEqualTo(carNames);
    }

    @Test
    @DisplayName("라운드 수만큼 경주 결과 리턴하는지 확인")
    void getRaceResults() {
        RacingGame racingGame = controller.initRacing(carNames, 5);
        Map<Integer, List<CarDto>> raceResults = controller.getRaceResults(racingGame);
        assertThat(raceResults.size()).isEqualTo(5);
    }
}