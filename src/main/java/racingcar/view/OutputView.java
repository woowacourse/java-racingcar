package racingcar.view;

import racingcar.dto.CarDto;

import java.util.List;

public class OutputView {

    private static final String DELIMITER = ", ";
    private static final String PROGRESS_SYMBOL = "-";

    private OutputView() {
    }

    public static void startMessage() {
        printLine();
        System.out.println("실행 결과");
    }

    public static void printLine() {
        System.out.println();
    }

    public static void printProgress(CarDto car) {
        String carName = car.getCarName();
        int position = car.getPosition();

        String positionSign = PROGRESS_SYMBOL.repeat(position);

        System.out.println(carName + " : " + positionSign);
    }

    public static void printWinners(List<String> winners) {
        System.out.print(String.join(DELIMITER, winners));
        System.out.println("가 최종 우승했습니다.");
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
