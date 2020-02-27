package racing.view;

import racing.model.Car;
import racing.model.CarLineUp;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String COLON = " : ";
    private static final String DASH = "-";
    private static final String INPUT_CAR_NAMES_GUIDE_MESSAGE = "경주할 자동차 이름을 입력하세(이름은 쉼표(,)를 기준으로 구분)";
    private static final String INPUT_TRIAL_TIME_GUIDE_MESSAGE = "시도할 횟수는 몇회인가요?";
    private static final String RESULT_HEADING = "실행 결과";
    private static final String WINNER_SUB_MESSAGE = "가 최종 우승했습니다.";
    private static final String COMMA = ", ";
    private static final String NEW_LINE = System.lineSeparator();
    public static final int START_INDEX = 0;

    public static void printInputCarNamesMessage() {
        System.out.println(INPUT_CAR_NAMES_GUIDE_MESSAGE);
    }

    public static void printInputTrialTimeMessage() {
        System.out.println(INPUT_TRIAL_TIME_GUIDE_MESSAGE);
    }

    public static void printExceptionMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void printResultMessage() {
        System.out.println(RESULT_HEADING);
    }

    public static void printWinners(final List<Car> winners) {
        String winnersName = winners.stream()
                                    .map(Car::toString)
                                    .collect(Collectors.joining(COMMA));
        System.out.println(winnersName + WINNER_SUB_MESSAGE);
    }

    public static void printOneRoundResult(final CarLineUp lineUp) {
        for (Car car : lineUp.getLineUp()){
            StringBuilder result = new StringBuilder();
            result.append(car)
                    .append(COLON);
            presentPositionByDash(result, car.getPosition());
            System.out.println(result);
        }
        System.out.print(NEW_LINE);
    }

    private static void presentPositionByDash(final StringBuilder result, final int currentPosition) {
        for (int index = START_INDEX; index < currentPosition; index++){
            result.append(DASH);
        }
    }
}
