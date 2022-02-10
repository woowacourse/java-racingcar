package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.parser.CarNameParser;
import racingcar.repository.CarRepository;
import racingcar.service.RacingGameService;

public class RacingGameController {

    private final CarNameParser carNameParser = new CarNameParser();
    private final CarRepository carRepository;
    private final RacingGameService racingGameService;

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
}
