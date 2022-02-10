package racingcar.controller;

import java.util.List;
import racingcar.controller.exception.GetWinnerBeforeFinishException;
import racingcar.controller.exception.RacingGameIsFinishedException;
import racingcar.domain.Car;
import racingcar.domain.MidtermResult;
import racingcar.domain.WinnerResult;
import racingcar.parser.CarNameParser;
import racingcar.parser.TryCountParser;
import racingcar.repository.CarRepository;
import racingcar.service.RacingGameService;

public class RacingGameController {

    private final CarNameParser carNameParser = new CarNameParser();
    private final TryCountParser tryCountParser = new TryCountParser();
    private final CarRepository carRepository;
    private final RacingGameService racingGameService;
    private int maxTryCount;
    private int currentTryCount;

    public RacingGameController(CarRepository carRepository, RacingGameService racingGameService) {
        this.carRepository = carRepository;
        this.racingGameService = racingGameService;
    }

    public void inputCarNames(String carNames) {
        List<String> names = carNameParser.parse(carNames);

        for (String name : names) {
            carRepository.save(Car.from(name));
        }
    }

    public void inputTryCount(String tryCount) {
        this.maxTryCount = tryCountParser.parse(tryCount);
    }

    public void proceedTurn() {
        if (isFinished()) {
            throw new RacingGameIsFinishedException();
        }
        racingGameService.proceedTurn();
        currentTryCount++;
    }

    public boolean isFinished() {
        return currentTryCount == maxTryCount;
    }

    public MidtermResult getMidtermResult() {
        return new MidtermResult(findCars());
    }

    public WinnerResult getWinnerResult() {
        if (!isFinished()) {
            throw new GetWinnerBeforeFinishException();
        }
        return new WinnerResult(findCars());
    }

    private List<Car> findCars() {
        return carRepository.findAll();
    }
}
