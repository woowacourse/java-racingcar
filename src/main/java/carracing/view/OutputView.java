package carracing.view;

import java.util.List;

import carracing.model.Car;
import carracing.view.messages.ExceptionMessage;
import carracing.view.messages.OutputMessage;

public class OutputView {
	private static final String DELIMITER_BETWEEN_NAME_AND_POSITION = " : ";
	private static final String CAR_POSITION_UNIT = "_";
	private static final String DELIMITER_FOR_JOINING_WINNERS = ",";

	private OutputView() { }

	public static void printInputCarName() {
		System.out.println(OutputMessage.INPUT_CAR_NAME.getMessage());
	}

	public static void printInputNumberOfGames() {
		System.out.println(OutputMessage.INPUT_NUM_OF_GAMES.getMessage());
	}

	public static void printException(String message) {
		System.out.println(ExceptionMessage.PREFIX.getMessage() + message);
	}

	public static void printResultMessage() {
		System.out.println(OutputMessage.RESULT_MESSAGE.getMessage());
	}

	public static void printResultOfEachGame(List<Car> cars) {
		cars.forEach(car ->
			System.out.println(generateResultString(car))
		);
		printNewLine();
	}

	public static void printNewLine() {
		System.out.println();
	}

	public static void printWinners(List<String> winners) {
		System.out.println(generateWinnersString(winners) + OutputMessage.FINAL_WINNER_MESSAGE.getMessage());
	}

	private static String generateWinnersString(List<String> winners) {
		return String.join(DELIMITER_FOR_JOINING_WINNERS, winners);
	}

	private static String generateResultString(Car car) {
		return car.getName() + DELIMITER_BETWEEN_NAME_AND_POSITION + CAR_POSITION_UNIT.repeat(car.getPosition());
	}
}
