package racing.view;

import java.util.List;
import racing.domain.Car;
import racing.domain.Cars;

public class OutputView {
    public static final String GAME_RESULT_FORMAT = "%s : %s\n";
    public static final String WINNER_FORMAT = "%s가 최종 우승했습니다.\n";
    private static final String POSITION_VIEW = "-";
    public static final String WINNER_DELIMITER = ", ";

    public static void printRacing(Cars cars) {
        for (Car car : cars.getCars()) {
            int position = car.getPosition();
            String positionView = POSITION_VIEW.repeat(position);
            System.out.printf(GAME_RESULT_FORMAT, car.getName(), positionView);
        }
        System.out.println();
    }

    public static void printWinners(List<String> names) {
        String winners = String.join(WINNER_DELIMITER, names);
        System.out.printf(WINNER_FORMAT, winners);
    }
}
