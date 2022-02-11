package racingcar.controller;

import racingcar.repository.CarRepository;
import racingcar.domain.Car;
import racingcar.validator.CarNameValidator;
import racingcar.view.*;

import java.util.*;
import java.util.stream.Collectors;

public class CarController {

    private static final String NOT_FOUND_CARS_MESSAGE = "[ERROR] 자동차를 찾을 수 없습니다.";
    private static final String EXECUTION_RESULT_MESSAGE="실행 결과";
    private static final int RANDOM_RANGE = 10;
    private static final int PIVOT_NUMBER = 4;
    private static final String CAR_NAME_DELIMINATOR = ",";

    private final CarRepository carRepository;
    private int roundNumber;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void playGame() {
        System.out.println(EXECUTION_RESULT_MESSAGE);
        for (int i = 0; i < roundNumber; i++) {
            playRound();
        }
    }

    public void moveCars() {
        Random random = new Random();
        for (Car car : carRepository.findAll()) {
            car.moveOrHold(isMove(random));
        }
    }

    private boolean isMove(Random random) {
        return random.nextInt(RANDOM_RANGE) < PIVOT_NUMBER;
    }

    public void playRound() {
        moveCars();
        List<Car> cars = carRepository.findAll();
        OutputView.showCurrentStatus(cars);
    }

    public void initGame() {
        initCars();
        initRoundNumbers();
    }

    private void initCars() {
        OutputView.printAskCarNameInputMessage();

        String input = InputView.readCarNamesInput();
        CarNameValidator.parseCarNameInputs(input);
        String[] strings = parseCarNames(input);
        List<String> carNames = Arrays.asList(strings);

        List<Car> cars = new ArrayList<>();
        carNames.forEach(x -> cars.add(new Car(x)));

        carRepository.addCars(cars);
    }

    private String[] parseCarNames(String input) {
        input = input.replaceAll(" ", "");
        return input.split(CAR_NAME_DELIMINATOR);
    }

    private void initRoundNumbers() {
        OutputView.printAskRoundNumberMessage();
        roundNumber = InputView.readRoundNumberInput();
    }

    public List<Car> getWinners() {
        List<Car> cars = carRepository.findAll();

        Car maxCar = cars.stream()
                .max(Car::compareTo)
                .stream()
                .findAny()
                .orElseThrow(() -> new RuntimeException(NOT_FOUND_CARS_MESSAGE));

        List<Car> winners = cars.stream()
                .filter(car -> car.isSamePosition(maxCar))
                .collect(Collectors.toList());

        return winners;
    }

    public void turnOffGame() {
        InputView.terminate();
        OutputView.showGameResult(getWinners());
    }
}
