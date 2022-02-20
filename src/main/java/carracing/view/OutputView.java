package carracing.view;

import carracing.dto.CarDto;
import carracing.view.messages.ExceptionMessage;
import carracing.view.messages.OutputMessage;

import java.util.List;

public class OutputView {
    private static final String DELIMITER_BETWEEN_NAME_AND_POSITION = ":";
    private static final String POSITION_INDICATOR = "-";
    private static final String WINNER_DELIMITER = ",";

    private OutputView() {
    }

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


    public static void printGameResult(List<CarDto> cars) {
        cars.forEach(car -> System.out.println(visualizeCarPosition(car)));
        printNewLine();
    }

    private static String visualizeCarPosition(CarDto car) {
        return car.getName() + DELIMITER_BETWEEN_NAME_AND_POSITION + POSITION_INDICATOR.repeat(car.getPosition());
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.println(String.join(WINNER_DELIMITER, winners) + OutputMessage.FINAL_WINNER_MESSAGE.getMessage());
    }
}
