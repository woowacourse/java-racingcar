package view.output;

import domain.Car;
import util.Finder;

import java.util.List;

public class OutputView {

    private static final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_COUNT = "시도할 회수는 몇회인가요?";
    private static final String FINAL_WINNER = "가 최종 우승했습니다.";
    private static final String EXECUTE_RESULT = "실행 결과";
    private static final String COLON = " : ";
    private static final String HYPHEN = "-";
    private static final String COMMA = ", ";

    public static void printInputCarName() {
        System.out.println(INPUT_CAR_NAME);
    }

    public static void printCount() {
        System.out.println(INPUT_COUNT);
    }

    public static void printPhrase() {
        System.out.println();
        System.out.println(EXECUTE_RESULT);
    }

    public static void printStep(List<Car> cars) {
        for (Car car : cars) {
            printCarState(car);
        }
    }

    private static void printCarState(Car car) {
        System.out.print(car.getName() + COLON);
        printHyphen(car);
        System.out.println();
    }

    private static void printHyphen(Car car) {
        for (int step = 0; step < car.getStep(); step++) {
            System.out.print(HYPHEN);
        }
    }

    public static void printResult(List<Car> cars) {
        int winnerStep = Finder.findMaxStep(cars);
        StringBuilder winnersWithComma = findWinners(cars, winnerStep);
        System.out.println(commaRemover(winnersWithComma) + FINAL_WINNER);
    }

    private static StringBuilder findWinners(List<Car> cars, int winnerStep) {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            addWinner(car, winnerStep, sb);
        }
        return sb;
    }

    private static void addWinner(Car car, int winnerStep, StringBuilder sb) {
        if(car.getStep() == winnerStep){
            sb.append(car.getName()).append(COMMA);
        }
    }

    private static StringBuilder commaRemover(StringBuilder sb) {
        sb.deleteCharAt(sb.toString().length() - 1);
        sb.deleteCharAt(sb.toString().length() - 1);
        return sb;
    }
}
