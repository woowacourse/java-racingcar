package racingcar.view;

import racingcar.domain.car.CarName;
import racingcar.domain.car.CarState;
import racingcar.domain.car.CarStates;
import racingcar.domain.game.ExecutionResult;
import racingcar.domain.game.Winners;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String POINTER = "-";
    private static final String DELIMITER = ", ";
    private static final String NEW_LINE = System.lineSeparator();
    private static final String EXECUTION_RESULT = "실행 결과" + NEW_LINE;
    private static final String MESSAGE_GAME_RESULT = "가 최종 우승했습니다.";

    public static void printError(RuntimeException runtimeException) {
        System.out.printf(runtimeException.getMessage());
    }
    public static void printRequestCarName() {
        System.out.println(Messages.REQUEST_CAR_NAME.getMessage());
    }

    public static void printRequestMoveCount() {
        System.out.printf(Messages.REQUEST_MOVE_COUNT.getMessage());
    }

    public static void printExecutionResult(ExecutionResult executionResult) {
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append(EXECUTION_RESULT);
        stringBuffer.append(String.join(NEW_LINE.repeat(2),
                executionResult.getCarStatesLog().stream()
                        .map(OutputView::carStatesToString)
                        .collect(Collectors.toList())));
        stringBuffer.append(NEW_LINE.repeat(2));

        System.out.printf(stringBuffer.toString());
    }

    private static String carStatesToString(CarStates carStates) {
        return String.join(
                NEW_LINE,
                carStates.getCarStates().stream()
                        .map(OutputView::CarStateToString)
                        .collect(Collectors.toList())
        );
    }

    private static String CarStateToString(CarState carState) {
        CarName carName = carState.getCarName();
        int position = carState.getPosition();

        return carName.toString() + " : " + createLines(position);
    }

    private static String createLines(int position) {
        return String.valueOf(new char[position]).replace("\0", POINTER);
    }

    public static void printWinners(Winners winners) {
        List<String> winnerNames = winners.getWinners().stream()
                .map(CarName::toString)
                .collect(Collectors.toList());

        System.out.println(String.join(DELIMITER, winnerNames) + MESSAGE_GAME_RESULT);
    }
}