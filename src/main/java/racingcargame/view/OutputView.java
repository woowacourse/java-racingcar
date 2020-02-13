package racingcargame.view;

import racingcargame.domain.Car;
import racingcargame.domain.RacingCars;
import racingcargame.domain.Winners;

import java.util.List;

public class OutputView {
    private static final String DISTANCE = "-";
    private static final String COLON = " : ";
    private static final String WINNERS_PRINT_TAIL = "가 최종 우승했습니다.";
    private static final String DELIMITER = ",";
    private static final String NEW_LINE = "\n";
    private static final String POSITION_PRINT_HEADER = "실행 결과";


    public static void printWinners(Winners winners) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.join(DELIMITER, winners.getNames()));
        sb.append(WINNERS_PRINT_TAIL);
        System.out.println(sb.toString());
    }

    public static String printPosition(Car car) {
        StringBuilder sb = new StringBuilder();
        sb.append(car.getName() + COLON);
        int position = car.getPosition();
        for (int i = 0; i < position; i++) {
            sb.append(DISTANCE);
        }
        sb.append(NEW_LINE);
        return sb.toString();
    }

    public static void printPosition(RacingCars cars) {
        List<Car> racingCars = cars.getUnmodifiableCars();
        StringBuilder sb = new StringBuilder();
        for (Car car : racingCars) {
            sb.append(OutputView.printPosition(car));
        }
        System.out.println(sb.toString());
    }

    public static void printHead() {
        System.out.println(POSITION_PRINT_HEADER);
    }
}
