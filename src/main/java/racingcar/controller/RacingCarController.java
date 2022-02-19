package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.car.Car;
import racingcar.domain.movement.RandomMovementStrategy;
import racingcar.dto.CarDTO;
import racingcar.service.RacingCarService;

public class RacingCarController {

    private RacingCarService service;

    public RacingCarController(String inputCarNames, String inputRoundNumber) {
        this.service = createRacingService(inputCarNames, inputRoundNumber);
    }

    private RacingCarService createRacingService(String inputCarNames, String inputRoundNumber) {
        return new RacingCarService(inputCarNames, inputRoundNumber);
    }

    public boolean isRunnable() {
        return !service.isRoundEnd();
    }

    public List<CarDTO> run() {
        if (!isRunnable()) {
            throw new IllegalArgumentException("경주할 자동차가 없습니다.");
        }
        return toDTO(service.run(new RandomMovementStrategy()));
    }

    private List<CarDTO> toDTO(List<Car> cars) {
        return cars.stream()
            .map(CarDTO::from)
            .collect(Collectors.toList());
    }

    public List<CarDTO> end() {
        return toDTO(service.findWinners());
    }
}
