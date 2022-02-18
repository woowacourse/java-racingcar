package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Name;

public class OutputView {

    private static final String EXECUTE_RESULT = "실행 결과";
    private static final String WINNER_RESULT_DELIMITER = ",";
    private static final String ROAD = "-";
    private static final String WINNER_RESULT_MESSAGE = "(이)가 최종 우승하였습니다.";

    public static void announceRacingStart() {
        System.out.println(EXECUTE_RESULT);
    }

    public static void recordCurrentScore(Cars cars) {
        for (Car car : cars.getParticipantCars()) {
            System.out.println(car.getName() + " : " + ROAD.repeat(car.getPosition().getCurrentPosition()));
        }
        System.out.println();
    }

    public static void recordRacingWinners(List<Name> winners) {
        System.out.println(winners.stream()
            .map(Name::toString)
            .collect(Collectors.joining(WINNER_RESULT_DELIMITER)) + WINNER_RESULT_MESSAGE);
    }
}
