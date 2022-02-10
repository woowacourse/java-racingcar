package carracing.view;

import carracing.view.messages.OutputMessage;

public class OutputView {
	public static void printInputCarName(){
		System.out.println(OutputMessage.INPUT_CAR_NAME);
	}

	public static void printException(String message) {
		System.out.println(OutputMessage.ERROR_MESSAGE + message);
	}
}
