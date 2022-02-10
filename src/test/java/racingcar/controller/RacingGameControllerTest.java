package racingcar.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.controller.exception.RacingGameIsFinishedException;
import racingcar.domain.Car;
import racingcar.domain.MidtermResult;
import racingcar.domain.MockRandomNumberGenerator;
import racingcar.domain.WinnerResult;
import racingcar.repository.CarRepository;
import racingcar.service.RacingGameService;

class RacingGameControllerTest {

    RacingGameController racingGameController;
    CarRepository carRepository;
    RacingGameService racingGameService;

    @BeforeEach
    void setUp() {
        carRepository = new CarRepository();
        racingGameService = new RacingGameService(carRepository, new MockRandomNumberGenerator());
        racingGameController = new RacingGameController(carRepository, racingGameService);
    }

    @Test
    public void 자동차_이름_입력() {
        racingGameController.inputCarNames("pobi,crong,honux");
        assertThat(carRepository.findAll())
            .contains(Car.from("pobi"), Car.from("crong"), Car.from("honux"));
    }

    @Test
    public void 시도횟수_입력() {
        racingGameController.inputTryCount("2");
        assertThat(racingGameController.isFinished()).isFalse();
        racingGameController.proceedTurn();
        racingGameController.proceedTurn();
        assertThat(racingGameController.isFinished()).isTrue();
    }

    @Test
    public void 시도횟수_이상으로_게임_진행시_예외발생() {
        racingGameController.inputTryCount("1");
        racingGameController.proceedTurn();
        assertThatThrownBy(() -> racingGameController.proceedTurn())
            .isInstanceOf(RacingGameIsFinishedException.class);
    }

    @Test
    public void 중간_실행결과_반환() {
        racingGameController.inputCarNames("pobi,crong");
        racingGameController.inputTryCount("1");
        racingGameController.proceedTurn();
        MidtermResult result = racingGameController.getMidtermResult();
        assertThat(result.getPositionByName("pobi")).isEqualTo(1);
        assertThat(result.getPositionByName("crong")).isEqualTo(0);
    }

    @Test
    public void 우승자_반환() {
        racingGameController.inputCarNames("pobi,crong");
        racingGameController.inputTryCount("1");
        racingGameController.proceedTurn();
        WinnerResult result = racingGameController.getWinnerResult();
        assertThat(result.getWinnerNames()).contains("pobi");
    }
}