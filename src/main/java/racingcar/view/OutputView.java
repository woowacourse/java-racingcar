package racingcar.view;

import java.util.List;
import racingcar.dto.CarPositionDto;

public class OutputView {

    private static final String WINNER_GUIDE_MESSAGE = "가 최종 우승했습니다.";
    private static final String WINNER_DELIMITER = ", ";
    private static final String STATUS_GUIDE_MESSAGE = "실행 결과";
    private static final String COLON = " : ";
    private static final String CAR_POSITION = "-";

    private OutputView() {
    }

    public static void printStatusGuide() {
        System.out.println();
        System.out.println(STATUS_GUIDE_MESSAGE);
    }

    public static void printStatus(List<CarPositionDto> racingStatus) {
        racingStatus.forEach(OutputView::printOneStatus);
        System.out.println();
    }

    private static void printOneStatus(CarPositionDto racingStatus) {
        System.out.print(racingStatus.getCarName());
        System.out.print(COLON);

        for (int i = 0; i < racingStatus.getStatus(); i++) {
            System.out.print(CAR_POSITION);
        }
        System.out.println();
    }

    public static void printWinner(List<String> winners) {
        System.out.print(String.join(WINNER_DELIMITER, winners));
        System.out.println(WINNER_GUIDE_MESSAGE);
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
