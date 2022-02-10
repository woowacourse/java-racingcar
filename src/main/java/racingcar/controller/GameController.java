package racingcar.controller;

import racingcar.repository.CarRepository;
import racingcar.domain.Car;
import racingcar.service.CarNameParser;
import racingcar.view.*;

import java.util.*;
import java.util.stream.Collectors;

public class GameController {
    public static final String NOT_FOUND_CARS = "[ERROR] 자동차를 찾을 수 없습니다.";
    private static final int RandomRange = 10;
    private static final int PivotNumber = 4;

    private InputView inputView;
    private OutputView outputView;
    private CarRepository carRepository;
    private int roundNumber;

    public GameController(CarRepository carRepository, InputView inputView, OutputView outputView) {
        this.carRepository = carRepository;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public GameController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void playGame() {
        System.out.println("실행 결과");
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
        return random.nextInt(RandomRange) < PivotNumber;
    }

    public void playRound() {
        moveCars();
        List<Car> cars = carRepository.findAll();
        outputView.showCurrentStatus(cars);
    }

    public void setGame() {
        setCars();
        setRoundNumbers();
    }

    private void setCars() {
        outputView.printAskCarNameInputMessage();

        String input = inputView.readCarNamesInput();
        List<String> carNames = Arrays.asList(CarNameParser.parseCarNameInputs(input));

        List<Car> cars = new ArrayList<>();
        carNames.forEach(x -> cars.add(new Car(x)));

        carRepository.addCars(cars);
    }

    private void setRoundNumbers() {
        outputView.printAskRoundNumberMessage();
        roundNumber = inputView.readRoundNumberInput();
    }

    public void play() {
        setGame();
        playGame();
        inputView.terminate();
        outputView.showGameResult(getWinners());
    }

    public List<Car> getWinners() {
        List<Car> cars = carRepository.findAll();

        Car maxCar = cars.stream()
                .max(Car::compareTo)
                .stream()
                .findAny()
                .orElseThrow(() -> new RuntimeException(NOT_FOUND_CARS));

        List<Car> winners = cars.stream()
                .filter(car -> car.isSamePosition(maxCar))
                .collect(Collectors.toList());

        return winners;
    }
}
