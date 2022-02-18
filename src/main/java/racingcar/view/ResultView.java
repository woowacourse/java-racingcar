package racingcar.view;

import java.util.List;
import racingcar.domain.Car;
import racingcar.utils.GameMessage;

public class ResultView {

    private static final String POSITION_FLAG = "-";
    private static final String JOIN_REGEX = ", ";

    public static void printPosition(List<Car> cars) {
        System.out.println();

        for (Car car : cars) {
            String position = makePositionString(car.getPosition());
            System.out.printf("%-5s : %s\n", car.getName(), position);
        }

    }

    public static void printWinners(List<String> winnerNames) {

        System.out.println(GameMessage.PRINT_RESULT_MESSAGE);
        System.out.print(String.join(JOIN_REGEX, winnerNames));
        System.out.println(GameMessage.PRINT_WINNER_MESSAGE);

    }

    private static String makePositionString(int position) {

        String positionFlag = POSITION_FLAG;
        return positionFlag.repeat(position);
    }

}