package racingcar.controller;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.RacingCarNamesRequest;
import racingcar.dto.RacingCarStatusResponse;
import racingcar.dto.RacingCarWinnerResponse;
import racingcar.dto.TryCountRequest;
import racingcar.service.RacingCarService;
import racingcar.view.RacingCarView;

class RacingCarControllerTest {
    private RacingCarController racingCarController;

    private static class MockRacingCarView implements RacingCarView {
        @Override
        public RacingCarNamesRequest receiveCarNames() {
            return RacingCarNamesRequest.of("car1,car2,car3");
        }

        @Override
        public TryCountRequest receiveTryCount() {
            return TryCountRequest.of("5");
        }

        @Override
        public void printRacingProgress(List<RacingCarStatusResponse> responses) {

        }

        @Override
        public void printWinners(RacingCarWinnerResponse response) {

        }

        @Override
        public void printStartMessage() {

        }
    }

    @BeforeEach
    void setUp() {
        racingCarController = new RacingCarController(new RacingCarService(), new MockRacingCarView());
    }

    @Test
    @DisplayName("Controller가 정상적으로 작동해야한다.")
    void controller_start() {
        racingCarController.start();
    }
}