package carracing.view.output;

import java.util.List;

import carracing.model.Car;

public interface OutputView {
	void printInputCarName();

	void printInputNumberOfGames();

	void printException(String message);

	void printResultMessage();

	void printResultOfEachGame(List<Car> cars);

	void printWinners(List<Car> winners);
}
