package view;

import dto.CarDTO;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {
    private final char newLine = '\n';
    private final String INPUT_CAR_NAME_GUIDE_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private final String INPUT_TRY_COUNT_GUIDE_MESSAGE = "시도할 회수는 몇회인가요?";

    private final String CAR_INFO_FORMAT_DELIMITER = " : ";
    private final char CAR_POSITION_MESSAGE = '-';

    private final String RESULT_GUIDE_MESSAGE = "실행결과";
    private final String RESULT_FORMAT_DELIMITER = ", ";
    private final String RESULT_WINNER_GUIDE_MESSAGE = "가 최종 우승했습니다.";

    public void printCarNameMessage() {
        System.out.println(INPUT_CAR_NAME_GUIDE_MESSAGE);
    }

    public void printTryCountMessage() {
        System.out.println(INPUT_TRY_COUNT_GUIDE_MESSAGE);
    }

    public void printCurrentResult(List<CarDTO> cars) {
        for (CarDTO car: cars) {
            printCarInfo(car);
        }
        System.out.print(newLine);
    }

    public void printResultGuideMessage() {
        System.out.println(RESULT_GUIDE_MESSAGE);

    }

    private void printCarInfo(CarDTO car) {
        System.out.print(car.getName() + CAR_INFO_FORMAT_DELIMITER);
        for (int start = 0; start < car.getDistance(); start++) {
            System.out.print(CAR_POSITION_MESSAGE);
        }
        System.out.print(newLine);
    }

    private void printWinners(List<String> winners) {
        StringJoiner winnerPrintFormat = new StringJoiner(RESULT_FORMAT_DELIMITER);
        for (String winner : winners) {
            winnerPrintFormat.add(winner);
        }
        System.out.print(winnerPrintFormat + RESULT_WINNER_GUIDE_MESSAGE);
    }

    public void printFinalResult(List<CarDTO> cars, List<String> winners) {
        printCurrentResult(cars);
        printWinners(winners);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
        System.out.print(newLine);
    }
}
