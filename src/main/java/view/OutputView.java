package view;

import domain.Car;
import domain.Cars;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {
    private static final char newLine = '\n';
    private static final String INPUT_CAR_NAME_GUIDE_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_TRY_COUNT_GUIDE_MESSAGE = "시도할 회수는 몇회인가요?";

    private static final String CAR_INFO_FORMAT_DELIMITER = " : ";
    private static final char CAR_POSITION_MESSAGE = '-';

    private static final String RESULT_GUIDE_MESSAGE = "실행결과";
    private static final String RESULT_FORMAT_DELIMITER = ", ";
    private static final String RESULT_WINNER_GUIDE_MESSAGE = "가 최종 우승했습니다.";

    public void printCarNameMessage() {
        System.out.println(INPUT_CAR_NAME_GUIDE_MESSAGE);
    }

    public void printTryCountMessage() {
        System.out.println(INPUT_TRY_COUNT_GUIDE_MESSAGE);
    }

    public void printCurrentResult(Cars cars) {
        for (Car car : cars.getCars()) {
            printCarInfo(car);
        }
        System.out.print(newLine);
    }

    public void printResultGuideMessage() {
        System.out.println(RESULT_GUIDE_MESSAGE);
    }

    private void printCarInfo(Car car) {
        System.out.print(car.getCarName() + CAR_INFO_FORMAT_DELIMITER);
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

    public void printFinalResult(Cars cars, List<String> winners) {
        printCurrentResult(cars);
        printWinners(winners);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
        System.out.print(newLine);
    }
}