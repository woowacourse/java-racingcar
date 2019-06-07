package racingcargame.view;

import racingcargame.model.Car;
import racingcargame.model.Cars;
import racingcargame.model.Winners;

import java.util.ArrayList;
import java.util.List;

public class OutputView {

    public static void printResult(int result) {
        System.out.println("답은 " + result + " 입니다!");
    }

    public static void printCarMovements(Cars resultCars) {
        for (Car car : resultCars.getCars()) {
            System.out.print(car.getName() + ":");
            printPosition(car.getPosition());
        }
        System.out.println();
    }

    private static void printPosition(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printWinners(Winners winners) {
        List<String> names = new ArrayList<>();
        for (Car car : winners.getWinners()) {
            names.add(car.getName());
        }
        String winnersNames = String.join(",", names);
        System.out.println(winnersNames + " 가 우승했습니다!");
    }

    public static void printResultSentence() {
        System.out.println("실행결과");
    }

    public static void printTurnsErrorMessage() {
        System.out.println("잘못된 Turns입력값입니다");
    }
}
