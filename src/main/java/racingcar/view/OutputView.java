package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {
    StringBuffer stringBuffer = new StringBuffer();

    private static final String CAR_POSITION_SIGN = "-";
    private static final String COLON = " : ";
    private static final String RESULT_POSTFIX = "가 최종 우승했습니다.";

    public void printPosition(List<Car> cars) {
        for (Car car: cars) {
            stringBuffer.append(car.getName());
            stringBuffer.append(COLON);
            stringBuffer.append(CAR_POSITION_SIGN.repeat(car.getPosition()));
            System.out.println(stringBuffer);
            stringBuffer.setLength(0);
        }
        enterLine();
    }

    public void printWinners(List<String> winnerNames) {
        String winnerString = stringifyWinners(winnerNames);
        System.out.print(winnerString);
        System.out.println(RESULT_POSTFIX);
    }

    private static String stringifyWinners(List<String> winners) {
        int beginIndex = 1;
        int endIndex = winners.toString().length() - 1;
        return winners.toString().substring(beginIndex, endIndex);
    }

    public void printError(Exception error) {
        System.out.println(error.getMessage());
    }

    public void enterLine() {
        System.out.println();
    }

}
