package racingcar.controller;

import racingcar.repository.CarRepository;
import racingcar.domain.Car;
import racingcar.util.CarNameParser;
import racingcar.validator.CarNameValidator;
import racingcar.view.*;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class GameController {
    private static final String NOT_FOUND_CARS_MESSAGE = "[ERROR] 자동차를 찾을 수 없습니다.";

    private static final int RANDOM_RANGE = 10;
    private static final int PIVOT_NUMBER = 4;

    private InputView inputView;
    private OutputView outputView;
    private CarRepository carRepository;
    private int roundNumber;

    private GameController(GameControllerBuilder gameControllerBuilder) {
        this.inputView = gameControllerBuilder.inputView;
        this.outputView = gameControllerBuilder.outputView;
        this.carRepository = gameControllerBuilder.carRepository;
    }

    public GameController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public static GameControllerBuilder gameControllerBuilder() {
        return new GameControllerBuilder();
    }

    public void play() {
        setGame();
        playGame();
        inputView.terminate();
        outputView.showGameResult(getWinners());
    }

    private void setGame() {
        setCars();
        setRoundNumbers();
    }

    private void setCars() {
        outputView.printAskCarNameInputMessage();

        String input = inputView.readCarNamesInput();
        String[] parsedStrings = CarNameParser.parseCarNameInputs(input);
        CarNameValidator carNameValidator = new CarNameValidator();

        for (String carName : parsedStrings) {
            carNameValidator.validateCarName(carName);
        }
        List<String> carNames = Arrays.asList(parsedStrings);

        List<Car> cars = new ArrayList<>();
        carNames.forEach(x -> {
            Car car = Car.carBuilder().setName(x).build();
            cars.add(car);
        });
        carRepository.addCars(cars);
    }

    private void setRoundNumbers() {
        outputView.printAskRoundNumberMessage();
        roundNumber = inputView.readRoundNumberInput();
    }

    private void playGame() {
        outputView.printExecutionResultMessage();
        for (int i = 0; i < roundNumber; i++) {
            playRound();
        }
    }

    private void playRound() {
        moveCars();
        List<Car> cars = carRepository.findAll();
        outputView.showCurrentStatus(cars);
    }

    private void moveCars() {
        for (Car car : carRepository.findAll()) {
            car.moveOrHold(isMove());
        }
    }

    private boolean isMove() {
        return ThreadLocalRandom.current().nextInt(RANDOM_RANGE) < PIVOT_NUMBER;
    }

    public List<Car> getWinners() {
        List<Car> cars = carRepository.findAll();

        Car maxCar = cars.stream()
                .max(Car::compareTo)
                .orElseThrow(() -> new RuntimeException(NOT_FOUND_CARS_MESSAGE));

        List<Car> winners = cars.stream()
                .filter(car -> car.isSamePosition(maxCar))
                .collect(Collectors.toList());

        return winners;
    }

    public static class GameControllerBuilder {
        private InputView inputView;
        private OutputView outputView;
        private CarRepository carRepository;

        public GameControllerBuilder setInputView(InputView inputView) {
            this.inputView = inputView;
            return this;
        }

        public GameControllerBuilder setOutputView(OutputView outputView) {
            this.outputView = outputView;
            return this;
        }

        public GameControllerBuilder setCarRepository(CarRepository carRepository) {
            this.carRepository = carRepository;
            return this;
        }

        public GameController build() {
            return new GameController(this);
        }
    }
}
