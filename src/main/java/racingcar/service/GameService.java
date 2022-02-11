package racingcar.service;

import java.util.List;

import racingcar.domain.car.CarCollection;
import racingcar.service.picker.NumberPicker;

public class GameService {

	private final NumberPicker numberPicker;
	private CarCollection carCollection;

	public GameService(NumberPicker numberPicker) {
		this.numberPicker = numberPicker;
	}

	public void initCarNames(List<String> carNames) {
		this.carCollection = new CarCollection(carNames);
	}

	public List<String> playRound() {
		carCollection.goForwardOrStop(numberPicker);
		return carCollection.getStatuses();
	}

	public List<String> getWinnerNames() {
		return carCollection.getWinnerNames();
	}

}
