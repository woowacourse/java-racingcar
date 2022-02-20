package racingcar.view.log;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.MockRandomNumberGenerator;
import racingcar.domain.Cars;
import racingcar.view.log.GameLog;

class GameLogTest {

    private static final String CAR_1_NAME = "pobi";
    private static final String CAR_2_NAME = "jason";

    private Cars cars;
    private MockRandomNumberGenerator mockRandomNumberGenerator;
    private GameLog gameLog;

    @BeforeEach
    public void setUp() {
        cars = new Cars(List.of(CAR_1_NAME, CAR_2_NAME));
        mockRandomNumberGenerator = new MockRandomNumberGenerator();
        gameLog = new GameLog();
        for (int i = 1; i < 5; i++) {
            cars.move(mockRandomNumberGenerator);
            gameLog.writeLog(i, cars);
        }
    }

    @Test
    @DisplayName("하나의_로그_기록_확인")
    public void getSingleLog() {
        assertThat(gameLog.getSingleLog(3).stream()
                .filter(carForLog -> carForLog.getName() == CAR_1_NAME)
                .findFirst()
                .orElseThrow()
                .getPosition())
                .isEqualTo(2);
        assertThat(gameLog.getSingleLog(3).stream()
                .filter(carForLog -> carForLog.getName() == CAR_2_NAME)
                .findFirst()
                .orElseThrow()
                .getPosition())
                .isEqualTo(1);
    }

    @Test
    @DisplayName("이름으로_자동차위치_찾기")
    public void getPositionByName() {
        assertThat(gameLog.getPositionByName(2, CAR_1_NAME)).isEqualTo(2);
        assertThat(gameLog.getPositionByName(2, CAR_2_NAME)).isEqualTo(0);
    }

    @Test
    @DisplayName("우승자_찾기")
    public void getWinnerCarNames() {
        assertThat(gameLog.getWinnerCarNames(4)).contains(CAR_1_NAME, CAR_2_NAME);
    }
}
