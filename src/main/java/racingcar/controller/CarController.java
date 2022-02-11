package racingcar.controller;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.strategy.MovingStrategy;
import racingcar.repository.CarRepository;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarController {

	private static final String NOT_FOUND_CARS_MESSAGE = "[ERROR] 자동차를 찾을 수 없습니다.";


	private final CarRepository carRepository;
	private int roundNumber;
	private final MovingStrategy movingStrategy;

	public void playGame() {
		OutputView.printResultMessage();
		for (int i = 0; i < roundNumber; i++) {
			playRound();
		}
	}

	public CarController(CarRepository carRepository, MovingStrategy movingStrategy) {
		this.carRepository = carRepository;
		this.movingStrategy = movingStrategy;
	}

	public void playRound() {
		moveCars();
		List<Car> cars = carRepository.findAll();
		OutputView.showCurrentStatus(cars);
	}

	public void moveCars() {
		for (Car car : carRepository.findAll()) {
			car.move();
		}
	}

	public void initGame() {
		initCars();
		initRoundNumbers();
	}

	private void initCars() {

		String carNames = InputView.inputCarNames();
		Cars cars = new Cars(carNames, movingStrategy);
		List<Car> carList = cars.get();
		carRepository.addCars(carList);
	}

	private void initRoundNumbers() {
		roundNumber = InputView.inputRoundNumber();
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
