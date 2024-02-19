package view;

import domain.Cars;

public class OutputView {

    private static final String MOVE_RESULT_FORMAT = "%s : %s\n";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    public static void printMoveResultMessage() {
        System.out.println(LINE_SEPARATOR + "실행 결과");
    }

    public static void printMoveResult(Cars cars) {
        cars.getCars().forEach(car ->
                System.out.printf(MOVE_RESULT_FORMAT, car.getName(), "-".repeat(car.getLocation())));
        System.out.println();
    }
}
