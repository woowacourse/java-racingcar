package racingcar;

import racingcar.controller.RacingCarController;
import racingcar.repository.CarRepository;
import racingcar.service.RacingCarService;
import racingcar.view.RacingCarView;
import racingcar.view.RacingCarViewImpl;

public class RacingCarGame {
    public static void main(String[] args) {
        RacingCarService racingCarService = new RacingCarService(new CarRepository());
        RacingCarView racingCarView = new RacingCarViewImpl();
        RacingCarController racingCarController = new RacingCarController(racingCarService, racingCarView);
        racingCarController.start();
    }
}
