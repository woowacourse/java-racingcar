package view;

import java.util.List;
import view.dto.CarDto;

public class OutputView {

    private static final String RESULT_FORMAT = "%s : %s";
    private static final String STEP = "-";
    private static final String DELIMITER = ",";

    public void printResultHeader() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printTotalResult(List<CarDto> carDtos) {
        carDtos.forEach(OutputView::printMovement);
        System.out.println();
    }

    private static void printMovement(CarDto carDto) {
        System.out.println(String.format(RESULT_FORMAT, carDto.getCarName(), STEP.repeat(carDto.getMovement())));
    }

    public void printWinner(List<CarDto> winners) {
        List<String> winnerNames = winners.stream().map(CarDto::getCarName).toList();
        System.out.print(String.join(DELIMITER, winnerNames) + "가 최종 우승했습니다.");
    }
}
