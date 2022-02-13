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

	private int roundNumber;

	public CarController(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	public void initGame() {
		initCars();
		initRoundNumbers();
	}

	private void initCars() {
		Voider voider = () -> {
			String carNames = InputView.inputCarNames();
			Cars cars = new Cars(carNames);
			List<Car> carList = cars.getCars();
			carRepository.addCars(carList);
		};
		commonInputProcess(voider);
	}

	private void initRoundNumbers() {
		Voider voider = () -> {
			String input = InputView.inputRoundNumber();
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
				InputView.printErrorMessage(exception);
			}
		}
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
