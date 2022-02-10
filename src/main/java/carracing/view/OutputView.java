package carracing.view;

import carracing.view.messages.OutputMessage;

public class OutputView {
	public static void printInputCarName(){
		System.out.println(OutputMessage.INPUT_CAR_NAME.getMessage());
	}

	public static void printInputNumberOfGames(){
		System.out.println(OutputMessage.INPUT_NUM_OF_GAMES.getMessage());
	}

	public static void printException(String message) {
		System.out.println(OutputMessage.ERROR_MESSAGE + message);
	}

	public static void printResultMessage() {
		System.out.println(OutputMessage.RESULT_MESSAGE.getMessage());
	}

	public static void printCarPosition(String carPosition) {
		System.out.println(carPosition);
	}

	public static void printNewLine() {
		System.out.println();
	}
}
