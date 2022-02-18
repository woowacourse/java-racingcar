package carracing.view.output;

import java.util.List;
import java.util.stream.Collectors;

import carracing.model.Car;
import carracing.view.messages.ExceptionMessage;
import carracing.view.messages.OutputMessage;

public class ConsoleOutputView implements OutputView {
	private static final String DELIMITER_BETWEEN_NAME_AND_POSITION = " : ";
	private static final String CAR_POSITION_UNIT = "_";
	private static final String DELIMITER_FOR_JOINING_WINNERS = ",";

	public ConsoleOutputView() { }

	@Override
	public void printInputCarName() {
		System.out.println(OutputMessage.INPUT_CAR_NAME.getMessage());
	}

	@Override
	public void printInputNumberOfGames() {
		System.out.println(OutputMessage.INPUT_NUM_OF_GAMES.getMessage());
	}

	@Override
	public void printException(String message) {
		System.out.println(ExceptionMessage.PREFIX.getMessage() + message);
	}

	@Override
	public void printResultMessage() {
		System.out.println(OutputMessage.RESULT_MESSAGE.getMessage());
	}

	@Override
	public void printResultOfEachGame(List<Car> cars) {
		cars.forEach(car ->
			System.out.println(generateResultString(car))
		);
		printNewLine();
	}

	@Override
	public void printWinners(List<Car> winners) {
		System.out.println(generateWinnersString(winners) + OutputMessage.FINAL_WINNER_MESSAGE.getMessage());
	}

	private void printNewLine() {
		System.out.println();
	}

	private String generateWinnersString(List<Car> winners) {
		return String.join(DELIMITER_FOR_JOINING_WINNERS, covertWinnersToStringList(winners));
	}

	private List<String> covertWinnersToStringList(List<Car> winners) {
		return winners.stream()
			.map(Car::getName)
			.collect(Collectors.toList());
	}

	private String generateResultString(Car car) {
		return car.getName() + DELIMITER_BETWEEN_NAME_AND_POSITION + CAR_POSITION_UNIT.repeat(car.getPosition());
	}
}
