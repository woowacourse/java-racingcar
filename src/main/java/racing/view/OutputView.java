package racing.view;

import racing.domain.Car;
import racing.domain.Race;

import java.util.List;

public class OutputView {
    public static void printTrialRequest() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printRaceStartMessage() {
        System.out.println("\n실행 결과");
    }

    public static void printProgress(final Race race) {
        for (Car car : race.getCars()) {
            printCar(car);
        }
        printNewLine();
    }

    public static void printCar(final Car car) {
        String positionBars = "";
        for (int i = 0; i < car.getPosition(); i++) {
            positionBars += "-";
        }
        System.out.println(car.getName() + " : " + positionBars);
    }

    public static void printResult(final List<String> winnerNames) {
        String joinedNames = String.join(", ", winnerNames);
        System.out.println(String.join("\n", joinedNames + "가 최종 우승했습니다."));
    }

    public static void printNewLine() {
        System.out.println();
    }
}
