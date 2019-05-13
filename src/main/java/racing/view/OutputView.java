package racing.view;

import racing.domain.Car;
import racing.domain.Race;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
    public static void printRaceStartMessage() {
        System.out.println("\n실행 결과");
    }

    public static void printErrMsg(String message) {
        System.out.println(message);
    }

    public static void printCar(final Car c) {
        String positionBars = "";
        for (int i = 0; i < c.getPosition(); i++) {
            positionBars += "-";
        }
        System.out.println(c.getName() + " : " + positionBars);
    }

    public static void printRace(final Race race) {
        for (Car c : race.getCars()) {
            printCar(c);
        }
        System.out.println();
    }

    public static void printWinners(final List<Car> winners) {
        List<String> result = new ArrayList<>();
        for (Car c : winners) {
            result.add(c.getName());
        }
        System.out.println(String.join(", ", result) + "가 최종 우승했습니다.");
    }
}
