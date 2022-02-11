package racingcar.service;

import java.util.List;

import racingcar.domain.car.CarCollection;
import racingcar.domain.round.Round;
import racingcar.service.picker.NumberPicker;

public class GameServiceImpl implements GameService {

	private final NumberPicker numberPicker;
	private CarCollection carCollection;
	private Round round;

	public GameServiceImpl(NumberPicker numberPicker) {
		this.numberPicker = numberPicker;
	}

	public void initCarNames(List<String> carNames) {
		this.carCollection = new CarCollection(carNames);
	}

	public void initRound(int count) {
		this.round = new Round(count);
	}

	public boolean isContinuable() {
		return (round.isNotFinished());
	}

	public List<String> playRound() {
		carCollection.goForwardOrStop(numberPicker);
		round.decreaseCount();
		return carCollection.getStatuses();
	}

	public List<String> getWinnerNames() {
		return carCollection.getWinnerNames();
	}

}
