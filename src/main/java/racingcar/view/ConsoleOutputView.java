package racingcar.view;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class ConsoleOutputView implements OutputView {
    private static final String RESULT_MSG = "실행 결과";
    private static final String POSITION_FORM = "%s : %s";
    private static final String TRACE = "-";
    private static final String WINNER_MSG = "%s가 최종 우승했습니다.";

    public void printCarPosition(final Cars cars) {
        for(Car car : cars.getCars()) {
            final String name = car.getName();
            final String traces = makeTraces(car.getMovement());
            System.out.println(String.format(POSITION_FORM, name, traces));
        }
        System.out.println();
    }

    private String makeTraces(final int count) {
        return TRACE.repeat(count);
    }

    public void printWinners(final List<Car> winners) {
        List<String> winnerNames = winners.stream().map(Car::getName).toList();
        final String names = String.join(", ", winnerNames);
        System.out.println(String.format(WINNER_MSG, names));
    }

    public void printResultMsg() {
        System.out.println(RESULT_MSG);
    }

//    public void printErrorMsg(String errorMsg) {
//        System.out.println(errorMsg);
//    }
}
