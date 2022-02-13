package racingcar.controller;

import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.repository.CarRepository;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarController {

	private final CarRepository carRepository;

	private int roundNumber;

	public CarController(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	public void initGame() {
		initCars();
		initRoundNumbers();
	}

	private void initCars() {

		String carNames = InputView.inputCarNames();
		Cars cars = new Cars(carNames);
		List<Car> carList = cars.get();
		carRepository.addCars(carList);
	}

	private void initRoundNumbers() {
		roundNumber = InputView.inputRoundNumber();
	}

	public void playGame() {
		OutputView.printResultMessage();
		for (int i = 0; i < roundNumber; i++) {
			playRound();
		}
	}

	public void playRound() {
		List<Car> cars = carRepository.findAll();
		moveCars(cars);
		OutputView.showCurrentStatus(cars);
	}

	public List<Car> getWinners() {
		List<Car> findCars = carRepository.findAll();

		Cars cars = new Cars(findCars);

		return cars.getWinners();
	}

	public void moveCars(List<Car> cars) {
		for (Car car : cars) {
			car.move();
		}
	}

	public void end() {
		InputView.terminateScanner();
	}

	public void showWinners() {
		List<Car> winners = getWinners();
		OutputView.showGameResult(winners);
	}
}
