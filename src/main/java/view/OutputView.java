package view;

import java.util.List;
import model.Car;

public class OutputView {

    private static final String RESULT_FORMAT = "%s : %s";
    private static final String STEP = "-";
    private static final String DELIMITER = ",";

    private OutputView() {
    }

    public static void printResultHeader() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printTotalResult(List<Car> carDtos) {
        carDtos.forEach(OutputView::printMovement);
        System.out.println();
    }

    private static void printMovement(Car carDto) {
        System.out.println(String.format(RESULT_FORMAT, carDto.getCarName(), STEP.repeat(carDto.getMovement())));
    }

    public static void printWinner(List<String> winners) {
        System.out.print(String.join(DELIMITER, winners) + "가 최종 우승했습니다.");
    }
}
