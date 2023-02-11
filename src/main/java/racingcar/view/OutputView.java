package racingcar.view;

import racingcar.domain.vo.CarStatus;

import java.util.List;


public class OutputView {

    private static final String RESULT_MESSAGE = "\n실행 결과";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";


    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printHeadResult(List<CarStatus> roundResult) {
        System.out.println(RESULT_MESSAGE);
        printRoundResult(roundResult);
    }

    public static void printRoundResult(List<CarStatus> roundResult) {
        roundResult.forEach(OutputView::printResult);
        System.out.println();
    }

    public static void printFinalResult(List<String> winnerNames) {
        System.out.println(String.join(",", winnerNames) + WINNER_MESSAGE);
    }

    private static void printResult(CarStatus carStatus) {
        System.out.println(carStatus.getName() + " : " + drawDrivingDistance(carStatus.getPosition()));
    }

    private static String drawDrivingDistance(int position) {
        StringBuilder drivingDistance = new StringBuilder();
        for (int i = 0; i < position; i++) {
            drivingDistance.append("-");
        }
        return drivingDistance.toString();
    }

}
