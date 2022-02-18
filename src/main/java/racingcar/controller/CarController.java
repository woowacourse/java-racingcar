package racingcar.controller;

import java.util.List;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.vo.TryRoundNumber;
import racingcar.repository.CarRepository;
import racingcar.util.Voider;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarController {

	private final CarRepository carRepository;
	private final InputView inputView;

	private int roundNumber;

	public CarController(CarRepository carRepository, InputView inputView) {
		this.carRepository = carRepository;
		this.inputView = inputView;
	}

	public void initGame() {
		initCars();
		initRoundNumbers();
	}

	private void initCars() {
		Voider voider = () -> {
			String carNames = inputView.inputCarNames();
			Cars cars = new Cars(carNames);
			List<Car> carList = cars.getCars();
			carRepository.addCars(carList);
		};
		commonInputProcess(voider);
	}

	private void initRoundNumbers() {
		Voider voider = () -> {
			String input = inputView.inputRoundNumber();
			TryRoundNumber tryRoundNumber = new TryRoundNumber(input);
			roundNumber = tryRoundNumber.get();
		};
		commonInputProcess(voider);
	}

	private void commonInputProcess(final Voider inputFunction) {
		while (true) {
			try {
				inputFunction.execute();
				return;
			} catch (Exception exception) {
				inputView.printErrorMessage(exception);
			}
		}
	}

	public void playGame() {
		OutputView.printResultMessage();
		for (int i = 0; i < roundNumber; i++) {
			playRound();
		}
	}

	private void playRound() {
		final List<Car> cars = carRepository.findAll();
		moveCars(cars);
		OutputView.showCurrentStatus(cars);
	}

	private void moveCars(final List<Car> cars) {
		for (Car car : cars) {
			car.move();
		}
	}

	public void showWinners() {
		final List<Car> winners = getWinners();
		OutputView.showGameResult(winners);
	}

	private List<Car> getWinners() {
		final List<Car> findCars = carRepository.findAll();
		final Cars cars = new Cars(findCars);
		return cars.getWinners();
	}

	public void end() {
		inputView.terminateScanner();
	}
}
