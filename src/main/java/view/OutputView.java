package view;

import model.Car;

import java.util.List;

public class OutputView {

    private static final String COLON = " : ";
    private static final String BLANK = "\0";
    private static final String SCORE_BAR = "-";
    private static final String COMMA = ",";
    private static final String EXECUTION_RESULT_MESSAGE = " 가 우승했습니다.";
    private static final String BEGIN_RESULT_MESSAGE = "실행 결과";

    public static void printScore(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + COLON + printPositionBar(car));
        }
        System.out.println();
    }

    public static String printPositionBar(Car car) {
        int position = car.getPosition();
        return makePositionBar(position);
    }

    private static String makePositionBar(int position) {
        return new String(new char[position]).replace(BLANK, SCORE_BAR);
    }

    public static void printWinners(List<String> winners) {
        String winner = String.join(COMMA, winners);
        System.out.println(winner + EXECUTION_RESULT_MESSAGE);
    }

    public static void printBeginResult() {
        System.out.println(BEGIN_RESULT_MESSAGE);
    }
}
