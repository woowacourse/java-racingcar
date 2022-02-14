package racingcar;

import racingcar.domain.Car;
import racingcar.service.RacingService;
import racingcar.ui.RacingCarOutput;
import racingcar.utils.CarsGenerator;
import racingcar.utils.RoundNumberGenerator;

import java.util.List;

public class RacingCarMain {
    public static void main(String[] args) {
        List<Car> cars = CarsGenerator.carNameInput();
        int round = RoundNumberGenerator.roundInput();
        RacingService racingService = new RacingService(cars);
        RacingCarOutput.printRoundResultMessage();
        racingService.race(round);
        RacingCarOutput.printWinners(racingService.findWinners());
    }
}
